package models.conta;

import models.cliente.Cliente;
import models.cliente.TipoCliente;

public class ContaInvestimento extends Conta implements ContaComRendimento{

    private static double rendimentoMensal = 0.012;

    public ContaInvestimento(Cliente titular) {
        super(titular, TipoConta.ContaInvestimento);
    }

    @Override
    public double getTaxaMensal() {
        if (this.getTipoCliente() == TipoCliente.PJ) {
            return ContaInvestimento.rendimentoMensal + 0.02;
        }
        return ContaInvestimento.rendimentoMensal;
    }

    public void setTaxaMensal(double rendimentoMensal) {
        ContaInvestimento.rendimentoMensal = rendimentoMensal;
    }

}
