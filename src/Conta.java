import java.util.Random;

import javax.swing.JOptionPane;

public class Conta {

    private int numeroAgencia;
    private int numeroConta;
    private double saldo;
    private Cliente cliente;
    private String tipo;

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


    public void depositar(double valor){

        setSaldo(getSaldo() + valor);
        JOptionPane.showMessageDialog(null, "DEPOSITO REALIZADO!");
    }

    public void sacar(double valor){
        if(valor <= getSaldo()){
            setSaldo(getSaldo() - valor);

        }else{
            JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE!");
        }
    }

    public void transferir(double valor, Conta contaDestino){

        setSaldo(getSaldo() - valor);
        contaDestino.depositar(valor);

    }


    public void statusDaConta(){

        JOptionPane.showMessageDialog(null, "\nNUMERO DA CONTA: "+ getNumeroConta() +"\nNUMERO DA AGENCIA: "+ getNumeroAgencia ()+"\nSALDO: "+getSaldo()+
        "\nCLIENTE: "+ cliente.getNome(),
         "Status da conta",JOptionPane.PLAIN_MESSAGE);

    }
    
}