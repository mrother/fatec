## Construtores

São métodos especializados na construção de novos objetos.
O construtor é responsável por atribuir valores válidos a todos os atributos e deixar o objeto pronto para ser usado pela aplicação. Toda classe precisa ter pelo menos um construtor.
Caso a classe não declare nenhum, o Java cria um construtor padrão implícito para a classe. O construtor padrão não tem parâmetros e quando criado pelo Java apenas coloca nos atributos o valor nulo correspondente ao tipo deles.
Geralmente os construtores recebem parâmetros para os valores dos atributos que são características.
Atributos que são indicadores de estado geralmente têm seus valores iniciais conhecidos e não precisam ser informados por parâmetros.

# Construtores no Java
1. Tem exatamente o mesmo nome que a Classe.
2. Não tem tipo de retorno.
3. Faça construtores públicos.

```java
public class Aluno {
	private String nome, ra;
	private double nota1, nota2;
	
	public Aluno(String nome, String ra) 
	{
		this.nome = nome;
		this.ra = ra;
		nota1 = 0;
		nota2 = 0;
	}
}
```
### Operador de instanciação (new)
Aloca memória suficiente para conter o objeto e em seguida chama o construtor indicado para preencher o objeto. Por fim, retorna uma referência ao objeto criado. Essa referência precisa ser armazenada em uma variável de referência. Objetos sem referência são destruídos pelo Java.
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE1NzM3NzY0NjksLTE1NjI2NzM4MV19
-->