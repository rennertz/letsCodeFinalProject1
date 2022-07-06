package models.conta;


import java.math.BigDecimal;
import java.math.RoundingMode;

import models.cliente.Cliente;
import models.cliente.TipoCliente;

public abstract class Conta {
    
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
        return titular.getNome();
    }

    public TipoCliente getTipoCliente() {
        return this.titular.getTipo();
    }

    public TipoConta getTipoConta() {
        return this.tipo;
    }

    public boolean saca(double valor) {
        if (this.titular.getTipo() == TipoCliente.PJ) {
            valor += valor*0.005;
        }

        if (valor > this.saldo.doubleValue()) {
            System.out.println("Saldo insuficiente.");
            return false;
        }

        this.saldo = this.saldo.subtract(new BigDecimal(valor)).setScale(2, RoundingMode.HALF_DOWN);
        return true;
    }

    public void transfere(Conta destinatario, double valor) {
        if(this.saca(valor)){
            destinatario.deposita(valor);
        }
    }

    public void deposita(double valor) {
        this.saldo = this.saldo.add(BigDecimal.valueOf(valor).setScale(2, RoundingMode.HALF_DOWN));
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

}
