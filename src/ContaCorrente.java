import javax.swing.JOptionPane;

import notificacoes.Email;
import notificacoes.Sms;

public class ContaCorrente extends Conta {
    
    public ContaCorrente(Cliente cliente, String tipo) {
        super(cliente, tipo);
    }


    private double chequeEspecial = 0;

    Email email = new Email();
    Sms sms = new Sms();
    
    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    

    @Override
    public void depositar(Double valor) {
        
        String[] email_sms = new String[]{"EMAIL","SMS"};
        int escolha = JOptionPane.showOptionDialog(null, "SMS OU EMAIL", "NOTIFICAÇÃO", 
        JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, email_sms, 0);
        
        if(getChequeEspecial() > 0 && valor > getChequeEspecial()){
            valor = valor - getChequeEspecial();
            setChequeEspecial(0);
            super.depositar(valor);
            if(escolha == 0){
                email.enviarNotificacao("DEPÓSITO", valor);
            }else{
                sms.enviarNotificacao("DEPÓSITO", valor);
            }
        }else if(getChequeEspecial() > 0 && valor < getChequeEspecial()){
            setChequeEspecial(getChequeEspecial() - valor);
            JOptionPane.showMessageDialog(null, "FOI TODO PARA O CHEQUE");

        }else{
            super.depositar(valor);
            if(escolha == 0){
                email.enviarNotificacao("DEPÓSITO", valor);
            }else{
                sms.enviarNotificacao("DEPÓSITO", valor);
            }
        }
        
    }

    //TRABALHANDO AQUI
    public void transferir(double valor, Conta contaDestino){
        
        String[] email_sms = new String[]{"EMAIL","SMS"};
        int escolha = JOptionPane.showOptionDialog(null, "SMS OU EMAIL", "NOTIFICAÇÃO", 
        JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, email_sms, 0);
        
        super.transferir(valor, contaDestino);

        if(escolha == 0){
            email.enviarNotificacao("TRANSFERÊNCIA", valor);
        }else{
            sms.enviarNotificacao("TRANSFERÊNCIA", valor);
        }
    }

    @Override
    public void sacar(Double valor) {

        
        if(valor > getSaldo() && getChequeEspecial() + valor <= 1000){
            
            String[] email_sms = new String[]{"EMAIL","SMS"};
            int escolha = JOptionPane.showOptionDialog(null, "SMS OU EMAIL", "NOTIFICAÇÃO", 
            JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, email_sms, 0);
            
            setChequeEspecial(getChequeEspecial() + valor);
            JOptionPane.showMessageDialog(null, "RETIRADO DO CHEQUE");
            setSaldo(getChequeEspecial());
            super.sacar(valor);
            JOptionPane.showMessageDialog(null, "SAQUE REALIZADO");

            if(escolha == 0){
                email.enviarNotificacao("SAQUE", valor);
            }else{
                sms.enviarNotificacao("SAQUE", valor);
            }

        }else if(valor < getSaldo()){
            
            String[] email_sms = new String[]{"EMAIL","SMS"};
            int escolha = JOptionPane.showOptionDialog(null, "SMS OU EMAIL", "NOTIFICAÇÃO", 
            JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, email_sms, 0);
            
            super.sacar(valor);
            JOptionPane.showMessageDialog(null, "SAQUE REALIZADO");
            if(escolha == 0){
                email.enviarNotificacao("SAQUE", valor);
            }else{
                sms.enviarNotificacao("SAQUE", valor);
            }
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
