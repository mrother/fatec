//=============================================================================
// CLIENTE.C
// Exemplo de uso do mecanismo de comunica��o por Socket - UDP
// Programa que envia e recebe uma mensagem para outro processo via socket
// Prof. Dr. Jose Luis Zem
//=============================================================================

#include "./local.h"

void help()
{
    printf("\ndate: Retorna a data do servidor\n");
    printf("time: Retorna a hora do servidor\n");
    printf("nodename: Retorna o nome do nó do servidor\n");
    printf("sysname: Retorna o nome do sistema do servidor\n");
    printf("release: Retorna a liberação do sistema do servidor\n");
    printf("version: Retorna a versão do sistema do servidor\n");
    printf("machine: Retorna o nome da máquina do servidor\n");
    printf("shutdown: Encerra a execução das aplicações CLIENTE e SERVIDOR\n");
    printf("credits: Exibe o nome completo de todos os participantes da equipe\n");
    printf("exit: Encerra a execução da aplicação CLIENTE\n");
    printf("help: Exibe um auxílio sobre os buffers existentes\n");
}

int main(int argc, char* argv[])
{
    int socket_servidor, bytes_enviados, bytes_recebidos;
    struct sockaddr_in servidor;
    int tamanho_servidor = sizeof(servidor);
    char buffer[MAX_SIZE_BUFFER];
    char* p = NULL;

    socket_servidor = socket(AF_INET, SOCK_DGRAM, 0);

    // bzero(&servidor, sizeof(servidor));
    memset(servidor.sin_zero, '\0', sizeof servidor.sin_zero); 
    servidor.sin_family = AF_INET;
    servidor.sin_port = htons(PORT);
    servidor.sin_addr.s_addr = inet_addr(argv[1]);

    printf(ANSI_COLOR_GREEN "Conectando na porta %i\n", PORT);
    while (1) {
        printf(ANSI_COLOR_GREEN ">> " ANSI_COLOR_RESET );
        fgets(buffer, MAX_SIZE_BUFFER, stdin);
        if ((p = strchr(buffer, '\n')) != NULL)
            *p = '\0';

        if (strcmp(buffer, "exit") == 0) {
            return 0;
        } else if (strcmp(buffer, "help") == 0) {
            help();
            continue;
        }

        bytes_enviados = sendto(socket_servidor, buffer, MAX_SIZE_BUFFER, 0, (struct sockaddr*)&servidor, sizeof(servidor));
        bytes_recebidos = recvfrom(socket_servidor, buffer, MAX_SIZE_BUFFER, 0, (struct sockaddr*)&servidor, &tamanho_servidor);
        if (strcmp(buffer, "byebye") == 0)
            return 0;

        printf(ANSI_COLOR_YELLOW "<< %s\n" ANSI_COLOR_RESET, buffer);
    }

    close(socket_servidor);

    return 0;
}
