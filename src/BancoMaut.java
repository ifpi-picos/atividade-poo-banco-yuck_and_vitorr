import java.util.Random;

import javax.swing.JOptionPane;

public class BancoMaut {

    private int numeroAgencia;
    private int numeroConta;
    private int saldo;
    private Cliente cliente;

    public BancoMaut(Cliente cliente){

        Random random = new Random();

        this.numeroAgencia = random.nextInt(100);
        this.numeroConta = random.nextInt(100);

        setCliente(cliente);
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


    public int getSaldo() {
        return saldo;
    }


    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public void depositar(int valor){

        setSaldo(getSaldo() + valor);
        JOptionPane.showMessageDialog(null, "DEPOSITO REALIZADO!");
    }

    public void sacar(int valor){
        if(valor <= getSaldo()){
            setSaldo(getSaldo() - valor);

        }else{
            JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE!");
        }
    }

    public void statusDaConta(){

        JOptionPane.showMessageDialog(null, "\nNUMERO DA AGENCIA: "+ getNumeroAgencia ()+"\nSALDO: "+getSaldo()+
        "\nCLIENTE: "+ cliente.getNome(),
         "Status da conta",JOptionPane.PLAIN_MESSAGE);

    }
    
}