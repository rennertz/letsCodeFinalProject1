package models.conta;

public enum TipoConta {
    ContaCorrente("Conta Corrente"),
    ContaPoupanca("Conta Poupanca"),
    ContaInvestimento("Conta Investimento");

    private String tipo;

    TipoConta(String tipo){
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return this.tipo;
    }
}
