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
Pinos digitais só aceitam os valores 1 ou 0, ou true/false, ou HIGH / LOW. As três formas são equivalentes.
Para configurar, use a função:

`pinMode(<pino>, INPUT/OUTPUT)`

Os pinos digitais são numerador de 0 a 13.
Os pinos 0 e 1 são usados na comunicação serial pela USB. Evite de usar estes pinos.

### Programas


Piscar LED básico
```c
#define pinLed  13

void setup() {
  pinMode(pinLed, OUTPUT);

}

void loop() {
  digitalWrite(pinLed, HIGH);
  delay(30);
  digitalWrite(pinLed, LOW);
  delay(30);
}
```

Função `millis()`
`unsigned long millis()`
`unsigned long micros()`

Código sem bloqueio do processamento
```c
#define pinLed  13
#define lapse   100

unsigned long nextBlink = 0;
boolean ledVal = true;

void setup() {
  pinMode(pinLed, OUTPUT);

}

void loop() {

  if (millis() >= nextBlink)
  {
    digitalWrite(pinLed, ledVal);
    ledVal = !ledVal;
    nextBlink = millis() + lapse;
  }
}
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTcyMjM3NjQ0LC0xODgyMjE0ODY4LC0xMj
YzOTE3NzcyLDI0NDQ2MzY2OCwtMTMyNzgyOTM4NCw1OTE1NjM5
MDBdfQ==
-->