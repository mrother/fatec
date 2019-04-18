```sql
/* 1. Faça uma consulta que retorne as três primeiras letras dos nomes dos atores. */
SELECT LEFT(primeiro_nome, 3) FROM ator;
```
```sql
/* 2. Faça uma consulta que retorne o nome completo em um campo, e as iniciais do nome em outro campo.*/
SELECT CONCAT_WS(" ", primeiro_nome, ultimo_nome) AS nome, concat(LEFT(primeiro_nome, 1), LEFT(ultimo_nome, 1)) FROM ator;
```
```sql
/* 3. Monte uma lista de todos os atores classificados de acordo
com o maior nome completo (Primeiro nome e último nome).
 */
 SELECT primeiro_nome, ultimo_nome, LENGTH(CONCAT(primeiro_nome, ultimo_nome)) AS tam
 FROM ator
 ORDER BY tam  DESC;
```
```sql
 /* 4. Monte uma consulta que agrupe e mostre a quantidade de cada grupo de nomes
 que rimam (Considere nomes que rimam, aqueles que terminam com as mesmas duas letras).
*/
SELECT primeiro_nome, RIGHT(primeiro_nome, 2) AS grupo
FROM ator
GROUP BY primeiro_nome, grupo
ORDER BY grupo;
```
```sql
/* 5. Faça uma consulta que transforme os nomes da seguinte maneira: gUstAvO AbrEU */
SELECT REPLACE(
         REPLACE(
			  REPLACE(
			    REPLACE(
				   REPLACE(
					  LOWER(
					    CONCAT_WS(' ', primeiro_nome, ultimo_nome))
					   , 'a', 'A')
					, 'e', 'E')
				, 'i', 'I')
			, 'o', 'O')
		, 'u', 'U')
FROM ator;
```
```sql
/* 6. Faça uma estimativa de quanto a locadora teria ganho se cada filme custasse valor arredondado, 
ou seja $3,00 ao invés de $2,99; $5,00 ao invés de $4,99 e assim por diante. */
SELECT SUM(valor) AS faturado, SUM(round(valor)) AS previsto FROM pagamento;
```
```sql
/* 7. Faça uma estimativa de quanto a locadora teria ganho se sempre fosse dado desconto
dos valores em centavos (Se um filme custa $3,50 teria $0,50 de desconto, se custa $1,80 teria $0,80 de desconto). */
SELECT SUM(valor) AS faturado, SUM(TRUNCATE(valor, 0)) AS previsto FROM pagamento;
```
```sql
/* 8. Faça uma lista classificando os filmes pela quantidade de dias que os mesmos ficam nos clientes. */
SELECT F.titulo, DATEDIFF(data_de_devolucao, data_de_aluguel) tempo FROM aluguel A
LEFT JOIN inventario I ON I.inventario_id = A.inventario_id
LEFT JOIN loja L ON L.loja_id = I.loja_id
LEFT JOIN filme F ON F.filme_id = I.filme_id
GROUP BY F.titulo
ORDER BY tempo DESC;
```
```sql
/* 9. Qual dia da semana têm mais aluguéis de filmes. */ 
SELECT DAYNAME(data_de_aluguel) dia, COUNT(*) total FROM aluguel
GROUP BY dia
ORDER BY total DESC;
```
```sql
/* 10. Faça uma lista dos atores que a segunda letra do nome seja "A". */
SELECT primeiro_nome FROM ator
WHERE SUBSTR(primeiro_nome, 2, 1) = 'A';
```
```sql
/* 11. Faça uma lista dos filmes que contenham no campo recursos especiais "Behind the Scenes" */
SELECT * FROM filme WHERE INSTR(recursos_especiais, 'Behind the Scenes') ;
```
```sql
/* 12. Faça uma lista com a quantidade de filmes de cada categoria, porém o nome da categoria deve estar em Português. */
SELECT case C.categoria_id
		 when '1' then 'Ação'
 		 when '2' then 'Animação'
		 when '3' then 'Crianças'
		 when '4' then 'Clássicos'
		 when '5' then 'Comédia'
		 when '6' then 'Documentário'
		 when '7' then 'Drama'
		 when '8' then 'Família'
		 when '9' then 'Estrangeiro'
		 when '10' then 'Jogos'
		 when '11' then 'Horror'
		 when '12' then 'Música'
		 when '13' then 'Jogo'
		 when '14' then 'Ficção Científica'
		 when '15' then 'Esportes'
 		 when '16' then 'Viagem'
		 end
, COUNT(*) qtdd
FROM categoria C
LEFT JOIN filme_categoria FC ON FC.categoria_id = C.categoria_id
LEFT JOIN filme F ON F.filme_id = FC.filme_id
GROUP BY C.nome
ORDER BY qtdd DESC;
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbMjg5NTA2MjE4LDQ2MTU5Mjk2Ml19
-->