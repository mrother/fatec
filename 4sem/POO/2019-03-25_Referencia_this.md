# Referência `this`

É uma referência ao objeto, que existe dentro de todos os objetos. Só pode ser usada dentro da classe e serve para resolver conflito de nomes quando ocorrem, para chamar construtores a partir de outros construtores e também como referência ao objeto no argumento de métodos.
A partir do `this` é possível acessar atributos e métodos da classe.

```java
public class Ponto
{
	private double x, y;
	public Ponto(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Ponto(Ponto pt)
	{
		this(pt.x, pt.y);
	}

	public void setX(double x)
	{
		this.x = x;
	}
}
```

## Projeto Cartesiano

**Nova classe**: `Segmento`

Representa um segmento de reta no plano cartesiano. O segmento é definido pelos seus dois pontos extremos (p1 e p2). Use a classe Ponto para p1 e p2

### Construtores

> Todos os construtores precisam criar novas instâncias para p1 e p2.

**Construtor padrão**:
Cria o segmento com as coordenadas (0, 0) para p1 e (1, 0) para p2.

**Com coordenadas para p1 e p2**:
O construtor recebe as coordenadas de p1 e p2.

**Com objeto Ponto para p1 e p2**:

**Copy Constructor para Segmento**

```java
public class Segmento {
    private Ponto p1, p2;

    public Segmento() {
        p1 = new Ponto(); // padrão é (0, 0)
        p2 = new Ponto(1, 0);
    }

    public Segmento(double x1, double x2, double y1, double y2) {
        this.p1 = new Ponto(x1, x2);
        this.p2 = new Ponto(y1, y2);
    }

    public Segmento(Ponto p1, Ponto p2) {
        this.p1 = new Ponto(p1);
        this.p2 = new Ponto(p2);
    }

    public Segmento(Segmento seg) {
        this(seg.p1, seg.p2);
    }
}
```

## Método `toString()`
Existe em todas as classes pré-definidas do Java. Retorna uma string que é uma representação do objeto. Essa string deve conter as informações necessárias para construir o objeto no mesmo estado em que estava quando foi gerada.
Sempre que um objeto precisa ser convertido para string, esse método é chamado automaticamente pelo Java.
> Usado também para criar objetos perenes, que voltam a existir depois do programa ser fechado e aberto novamente.

```java
public string toString()
{
	return "(" + x + "," + y +")";
}
```

## Métodos adicionais para a classe Segmento

```java
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTE0MDMyMTgzOV19
-->