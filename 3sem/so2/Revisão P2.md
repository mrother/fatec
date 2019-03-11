# Exercícios SOII - P2

1. Descreva o serviço oferecido pelo software Apache. Inclua os seguintes itens:
	1.1. O que o software faz
	- O Apache é um servidor Web. A função dele é receber requisições de páginas e, com as informações recebidas, localizar e retornar o documento solicitado para o cliente, geralmente um navegador (browser).

	1.2. Descrição dos protocolos HTTP e HTTPS
	- O protocolo HTTP é um protocolo simples, baseado em mensagens de texto, que são trocadas entre o cliente e o servidor. O cliente inicialmente envia uma string com a versão do protocolo, o método (GET, POST, etc) e o documento a ser recuperado. O servidor processa e responde com um código  (200 para sucesso, 404 para não encontrado, etc) e o documento, caso exista.
	- O protocolo HTTPS utiliza uma camada de segurança utilizando-se um certificado de segurança para trafegar os dados entre o cliente e o servidor

	1.3. Diretivas (conceitos): DocumentRoot, LoadModule, Timeout, KeepAlive, MaxKeepAliveRequests, KeepAliveTimeout, Listen, DirectoryIndex
	- DocumentRoot: Designa qual a pasta padrão onde o servidor deve procurar os documentos solicitados;
	- LoadModule: Carrega um módulo do apache
	- Timeout: Tempo máximo em segundos para fechas as conexões abertas ociosas;
	- KeepAlive: Mantém a conexão aberta para responder várias requisições na mesma conexão;
	- MaxKeepAliveRequests: O número máximo de requisições para enviar por uma única conexão;
	- KeepAliveTimeout: O tempo máximo em segundos para se manter uma conexão ociosa aberta;
	- Listen: A porta em que o servidor vai ouvir as conexões;
	- DiretoryIndex: Permite o servidor Apache a listar o diretório e seus arquivos, caso não haja um documento padrão definido ou no diretório.

    1.4. Como atualizar páginas do servidor. Inclua exemplo com scp.

2. Descreva o conceito de backup. Inclua os seguintes itens:
	2.0. Conceito geral
	- É uma cópia exata dos dados sensíveis de um servidor ou estação de trabalho.
	2.1. Backup total
	2.2. Backup incremental
	2.3. Mídias (tipos, vantagens/desvantagens)
	
3. Não responder
4.  Não responder

5. Descreva o software rsync. Inclua os seguintes itens:
	- O `rsync` é um programa que realiza cópia de arquivos entre servidores utilizando o protocolo ssh.

	5.1. Cópia total x Cópia diferencial
	- **Cópia total**: copia todos os arquivos da origem no destino
	- **Cópia diferencial**: copia apenas os arquivos que foram alterados desde a última cópia.

	5.2. Definição de espelhamento:
	- **Espelhamento** mantém o destino e a origem sincronizados. Pode ser unidirecional (o destino sempre é uma cópia da origem) ou bi-direcional (qualquer alteração na origem e no destino é replicada para o lado oposto).

6. Existem tarefas que devem ser executadas com certa periodicidade. Qual é/são
   o(s) software(s) utilizado(s) para este fim em sistemas GNU/Linux ? Inclua:

	6.1. Nome(s) do(s) software(s)
	- `at` para uma única tarefa
	- `crontab` para tarefas frequentes.

	6.2. Maneira de utilizar

	6.3. Sintaxe de arquivos de configuração (quando houver)

	6.4. Exemplo concreto de uso (passo a passo)

7. O processo de instalação de software em sistemas GNU/Linux varia de 
   distribuição para distribuição. Descreva o procedimento para:

	7.1. Instalação de software no Archlinux
	   * Utiliza-se o software Pacman. Para instalar um pacote, basta usar o comando:
	`pacman -S <software>`

	7.2. Remoção de software no Archlinux
	`pacman -R <software>`

	7.3. Verificação dos pacotes instalados no Archlinux (listagem)
	`pacman -Q`

	7.4. Atualização completa da distribuição
	 `pacman -Syu`
 
8. No processo de instalação de software, alguns problemas podem ocorrer. Para que uma solução possa ser adotada na tentativa de resolver tais problemas, os conceitos a seguir precisam ser conhecidos. Descreva cada um deles:

	8.0. Pacote de software
	* É uma maneira de distribuir o software, onde são "empacotados" em um arquivo o software e suas dependências exclusivas e/ou compartilhadas. Os pacotes de software geralmente possuem metadados sobre quais pacotes eles dependem, licenças e suas respectivas versões.

	8.1. Repositório de pacotes
	- É um servidor que armazena todos os pacotes de software de uma distribuição.

	8.2. Dependência de software
	- São bibliotecas e/ou outros softwares que um determinado software precisa para poder funcionar.

	8.3. Resolução de dependência (manual x automática)
	- Manual: o usuário é responsável por instalar cada uma das dependências;
	- Automática: O gerenciador de pacotes analisa as dependências e as satisfaz automaticamente, se possível, caso contrário, exibe um erro e não instala o pacote desejado.

	8.4. Bibliotecas de software (estáticas x dinâmicas)
	- Bibliotecas são fragmentos de software que realizam uma tarefa especializada, e que são extraídos do software principal com a finalidade de se compartilhar código entre vários programas.
	- Estática: A biblioteca é compilada dentro do programa principal, portanto o mesmo não precisa de nenhum outro arquivo para funcionar.
	- Dinâmica: A biblioteca fica em um arquivo separado, geralmente um caminho compartilhado no sistema operacional.

	8.5. Versões de bibliotecas e softwares.
	8.6. Comando ldconfig
	- O comando `ldconfig` cria os links e o cache necessários para bibliotecas compartilhadas recentemente usadas em /etc/ld.so.cache, de modo que o carregamento dos programas que dependem das bibliotecas dinâmicas fique mais rápido, pois a busca é binária dentro desse arquivo. ***(complementar com a ordem de busca)***

	8.7. Software binário x código fonte
	- **Código fonte** são as instruções digitadas pelo programador, em uma linguagem inteligível por humanos, que dizem de forma estruturada e sequencial, o que o programa deve fazer.
	- **Software binário** é o resultado do processo de _compilação_ do código fonte, que interpreta os comandos e "traduz" para um formato que o computador entenda.

	8.8. Comando make e arquivo Makefile
	- `make`: é um arquivo que automatiza a realização de tarefas, definidas no arquivo Makefile;
	- `Makefile`: é um arquivo texto de formato pré-definido, com instruções para serem realizadas pelo comando make.

	8.9. Comando `strace`
	- Intercepta e exibe todas as chamadas de sistema e sinais emitidos pelo programa informado.

	8.10. Comandos readelf e ldd
	- `readelf`: Exibe informações (metadados) sobre o binário ELF informado.
	- `ldd`: Exibe as bibliotecas dinâmicas as quais o programa informado depende.

	8.11. Diretório /var/cache/pacman/pkg
	- Contém uma cópia de todos os pacotes que foram instalados pelo gerenciador de pacotes *pacman*.
	8.12. Diretório /var/lib/pacman/local/PACOTE-VERSAO/
	- Contém metadados sobre o pacote instalado, descrição (arquivo `desc`), arquivos que foram instalados (arquivo `files`) e 

9. Apresente todas as etapas necessárias para a atualização do 'Linux Kernel' de maneira manual no Archlinux. Inclua TODAS as etapas e EXPLIQUE com detalhes cada uma delas.
- Baixar e descompactar o código fonte do kernel no site kernel.org;
	- `wget https://cdn.kernel.org/pub/linux/kernel/v4.x/linux-4.19.2.tar.xz`
	- `tar xvf linux-4.19.2.tar.xz`
-  Acessar a pasta criada pela descompactação do kernel:
	- `cd linux-4.19.2`
- Configurar o kernel:
	- `make clean && make mrproper`
	- `zcat /proc/config.gz > .config`
	- `make olddefconfig`
	- `make menuconfig`
- Realizar as configurações desejadas, começando por:
	- General Setup
		- Local Version: -rpp 
		- Default hostname: admsoredes
- `make -j 2`
- `make modules_install`
- Copiar os arquivos resultantes para a pasta /boot:
	- `cp arch/x86_64/boot/bzImage /boot/vmlinuz`
	- `cp .config /boot/config`
	- `cp System.map /boot/System.map`
- Gerar uma imagem initramfs:
	- `mkinitcpio -k 4.11.2-rpp -g /boot/initramfs.img`
- Atualizar arquivos de configurações do **GRUB**
- Gerar um `grub.cfg` novo:
	- `grub-mkconfig -o /boot/grub/grub.cfg`
- Reiniciar o computador e escolher o novo kernel

10. Discuta as alterações feitas no kernel durante as aulas com relação a otimização para Servidor e otimização para Desktop.

11. Não responder.

12. Descreva e explique o procedimento para nomear a primeira interface de rede ethernet para eth0 ao invés de enp0s3 no Archlinux.
- Inibe a criação da entrada padrão de rede no systemd
	- `ln -s /dev/null /etc/systemd/network/99-default.link`
- Cria o arquivo de configuração de rede manualmente:
	- `echo '[Match]' > /etc/systemd/network/20-wired.network`
	- `echo 'Name=eth0' >> /etc/systemd/network/20-wired.network`
	- `echo '[Network]' >> /etc/systemd/network/20-wired.network`
	- `echo 'DHCP=ipv4' >> /etc/systemd/network/20-wired.network`

13. Descreva o procedimento completo para renomear a interface de rede eth0 para lan1 no Archlinux.

14. Não responder
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTEwNDM4NTgzMjldfQ==
-->