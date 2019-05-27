## Copy constructor
É usado para criar um objeto copiando os valores de atributos de outro objeto já existente.
Tem como único parâmetroo objeto que será copiado.

```java
// Copy constructor
public Ponto(Ponto pt)
{
   this.x = pt.x;
   this.y = pt.y
}

// Copy constructor (alternativo, chamando o construtor)
public Ponto(Ponto pt)
{
   this(pt.x, pt.y);
}
```

## Assinatura de Métodos
É o que identifica um método e o torna único no contexto onde é válido (a classe).
Dentro da classe não pode haver dois métodos com a mesma assinatura.
A assinatura é composta pelo nome do método e pelo tipo, ordem e quantidade de parâmetros . Nota que o nome dos parâmetros não faz parte da assinatura.

### Exemplo
**Declaração:**
```sql
public void distance(double dx, double dy)
```
Assinatura:
```sql
distance(double, double) 
```
**Declaração:**
```sql
public void print(String caption)
```
Assinatura:
```sql
print(String)
```

## Sobrecarga de métodos (overload)
Ocorre quando dois ou mais métodos da classe tem o mesmo nome, mas com assinaturas diferentes. É geralmente usada quando a mesma tarefa pode ser realizada de várias maneiras diferentes dependendo dos dados disponíveis na entrada.
Nesse caso, dizemos que o método foi sobrecarregado e tem várias versões.


<!--stackedit_data:
eyJoaXN0b3J5IjpbMTA1NDk1MzMxOF19
-->