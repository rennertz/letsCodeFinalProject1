package models.conta;

import java.math.BigDecimal;


public interface ContaComRendimento {
    /**
     * Interface consumida pelo SimuladorDeRendimentos.
     * 
     * Ela é impolementada pela ContaPoupança e pela ContaInvestimento.
     */
    
    public double getTaxaMensal();
    
    public BigDecimal getSaldo();

    public void setTaxaMensal(double rendimentoMensal);

}
