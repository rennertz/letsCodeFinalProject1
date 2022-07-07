package models.conta;

import models.cliente.ClientePF;


public class ContaPoupanca extends Conta implements ContaComRendimento {
    /**
     * A abertura de ContaPoupanca é restrita a ClientePF, conforme implementado
     * em seu único construtor.
     * 
     */


    private static double rendimentoMensal = 0.007;
    
    public ContaPoupanca(ClientePF titular) {
        super(titular, TipoConta.ContaPoupanca);
    }

    public void resgata(ContaCorrente cc, double valor) {
        if (cc.getTitular() == this.getTitular()) {
            this.transfere(cc, valor);
        } else {
            System.out.println("Erro: você só pode resgatar para uma Conta Corrente de mesma titularidade.");
        }
    }

    
    @Override
    public boolean saca(double valor) {
        return super.saca(valor);
    }

    @Override
    public void deposita(double valor) {
        super.deposita(valor);
    }

    @Override
    public double getTaxaMensal() {
        return ContaPoupanca.rendimentoMensal;
    }
    
    public void setTaxaMensal(double rendimentoMensal) {
        ContaPoupanca.rendimentoMensal = rendimentoMensal;
    }
    
}
