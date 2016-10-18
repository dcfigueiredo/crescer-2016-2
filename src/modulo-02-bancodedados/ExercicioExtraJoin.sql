--------- Exercicios Extras de Join ----------

-----------
---- 1 ---- Listar Total de Pedidos de Setembro de 2016 ----
-----------

Select count (distinct IDPedido) as Total_Pedidos from pedido
	where datapedido between convert (datetime, '01/09/2016', 103) and convert(datetime, '30/09/2016', 103)

----------- 
---- 2 ---- Listar os produtos que utilizam o material IDMaterial = 15836 ----
-----------

Select ISNULL (quantidade, 0) from ProdutoMaterial MP
	inner join Produto P on MP.IDProduto = P.IDProduto
	inner join Material M on MP.IDMaterial = M.IDMaterial

-----------
---- 3 ---- Liste todos os clientes que possuem LTDA na raz�o social ----
-----------

Select Nome, RazaoSocial from Cliente ----Registro de gambi----
	where SUBSTRING (RazaoSocial, LEN(RazaoSocial) - 4, 4) = 'LTDA'

-----------
---- 4 ----	Insira um novo registro na tabela Produto
-----------

begin transaction
	INSERT INTO Produto (Nome, PrecoCusto, PrecoVenda, Situacao)
				Values  ('Galocha Maragato', 35.67, 77.95, 'A')
Rollback
Commit

/*

Nome: Galocha Maragato
Pre�o de Custo: 35.67
Pre�o de Venda:  77.95
Situa��o: A

*/

-----------
---- 5 ---- Liste os produtos que n�o tiveram pedido
-----------

select p.idproduto, p.nome from produto p
	left outer join pedidoitem pit on p.IDProduto = pit.IDProduto where pit.IDProduto is null

-----------
---- 6 ---- Listar UF com maior numero de clientes e UF com menor numero de clientes
-----------

Select TOP 1 Cidade.UF, COUNT(Cliente.IDcidade) as Numero_Clientes
	from Cidade
		LEFT OUTER JOIN Cliente on Cidade.IDCidade = Cliente.IDCidade
		group by Cidade.UF
		order by Numero_Clientes desc

-----------
---- 7 ----
-----------



-----------
---- 8 ----
-----------



-----------
---- 9 ----
-----------



-----------
---- 10----
-----------
	
