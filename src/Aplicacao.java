import models.SimuladorDeRendimento;
import models.cliente.Cliente;
import models.cliente.ClientePF;
import models.cliente.ClientePJ;
import models.cliente.TipoCliente;
import models.conta.ContaCorrente;
import models.conta.ContaInvestimento;
import models.conta.ContaPoupanca;

public class Aplicacao {

    public static void main(String[] args) throws Exception {
        
        System.out.println("SIMULANDO A JORNADA DE UMA PESSOA FISICA\n");
        ClientePF renner = new ClientePF("Renner");
        SimulaJornadaDoCLiente(renner);

        System.out.println("\nSIMULANDO A JORNADA DE UMA PESSOA JURIDICA\n");
        ClientePJ lojasRenner = new ClientePJ("Lojas Renner");
        SimulaJornadaDoCLiente(lojasRenner);

    }


    public static void SimulaJornadaDoCLiente(Cliente cliente) {
        
        ContaCorrente cc = new ContaCorrente(cliente);
        cc.deposita(3000);
        
        System.out.println("Saldo inicial: " + cc.getSaldo());
        System.out.print("Tentativa de saque de R$ 5000 gera: \n    ");
        cc.saca(5000);
        System.out.println();

        SimuladorDeRendimento simulador = new SimuladorDeRendimento();
        
        if (cliente.getTipo() == TipoCliente.PF) {
            ContaPoupanca poupanca = new ContaPoupanca((ClientePF) cliente);
            cc.investir(poupanca, 1000);
            System.out.println(" <- Saldo conta corrente após transf: " + cc.getSaldo());
            System.out.println(" -> Saldo poupanca:             " + poupanca.getSaldo());
    
            System.out.println("Saldo da poupanca após 1 mes:   " + simulador.saldoMesesAFrente(poupanca, 1) );
            System.out.println("Saldo da poupanca após 2 meses: " + simulador.saldoMesesAFrente(poupanca, 2) );
            System.out.println();
        }

        ContaInvestimento investimento = new ContaInvestimento(cliente);
        cc.investir(investimento, 1000);
        System.out.println(" <- Saldo conta corrente após transf:   " + cc.getSaldo());
        System.out.println(" -> Saldo investimento:             " + investimento.getSaldo());
        System.out.println("Saldo do investimento após 1 mes:   " + simulador.saldoMesesAFrente(investimento, 1) );
        System.out.println("Saldo do investimento após 2 meses: " + simulador.saldoMesesAFrente(investimento, 2) );
        System.out.println();
        
    }
}
