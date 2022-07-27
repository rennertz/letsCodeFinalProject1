package models.conta;

import models.cliente.Cliente;


public abstract class ContaComRendimento extends Conta {


    public ContaComRendimento(Cliente titular, TipoConta tipo) {
        super(titular, tipo);
    }
    
    public abstract double getTaxaMensal();

    public abstract void setTaxaMensal(double rendimentoMensal);

}
