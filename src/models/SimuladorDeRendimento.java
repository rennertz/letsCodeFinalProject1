package models;
import java.math.BigDecimal;
import java.math.RoundingMode;

import models.conta.ContaComRendimento;

public class SimuladorDeRendimento {
    
    public BigDecimal saldoMesesAFrente(ContaComRendimento conta, int numeroDeMeses) {
        double multiplicando = conta.getTaxaMensal() + 1;
        multiplicando = Math.pow(multiplicando, numeroDeMeses);

        BigDecimal saldoFuturo = conta.getSaldo().multiply(BigDecimal.valueOf(multiplicando));
        
        return saldoFuturo.setScale(2, RoundingMode.HALF_DOWN);
    }
}
