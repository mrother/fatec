//=============================================================================
// SERVIDOR.C
// Exemplo de uso do mecanismo de comunica��o por Socket - UDP
// Programa que recebe e envia uma mensagem para outro processo via socket
// Prof. Dr. Jose Luis Zem
//=============================================================================

#include "./local.h"
#include <sys/utsname.h>
#include <time.h>

char* credits()
{
    char* credits = malloc(sizeof(char) * 1000);
    strcpy(credits, "\n===========================\nTerminal Remoto de Comandos\n===========================\n* Antonio Carlos Lima\n* Mauricio Pierangeli de Albuquerque Rother\n");
    return credits;
}

void gravalog(char* dados)
{
    FILE* fp;
    char buff[30];
    struct tm* sTm;

    time_t now = time(0);
    sTm = gmtime(&now);

    strftime(buff, sizeof(buff), "%Y-%m-%d | %H:%M:%S", sTm);

    fp = fopen("servidor.log", "a");
    fprintf(fp, "%s | %s\n", buff, dados);
    printf("%s | %s\n", buff, dados);
    fclose(fp);
}

int main(int argc, char* argv[])
{
    int socket_servidor, socket_cliente, bytes_recebidos, bytes_enviados;
    struct sockaddr_in servidor, cliente;
    int tamanho_cliente = sizeof(cliente);
    int tamanho_servidor = sizeof(servidor);
    char buffer[MAX_SIZE_BUFFER];
    struct utsname uts;
    struct tm* sTm;

    time_t now = time(0);
    sTm = gmtime(&now);

    uname(&uts);

    socket_servidor = socket(AF_INET, SOCK_DGRAM, 0);

    //bzero(&servidor, sizeof(servidor));
    memset(servidor.sin_zero, '\0', sizeof servidor.sin_zero); 
    servidor.sin_family = AF_INET;
    servidor.sin_port = htons(PORT);
    servidor.sin_addr.s_addr = htonl(INADDR_ANY);

    bind(socket_servidor, (struct sockaddr*)&servidor, tamanho_servidor);
    printf(ANSI_COLOR_GREEN "Aguardando conexões na porta %i...\n" ANSI_COLOR_RESET, PORT);

    while (1) {

        bytes_recebidos = recvfrom(socket_servidor, buffer, MAX_SIZE_BUFFER, 0, (struct sockaddr*)&cliente, &tamanho_cliente);
        gravalog(buffer);

        if (strcmp(buffer, "date") == 0) {
            strftime(buffer, sizeof(buffer), "%d/%m/%Y", sTm);
        } else if (strcmp(buffer, "time") == 0) {
            strftime(buffer, sizeof(buffer), "%H:%M:%S", sTm);
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
            bytes_enviados = sendto(socket_servidor, "byebye", MAX_SIZE_BUFFER, 0, (struct sockaddr*)&cliente, tamanho_cliente);
            printf(ANSI_COLOR_RED "\nEncerrando servidor. Bye!\n" ANSI_COLOR_RESET);
            return 0;
        } else {
            strcpy(buffer, "Comando inválido!");
        }

        bytes_enviados = sendto(socket_servidor, buffer, MAX_SIZE_BUFFER, 0, (struct sockaddr*)&cliente, tamanho_cliente);
    }

    close(socket_servidor);

    return 0;
}
