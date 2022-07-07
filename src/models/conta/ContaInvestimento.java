package models.conta;

import models.cliente.Cliente;
import models.cliente.TipoCliente;


public class ContaInvestimento extends Conta implements ContaComRendimento{
    /**
     * A ContaInvestimento oferece rendimento 2% superior ao ClientePJ, conforme
     * implementado no método getTaxaMensal.
     *  
     * O saldo só pode ser resgatado para ContaCorrente de mesma titularidade.
     */

    private static double rendimentoMensal = 0.012;

    public ContaInvestimento(Cliente titular) {
        super(titular, TipoConta.ContaInvestimento);
    }


    public void resgata(ContaCorrente cc, double valor) {
        if (cc.getTitular() == this.getTitular()) {
            super.transfere(cc, valor);
        } else {
            System.out.println("Erro: você só pode resgatar para uma Conta Corrente de mesma titularidade.");
        }
    }

    @Override
    public double getTaxaMensal() {
        // rendimento específico de ClientePJ
        if (this.getTipoCliente() == TipoCliente.PJ) {
            return ContaInvestimento.rendimentoMensal + 0.02;
        }

        return ContaInvestimento.rendimentoMensal;
    }

    public void setTaxaMensal(double rendimentoMensal) {
        ContaInvestimento.rendimentoMensal = rendimentoMensal;
    }

}
