package models.conta;

import models.cliente.Cliente;


public class ContaCorrente extends Conta {
    /**
     * Classe mais versátil, além de saque e depósito, oferece transferência para para ContaCorrente
     * de qualquer titularidade.
     * 
     * O investimento nas ContasPoupanca e ContaInvestimento só acontecem sendo de mesma titularidada.
     * 
     */

    public ContaCorrente(Cliente titular) {
        super(titular, TipoConta.ContaCorrente);
    }
    
    
    @Override
    public boolean saca(double valor) {
        return super.saca(valor);
    }

    @Override
    public void deposita(double valor) {
        super.deposita(valor);
    }

    public void transfere(ContaCorrente destinatario, double valor) {
        super.transfere(destinatario, valor);
    }

    public void investir(ContaComRendimento ccr, double valor) {
        if (ccr.getTitular() == this.getTitular()) {
            super.transfere(ccr, valor);
        } else {
            System.out.println("Erro: você só investir em uma Conta de mesma titularidade.");
        }
    }
    
}
