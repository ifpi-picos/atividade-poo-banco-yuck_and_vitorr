import javax.swing.JOptionPane;

public class ContaCorrente extends Conta {
    
    public ContaCorrente(Cliente cliente, String tipo) {
        super(cliente, tipo);
    }


    private double chequeEspecial = 0;

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    
    public void deposita(double valor, Conta conta){

        if(getChequeEspecial() < 0){
            double valorCalculo = valor-getChequeEspecial()*-1;
            setChequeEspecial((valor-getChequeEspecial()*-1) - valorCalculo);
            
            JOptionPane.showMessageDialog(null, "FOI PARA O CHEQUE ESPECIAL");
            conta.depositar(valorCalculo);
        }else{
            conta.depositar(valor);
        }

    }

    public void saca(double valor){

        if(getSaldo() + getChequeEspecial() * -1 < valor){
            
            JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE!");
        }

    }

    public void transfere(double valor, Conta contaDestino){

    }


    
}
