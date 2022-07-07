package models.conta;

import models.cliente.Cliente;


public class ContaCorrente extends Conta {
    /**
     * Classe mais versátil, além de saque e depósito oferece investimento nas
     * demais contas
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

    @Override
    public void transfere(Conta destinatario, double valor) {
        super.transfere(destinatario, valor);
    }

    public void investir(ContaPoupanca poupanca, double valor) {
        if (poupanca.getTitular() == this.getTitular()) {
            this.transfere(poupanca, valor);
        } else {
            System.out.println("Erro: você só investir em uma Conta Poupança de mesma titularidade.");
        }
    }

    public void investir(ContaInvestimento investimento, double valor) {
        if (investimento.getTitular() == this.getTitular()) {
            this.transfere(investimento, valor);
        } else {
            System.out.println("Erro: você só investir em uma Conta Investimento de mesma titularidade.");
        }
    }
    
}
