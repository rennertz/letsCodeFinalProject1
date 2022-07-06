package models.conta;

import models.cliente.Cliente;


public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente titular) {
        super(titular, TipoConta.ContaCorrente);
    }
    
    
    @Override
    public boolean saca(double valor) {
        return super.saca(valor);
    }

    public void investir(ContaPoupanca poupanca, double valor) {
        this.transfere(poupanca, valor);
    }

    public void investir(ContaInvestimento investimento, double valor) {
        this.transfere(investimento, valor);
    }
    
}
