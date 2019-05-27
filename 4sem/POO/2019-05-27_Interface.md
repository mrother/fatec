# Interface
É uma estrutura feita para permitir a comunicação entre classes que estão em contextos diferentes. A interface declara um conjunto de métodos públicos e abstratos quem deve ser implementados por alguma classe localizada em outro contexto. Eventualmente pode declarar também atributos, mas estes serão sempre finais e estáticos.
Como todos os métodos em uma interface são sempre públicos e abstratos, as palavras `public` e `abstract` nunca são usadas na declaração. O mesmo ocorre para as palavras `final` e `static` no caso de atributos.
O mecanismo de herança funciona também com interfaces, mas é importante lembrar que interfaces só podem herdar de interfaces e classes só herdam de classes.
Quando uma classe implementa uma interface, objetos dessa classe também são considerados instâncias da interface. Entretanto, interfaces não são classes e não podem ser instanciadas.

## Declaração

```java
public interface NomeInterface
{
	// atributos
	// métodos
}
```

### Exemplo
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTIxMTM4MDM5NDZdfQ==
-->