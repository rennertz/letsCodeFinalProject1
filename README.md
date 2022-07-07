## Apresentação

Este é um aplicativo bancário que oferece a criação de `ContaCorrente`, `ContaPoupanca` e `ContaInvestimento` para clientes PF e PJ. Foram aplicados os quatro pilares da OOP, quais sejam:
- Abstração
- Ecapsulamento
- Herança
- Polimorfismo

Neste programa são simuladas as jornadas de um `ClientePF` e de um `ClientePJ`, que interagem de maneira diferente com as contas geradas.
 
As contas Poupança e investimento tiveram seu rendimento feito por um simulador próprio, que apresenta o saldo previsto `n` meses à frente.


## Regras de negócio implementadas

- Atente que o `ClientePJ` não cria `ContaPoupanca`, pois não lhe é permitido.
- Atente que um *saque*, *transferência*, *investimento* e *resgate* do `ClientePJ` gera um débito adicional de 0.5% de taxa.
- Atente que a `ContaInvestimento` gera ganhos 2% maiores ao `ClientePJ`.
- Atente que a *transferência* só acontece entre duas `ContaCorrente`. Desta forma, tanto `ContaPoupanca` quanto `ContaInvestimento`:
    - só recebem investimento de uma `ContaCorrente` de mesma titularidade.
    - só resgatam para uma `ContaCorrente` de mesma titularidade.
- Atente que *saque* e *depósito* estão disponíveis para ambos `ContaCorrente` e `ContaPoupanca`.
