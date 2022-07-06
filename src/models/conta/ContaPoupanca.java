package models.conta;

import models.cliente.ClientePF;

public class ContaPoupanca extends Conta implements ContaComRendimento {

    private static double rendimentoMensal = 0.007;
    
    public ContaPoupanca(ClientePF titular) {
        super(titular, TipoConta.ContaPoupanca);
    }

    @Override
    public double getTaxaMensal() {
        return ContaPoupanca.rendimentoMensal;
    }
    
    public void setTaxaMensal(double rendimentoMensal) {
        ContaPoupanca.rendimentoMensal = rendimentoMensal;
    }
    
}
