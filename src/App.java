import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {
    static ArrayList <Conta> contas;

    public static void main(String[] args) throws Exception {
        contas = new ArrayList<Conta>();
        
        
        String [] r = new String[]{"CRIAR CONTA", "DEPOSITO", "SAQUE", "STATUS","TRANSFERIR","ENCERRAR"};

        int x = 0;

        do {
        int op = JOptionPane.showOptionDialog(null, "ESCOLHA A OPERAÇÃO", "BANCO MAUT", 
        JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, r, 0);

        switch (op) {
            
            case 0: //CRIAR CONTA
            String nome = JOptionPane.showInputDialog(null, "NOME DO CLIENTE:");
            String CPF = JOptionPane.showInputDialog(null, "CPF:");
            String DATA = JOptionPane.showInputDialog(null, "DATA:");
            Endereco endereco = new Endereco(JOptionPane.showInputDialog(null, "NOME DA RUA:"), JOptionPane.showInputDialog(null, "NOME DO BAIRRO"), Integer.parseInt(JOptionPane.showInputDialog(null, "NUMERO DA RUA")), JOptionPane.showInputDialog(null, "NOME DO ESTADO"), JOptionPane.showInputDialog(null, "NOME DA CIDADE"));
            Cliente c1 = new Cliente(nome, CPF, DATA, endereco);
            String tipo = JOptionPane.showInputDialog(null, "TIPO:");

            ContaCorrente cc1 = new ContaCorrente(c1, tipo);
            ContaPoupanca cp1 = new ContaPoupanca(c1, tipo);



            if(tipo.equalsIgnoreCase("CORRENTE")){

                
            contas.add(cc1);
            cc1.statusDaConta();
            }
            else{
                contas.add(cp1);
                cp1.statusDaConta();
            }

            x = 1;    
            break;
            
            case 1: //DEPOSITAR
            
                int nu = Integer.parseInt( JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA QUE DESEJA DEPOSITAR:"));
                Conta conta = informarConta(nu);

                if(conta != null){
                    
                    double deposita = Double.parseDouble(JOptionPane.showInputDialog(null, "INFORME O VALOR QUE DESEJA DEPOSITAR:"));
                    conta.depositar(deposita);
                }else{
                    JOptionPane.showMessageDialog(null, "CONTA NÃO DISPONIVEL");
                }
            
            x = 1;     
            break;
                
        
            case 2: //SACAR
            
             nu = Integer.parseInt( JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA QUE DESEJA SACAR:"));
             conta = informarConta(nu);

                if(conta != null){
                    
                    double sacar = Double.parseDouble(JOptionPane.showInputDialog(null, "INFORME O VALOR QUE DESEJA SACAR:"));
                    conta.sacar(sacar);

            }else{
                JOptionPane.showMessageDialog(null, "CONTA NÃO DISPONIVEL");
            }
        
            
            x = 1;    
            break;
                
            case 3: //STATUS DA CONTA
            
            nu = Integer.parseInt( JOptionPane.showInputDialog(null, "INFORME NUMERO DA CONTA:"));
            
                for (Conta c: contas){
                    if(c.getNumeroConta() == nu){
                        c.statusDaConta();
                    }else{
                        JOptionPane.showMessageDialog(null, "CONTA NAO DISPONIVEL");
                    }
                }
            
            x = 1;
            
            break;   

            case 4: //TRANSFERENCIA
                    //TRABALHANDO AQUI
            
            int c = Integer.parseInt(JOptionPane.showInputDialog(null, "NUMERO DA CONTA: "));
            conta = informarConta(c);

            int cd = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME A CONTA DESTINO: "));
            Conta conta2 = informarConta(cd);

            if(contas.contains(conta) && contas.contains(conta2)){
                
                conta.transferir(Double.parseDouble(JOptionPane.showInputDialog(null, "Qual o valor que deseja transferir?")), conta2);
                JOptionPane.showMessageDialog(null, "TRANSFERENCIA FEITA!");

            }else{
                JOptionPane.showMessageDialog(null, "ERRO...");
            }
            
            
            x = 1;
            break;
            
            case 5: //SAIR DO BANCO
            JOptionPane.showMessageDialog(null, "FECHANDO");
            x = 0;

            break;
 
        }
            
        } while (x != 0);
          
        
    }
    
    public static Conta informarConta(int numeroDaConta){
        Conta conta = null;
        if (contas.size() > 0){
            for(Conta c : contas){
                if (c.getNumeroConta() == numeroDaConta){
                conta =  c;   
            }
        }
        }
        return conta;
        
    }
}
