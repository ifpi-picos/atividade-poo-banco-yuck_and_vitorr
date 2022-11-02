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
    

    @Override
    public void depositar(Double valor) {
        if(getChequeEspecial() > 0 && valor > getChequeEspecial()){
            valor = valor - getChequeEspecial();
            setChequeEspecial(0);
            super.depositar(valor);
        }else if(getChequeEspecial() > 0 && valor < getChequeEspecial()){
            setChequeEspecial(getChequeEspecial() - valor);
            JOptionPane.showMessageDialog(null, "FOI TODO PARA O CHEQUE");

        }else{
            super.depositar(valor);
        }
        
    }

    //TRABALHANDO AQUI
    public void transferir(double valor, Conta contaDestino){
        super.transferir(valor, contaDestino);
    }

    @Override
    public void sacar(Double valor) {
        if(valor > getSaldo() && getChequeEspecial() + valor <= 1000){
            
            setChequeEspecial(getChequeEspecial() + valor);
            JOptionPane.showMessageDialog(null, "RETIRADO DO CHEQUE");
            setSaldo(getChequeEspecial());
            super.sacar(valor);
            JOptionPane.showMessageDialog(null, "SAQUE REALIZADO");
        }else if(valor < getSaldo()){
            super.sacar(valor);
            JOptionPane.showMessageDialog(null, "SAQUE REALIZADO");
        }else{
            super.sacar(valor);
        }
        
        
    }
    
    
    public void statusDaConta(){

        JOptionPane.showMessageDialog(null, "\nNUMERO DA CONTA: "+ getNumeroConta() +"\nNUMERO DA AGENCIA: "+ getNumeroAgencia ()+"\nSALDO: "+getSaldo()+
        "\nCLIENTE: "+ cliente.getNome()+ "\nTIPO:"+this.getTipo() + "\nCHEQUE ESPECIAL: " + (1000 - getChequeEspecial()) + "\nDEVENDO: " + getChequeEspecial(),

         "Status da conta",JOptionPane.PLAIN_MESSAGE);


    }


    
}
