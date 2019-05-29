//=============================================================================
// SERVIDOR.C
// Exemplo de uso do mecanismo de comunica��o por Socket - TCP
// Programa que recebe e envia uma mensagem para outro processo via socket
// Prof. Dr. Jose Luis Zem
//=============================================================================

#include "./local.h"
#include <sys/utsname.h>
#include <time.h>

char* credits()
{
    char* credits = malloc(sizeof(char) * 1000);
    strcpy(credits, "\nTerminal Remoto de Comandos\n* Nome 1\n* Nome 2\n");
    return credits;
}

int main(int argc, char* argv[])
{
    int socket_servidor, socket_cliente, tamanho_socket, bytes_recebidos;
    struct sockaddr_in cliente;
    struct sockaddr_in servidor;
    char buffer[MAX_SIZE_BUFFER], resp[30];;
    struct utsname uts;
    struct tm* st_datahora;
    FILE* fp;

    time_t now = time(0);
    st_datahora = gmtime(&now);

    uname(&uts);

    tamanho_socket = sizeof(struct sockaddr_in);

    socket_servidor = socket(AF_INET, SOCK_STREAM, 0);

    bzero(&servidor, sizeof(servidor));
    servidor.sin_family = AF_INET;
    servidor.sin_port = htons(PORT);
    servidor.sin_addr.s_addr = INADDR_ANY;

    bind(socket_servidor, (struct sockaddr*)&servidor, sizeof(servidor));

    listen(socket_servidor, 1);

    printf("Servidor aguardando mensagens na porta %d\n", PORT);

    while (1) {
        socket_cliente = accept(socket_servidor, (struct sockaddr*)&cliente, &tamanho_socket);

        bytes_recebidos = recv(socket_cliente, buffer, MAX_SIZE_BUFFER, 0);
        buffer[bytes_recebidos] = '\0';

        strftime(resp, sizeof(resp), "%Y-%m-%d | %H:%M:%S", st_datahora);

        fp = fopen("servidor.log", "a");
        fprintf(fp, "%s | %s\n", resp, buffer);
        printf("%s | %s\n", resp, buffer);
        fclose(fp);

        if (strcmp(buffer, "date") == 0) {
            strftime(buffer, sizeof(buffer), "%d/%m/%Y", st_datahora);
        } else if (strcmp(buffer, "time") == 0) {
            strftime(buffer, sizeof(buffer), "%H:%M:%S", st_datahora);
        } else if (strcmp(buffer, "nodename") == 0) {
            strcpy(buffer, uts.nodename);
        } else if (strcmp(buffer, "sysname") == 0) {
            strcpy(buffer, uts.sysname);
        } else if (strcmp(buffer, "release") == 0) {
            strcpy(buffer, uts.release);
        } else if (strcmp(buffer, "version") == 0) {
            strcpy(buffer, uts.version);
        } else if (strcmp(buffer, "machine") == 0) {
            strcpy(buffer, uts.machine);
        } else if (strcmp(buffer, "credits") == 0) {
            strcpy(buffer, credits());
        } else if (strcmp(buffer, "shutdown") == 0) {
            send(socket_cliente, "shutdown", MAX_SIZE_BUFFER, 0);
            return 0;
        } else {
            strcpy(buffer, "Comando inválido!");
        }

        send(socket_cliente, buffer, MAX_SIZE_BUFFER, 0);
        close(socket_cliente);
    }
    close(socket_servidor);
    return 0;
}