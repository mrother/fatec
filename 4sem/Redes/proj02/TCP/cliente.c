//=============================================================================
// CLIENTE00.C
// Exemplo de uso do mecanismo de comunica��o por Socket - TCP
// Programa que envia e recebe uma mensagem para outro processo via socket
// Prof. Dr. Jose Luis Zem
//=============================================================================

#include "./local.h"

int main(int argc, char* argv[])
{
    int socket_servidor, bytes_recebidos;
    struct sockaddr_in servidor;
    char buffer[MAX_SIZE_BUFFER];
    char* ptr = NULL;

    while (1) {
        socket_servidor = socket(AF_INET, SOCK_STREAM, 0);

        bzero(&servidor, sizeof(servidor));
        servidor.sin_family = AF_INET;
        servidor.sin_port = htons(PORT);

        inet_aton(argv[1], &servidor.sin_addr.s_addr);

        connect(socket_servidor, (struct sockaddr*)&servidor, sizeof(servidor));
        printf("Comando: ");
        fgets(buffer, MAX_SIZE_BUFFER, stdin);
        if ((ptr = strchr(buffer, '\n')) != NULL)
            *ptr = '\0';

        if (strcmp(buffer, "exit") == 0) {
            return 0;
        } else if (strcmp(buffer, "help") == 0) {
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
            continue;
        }

        send(socket_servidor, buffer, MAX_SIZE_BUFFER, 0);
        bytes_recebidos = recv(socket_servidor, buffer, MAX_SIZE_BUFFER, 0);

        if (strcmp(buffer, "shutdown") == 0)
            return 0;

        printf("Retorno: %s\n", buffer);
        close(socket_servidor);
    }

    return 0;
}
