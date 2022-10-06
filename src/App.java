import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
    
        BancoMaut b1;
        BancoMaut b2;
        
        ArrayList<BancoMaut> contas = new ArrayList<>();
        
        String [] r = new String[]{"CRIAR CONTA", "DEPOSITO", "SAQUE", "STATUS","TRANSFERIR","ENCERRAR"};

        int x = 0;

        do {
        int op = JOptionPane.showOptionDialog(null, "ESCOLHA A OPERAÇÃO", "BANCO MAUT", 
        JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, r, 0);

        switch (op) {
            case 1:
            int c = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a conta: "));
            b1 = contas.get(c-1);
            
            b1.depositar(Integer.parseInt(JOptionPane.showInputDialog(null, "Valor de deposito: ")));
            x = 1;     
            break;
            
            case 2:
            int y = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a conta: "));
            b1 = contas.get(y-1);
            
            b1.sacar(Integer.parseInt(JOptionPane.showInputDialog(null, "Valor de saque: ")));
            x = 1;    
            break;
                
            case 3:
            
            int z = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a conta: "));
            b1 = contas.get(z-1);
            
            b1.statusDaConta();
            x = 1;
            break;   

            case 4:

            int t = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a conta: "));
            b1 = contas.get(t-1);
            
            int tranf = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o valor que deseja transferir?"));
            b1.setSaldo(b1.getSaldo()-tranf);

            int tr = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha a conta que deseja transferir: "));
            b2 = contas.get(tr-1);
            b2.setSaldo(b2.getSaldo()+tranf);

            JOptionPane.showMessageDialog(null, "TRANSFERENCIA FEITA!");
            
            x = 1;
            break;
            
            case 5:
            JOptionPane.showMessageDialog(null, "FECHANDO");
            x = 0;

            break;

            
            case 0:
            b1 = new BancoMaut(new Cliente(JOptionPane.showInputDialog(null, "Nome do cliente: "), 
            Integer.parseInt(JOptionPane.showInputDialog(null, "CPF: ")),
            Integer.parseInt(JOptionPane.showInputDialog(null, "Data de Nascimento: ")),
            JOptionPane.showInputDialog(null, "Endereço: ")));

            contas.add(b1);
            x = 1;    
            break;
        }
            
        } while (x != 0);
          
        
    }

    
}
