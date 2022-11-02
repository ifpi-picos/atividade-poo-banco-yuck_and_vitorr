import javax.swing.JOptionPane;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, String tipo) {
        super(cliente, tipo);
    }

    private Double rendimento = 0.10;  //rendimento de 10%

    public void transferir(double valor, Conta contaDestino){

        double posTaxa = valor - (valor*0.05);
        super.transferir(posTaxa, contaDestino);
        this.setSaldo(getSaldo() - valor*0.05);

    }
 
    public void depositar(Double valor) {
        super.depositar(valor);
        this.setSaldo(this.getSaldo() +this.getSaldo() * this.rendimento);
        
    }


    public void statusDaConta(){

        JOptionPane.showMessageDialog(null, "\nNUMERO DA CONTA: "+ getNumeroConta() +"\nNUMERO DA AGENCIA: "+ getNumeroAgencia ()+"\nSALDO: "+getSaldo()+
        "\nCLIENTE: "+ cliente.getNome()+ "\nTIPO:"+this.getTipo(),

         "Status da conta",JOptionPane.PLAIN_MESSAGE);

    }


    
    
}
