# Avaliação P1 (B)

1. Nossa locadora de filmes está fazendo aniversário, por isso vamos mandar um email de agradecimento a todos os clientes e funcionários. Faça uma consulta que retorne todos os nomes e emails dos clientes e funcionários.
Ordene por nome e último nome.
Colunas esperadas (real ou alias): primeiro_nome, ultimo_nome, email

```sql
SELECT C.primeiro_nome, ultimo_nome, email FROM cliente C
UNION
SELECT F.primeiro_nome, ultimo_nome, email FROM funcionario F
ORDER BY primeiro_nome, ultimo_nome;
```
---
2. Faça um ranking das categorias de filmes disponíveis que mais lucraram na locadora com o rendimento financeiro de cada uma delas.
Colunas esperadas (real ou alias): nome e montante

```sql
SELECT C.nome, SUM(P.valor) montante FROM categoria C
LEFT JOIN filme_categoria FC ON C.categoria_id = FC.categoria_id
LEFT JOIN filme F ON F.filme_id = FC.filme_id
LEFT JOIN inventario I ON I.filme_id = F.filme_id
LEFT JOIN aluguel A ON A.inventario_id = I.inventario_id
LEFT JOIN pagamento P ON P.aluguel_id = A.aluguel_id
GROUP BY C.nome
ORDER BY montante DESC;
```
---
3. Queremos saber qual categoria de filme tem sido locada. Para isso, faça uma consulta indicando quantos filmes foram alugados por categoria.
Colunas esperadas (real ou alias): nome, quantidade

```sql
SELECT C.nome, COUNT(A.aluguel_id) quantidade FROM categoria C
LEFT JOIN filme_categoria FC ON C.categoria_id = FC.categoria_id
LEFT JOIN filme F ON F.filme_id = FC.filme_id
LEFT JOIN inventario I ON I.filme_id = F.filme_id
LEFT JOIN aluguel A ON A.inventario_id = I.inventario_id
LEFT JOIN pagamento P ON P.aluguel_id = A.aluguel_id
GROUP BY C.nome;
```
---
4. Qual a data do primeiro aluguel realizado por cada funcionário
```sql
SELECT F.primeiro_nome, MIN(A.data_de_aluguel) data FROM aluguel A
LEFT JOIN funcionario F ON F.funcionario_id = A.funcionario_id
GROUP BY F.funcionario_id;
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE3NDI4MjA5NTksLTE2OTUzMjg4NDddfQ
==
-->