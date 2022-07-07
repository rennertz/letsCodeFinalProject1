package models.conta;

import java.math.BigDecimal;
import java.math.RoundingMode;

import models.cliente.Cliente;
import models.cliente.TipoCliente;


public abstract class Conta {
    /**
     * Superclasse com os atributos métodos básicos de uma conta.
     *  
     * Todos os métodos são públicos, exceto deposita e saca e transfere, que não devem estar disponíveis
     * na ContaInvestimento. Nesta conta o dinheiro só transita por aplicação ou resgate, que checam se
     * o titular das contas origem e destino são iguais.
     *  
     * deposita e saca passama a ser publicos na ContaCorrente e na ContaPoupanca.
     * transfere (irrestrito) só é publico na ContaCorrente.
     */
    
    private static int contagemDeContas;
    private final String numero;
    private final Cliente titular;
    private final TipoConta tipo;
    private BigDecimal saldo = new BigDecimal(0).setScale(2);

    public Conta(Cliente titular, TipoConta tipo){
        contagemDeContas++;
        this.numero = String.format("%05d", Conta.contagemDeContas);
        this.titular = titular;
        this.tipo = tipo;

        System.out.printf("%s número %s de %s (%S) criada com sucesso.\n", this.tipo, this.numero, this.titular.getNome(), this.titular.getTipo());
    }
    

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return this.titular.getNome();
    }

    public TipoCliente getTipoCliente() {
        return this.titular.getTipo();
    }

    public TipoConta getTipoConta() {
        return this.tipo;
    }

    protected boolean saca(double valor) {
        // O ClientePJ é cobrado em 0.5% por transação de saque (e consequentemente de transferência)
        if (this.titular.getTipo() == TipoCliente.PJ) {
            valor += valor*0.005;
        }

        if (valor > this.saldo.doubleValue()) {
            System.out.println("Erro: saldo insuficiente.");
            return false;
        }

        this.saldo = this.saldo.subtract(new BigDecimal(valor)).setScale(2, RoundingMode.HALF_DOWN);
        return true;
    }

    protected void transfere(Conta destinatario, double valor) {
        if(this.saca(valor)){
            destinatario.deposita(valor);
        }
    }

    protected void deposita(double valor) {
        this.saldo = this.saldo.add(BigDecimal.valueOf(valor).setScale(2, RoundingMode.HALF_DOWN));
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

}
