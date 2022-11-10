import javax.swing.JOptionPane;

import notificacoes.Email;
import notificacoes.Sms;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, String tipo) {
        super(cliente, tipo);
    }

    private Double rendimento = 0.10;  //rendimento de 10%

    Email email = new Email();
    Sms sms = new Sms();
    
    public void transferir(double valor, Conta contaDestino){

        String[] email_sms = new String[]{"EMAIL","SMS"};
        
        if(getSaldo() >= valor ){
            int escolha = JOptionPane.showOptionDialog(null, "SMS OU EMAIL", "NOTIFICAÇÃO", 
            JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, email_sms, 0);
        
            super.transferir(valor, contaDestino);
            this.setSaldo(getSaldo() - valor*0.05);

            if(escolha == 0){
                email.enviarNotificacao("TRANSFERÊNCIA", valor);
            }else{
                sms.enviarNotificacao("TRANSFERÊNCIA", valor);
            }
            JOptionPane.showMessageDialog(null, "TRANSFERENCIA FEITA!");

        }else{
            JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE");
        }
        

    }
 
    public void depositar(Double valor) {
        
        String[] email_sms = new String[]{"EMAIL","SMS"};
        int escolha = JOptionPane.showOptionDialog(null, "SMS OU EMAIL", "NOTIFICAÇÃO", 
        JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, email_sms, 0);
        
        super.depositar(valor);
        this.setSaldo(this.getSaldo() +this.getSaldo() * this.rendimento);

        if(escolha == 0){
            email.enviarNotificacao("DEPÓSITO", valor);
        }else{
            sms.enviarNotificacao("DEPÓSITO", valor);
        }
        
    }


    public void statusDaConta(){

        JOptionPane.showMessageDialog(null, "\nNUMERO DA CONTA: "+ getNumeroConta() +"\nNUMERO DA AGENCIA: "+ getNumeroAgencia ()+"\nSALDO: "+getSaldo()+
        "\nCLIENTE: "+ cliente.getNome()+ "\nTIPO:"+this.getTipo(),

         "Status da conta",JOptionPane.PLAIN_MESSAGE);

    }


    
    
}
