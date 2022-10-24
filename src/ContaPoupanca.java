public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, String tipo) {
        super(cliente, tipo);
    }

    private double rendimento = 1.1;  //rendimento de 10%

    public void transfere(double valor, Conta contaDestino){

        double posTaxa = valor - (valor*0.05);
        transferir(posTaxa, contaDestino);

    }

    public void depositar(double valor, Conta conta) {
        conta.depositar(valor*rendimento);
    }

    
    
}
