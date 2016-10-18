-----------
---- 1 ----
-----------

Select NomeEmpregado, DataAdmissao
from Empregado
	where DataAdmissao > convert(datetime, '1980/05/01',120) and
	DataAdmissao < convert(datetime,'1982/01/20',120);

-----------
---- 2 ----
-----------

Select TOP 1 Cargo, ----Registro de Gambi----
	count (1) as QuantidadeEmpregados
from Empregado
	group by Cargo
	order by QuantidadeEmpregados desc

-----------
---- 3 ----
-----------

Select UF, 
	count (Distinct nome) as QuantidadeCidades
from cidade 
	group by UF
	order by QuantidadeCidades desc

-----------
---- 4 ----
-----------

Select nome,
	count (*) as Repeticoes
from cidade 
	group by nome
	having count(*) > 1

-----------
---- 5 ----
-----------

select (max(Idassociado)+1) as ProximoID from associado

-----------
---- 6 ----
-----------

Select NomeEmpregado, Salario,
	Porcentagem = 
		Case
			When Salario <= 1164 then '0%'
			When Salario  > 1164 and Salario <= 2326 then '15%'
			when Salario  > 2362 then '27,5%'
		End
from empregado

/*
Select NomeEmpregado, Salario,
	SalarioAjustado =
		Case
			When Salario <= 1164 then Salario
			When Salario  > 1164 and Salario <= 2326 then (salario * 0.75)
			when Salario  > 2362 then (Salario * 0.725)
		end
from Empregado
*/