package models.cliente;

public abstract class Cliente {
    
    private final TipoCliente tipo;
    private String nome;

    public Cliente(String nome, TipoCliente tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
