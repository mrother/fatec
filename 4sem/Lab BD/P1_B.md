```sql
SELECT C.primeiro_nome, ultimo_nome, email FROM cliente C
UNION
SELECT F.primeiro_nome, ultimo_nome, email FROM funcionario F
ORDER BY primeiro_nome, ultimo_nome;
```
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
```sql
SELECT C.nome, COUNT(A.aluguel_id) quantidade FROM categoria C
LEFT JOIN filme_categoria FC ON C.categoria_id = FC.categoria_id
LEFT JOIN filme F ON F.filme_id = FC.filme_id
LEFT JOIN inventario I ON I.filme_id = F.filme_id
LEFT JOIN aluguel A ON A.inventario_id = I.inventario_id
LEFT JOIN pagamento P ON P.aluguel_id = A.aluguel_id
GROUP BY C.nome;
```
```sql
SELECT F.primeiro_nome, MIN(A.data_de_aluguel) data FROM aluguel A
LEFT JOIN funcionario F ON F.funcionario_id = A.funcionario_id
GROUP BY F.funcionario_id;
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE2OTUzMjg4NDddfQ==
-->