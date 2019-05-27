## Operador `instanceof`

Determina se um objeto é um não instância de uma classe.
Sintaxe:

`<obj> instanceof <classe>`

O resultado é booleano.

## Array Polimórfico

É um `array` onde o tipo base é uma classe ancestral de outras classes. Este `array` poderá conter objetos da classe ancestral e de todas suas classes descendentes.

## Classe `Object`

É a classe ancestral de todas as classes do Java.
Sempre que uma classe não declara uma classe ancestral, será descendente direta de `Object`.

## Type cast

Literalmente, associação de tipo.
Recurso usado para associar um tipo a um valor, variável ou expressão, mas apenas na expressão em execução. A associação não é permanente.

```java
int a = 10, b = 3;
double r = (double) a / b;
```
---
```java
public void metodo(Object obj) {
	if (obj instanceof Pessoa) {
		Pessoa p = (Pessoa) obj;
		p.print();
	}
}
```

---

## Novo projeto: PoliArray
Classes:
- Contato (nome e fone)
	- Amigo (aniversário) (\*)
	- Cliente (empresa) (\*)
(\*) Método print() - Imprime todos os atributos daquela classe

Classe Agenda
	- Array de Contato
```java
	public boolean add( Contato ct);
	public void printCli() // imprime todos os clientes
	public void printAmigo(); // imprime todos os amigos
```
O construtor de Agenda recebe o tamanho da lista.
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTM1NzM4NDY4Ml19
-->