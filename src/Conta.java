import java.util.Random;

import javax.swing.JOptionPane;

import notificacoes.Email;
import notificacoes.Sms;

public class Conta{

    private int numeroAgencia;
    private int numeroConta;
    private double saldo;
    protected Cliente cliente;
    private String tipo;

    Email email = new Email();
    Sms sms = new Sms();
    
    public Conta(Cliente cliente, String tipoDaConta){

        Random random = new Random();

        this.numeroAgencia = random.nextInt(100);
        this.numeroConta = random.nextInt(100);

        setTipo(tipoDaConta);

        setCliente(cliente);

    }
    
    
    public Conta(Cliente cliente2) {
    }


    public int getNumeroAgencia() {
        return numeroAgencia;
    }


    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }


    public int getNumeroConta() {
        return numeroConta;
    }


    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }


    public double getSaldo() {
        return saldo;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public void depositar(Double valor){
        
        this.setSaldo(this.getSaldo() + valor);
        JOptionPane.showMessageDialog(null, "DEPOSITO REALIZADO!");
    }

    public void sacar(Double i){ 
        
        if(i <= getSaldo()){
            setSaldo(getSaldo() - i);
            
            if(getTipo().equalsIgnoreCase("POUPANCA")){
                
                String[] email_sms = new String[]{"EMAIL","SMS"};
                int escolha = JOptionPane.showOptionDialog(null, "SMS OU EMAIL", "NOTIFICAÇÃO", 
                JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, email_sms, 0);
                
                if(escolha == 0){
                    email.enviarNotificacao("SAQUE", i);
                }else{
                    sms.enviarNotificacao("SAQUE", i);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "IMPOSSIVEL SACAR");
        }
    }

    public void transferir(double valor, Conta contaDestino){

        setSaldo(getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);

    }


    public void statusDaConta(){

        JOptionPane.showMessageDialog(null, "\nNUMERO DA CONTA: "+ getNumeroConta() +"\nNUMERO DA AGENCIA: "+ getNumeroAgencia ()+"\nSALDO: "+getSaldo()+
        "\nCLIENTE: "+ cliente.getNome(),
         "Status da conta",JOptionPane.PLAIN_MESSAGE);

    }


    
    
}