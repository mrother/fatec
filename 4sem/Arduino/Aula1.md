# Arduino UNO

### Placa contém:
- Micro controlador ATMega328
- Estabilizador de voltagem 5v
	- Entrada de 7v a 12v
	- Saída de 5v
- Conectores de acesso aos pinos
- Suporte USB
	- Carregar programas
	- Comunicação com o computador

### Micro controlador
- CPU roda a 16 MHz
- Memória
- Flash - 32Kb (4Kb bootloader)
- Memória RAM 2Kb
- Memória EPROM 1Kb
- 20 pinos de E/S
	- 14 Digitais
	- 6 Analógicas
- 3 Timers de hardware

# Programação

## Linguagem Wiring (script para C++)

-Programa roda dentro de um loop infinito
	- Rotina `setup()`
		- É executada 1 vez quando o Arduino é ligado. A serguir, a execução vai para a função `loop()`, de onde não sai mais.
	- Rotina Loop()

### Pinos Digitais
São 14 pinos digitais que podem ser configurados como entrada ou saída.
Pinos digitais só aceitam 
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTU0NjAwMzE0NiwyNDQ0NjM2NjgsLTEzMj
c4MjkzODQsNTkxNTYzOTAwXX0=
-->