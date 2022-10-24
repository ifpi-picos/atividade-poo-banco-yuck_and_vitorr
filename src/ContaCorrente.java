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

    public void retiradaChequeEspecial(double valor){
        setChequeEspecial(getChequeEspecial() - valor);
    }
    
    public void deposita(double valor, Conta conta){

        if(getChequeEspecial() < 0){
            double valorCalculo = valor-getChequeEspecial()*-1;
            setChequeEspecial((valor-getChequeEspecial()*-1) - valorCalculo);
            
            JOptionPane.showMessageDialog(null, "PARTE FOI PARA O CHEQUE ESPECIAL");
            conta.depositar(valorCalculo);
        }else{
            conta.depositar(valor);
        }

    }

    public void saca(double valor, Conta conta){

        if(getSaldo() < valor && getChequeEspecial() <= 0 && getChequeEspecial() >= -100){

            retiradaChequeEspecial(valor-getSaldo());
            conta.sacar(valor);
            conta.setSaldo(0);
            JOptionPane.showMessageDialog(null, "RETIRADO DO CHEQUE ESPECIAL POR SALDO INSUFICIENTE");

        }else if(getSaldo() >= valor){

            sacar(valor);
        }else{
            JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE MESMO COM CHEQUE");
        }

    }

    public void transfere(double valor, Conta contaDestino){
        //TRABALHANDO AQUI
    }


    
}
