package models.conta;

import java.math.BigDecimal;

public interface ContaComRendimento {
    
    public double getTaxaMensal();
    
    public BigDecimal getSaldo();

    public void setTaxaMensal(double rendimentoMensal);

}
