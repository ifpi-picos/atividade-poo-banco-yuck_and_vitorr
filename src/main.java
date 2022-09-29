import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) throws Exception {
    
        BancoMaut b1 = new BancoMaut(new Cliente(JOptionPane.showInputDialog(null, "Nome do cliente: "), 
        Integer.parseInt(JOptionPane.showInputDialog(null, "CPF: ")),
        Integer.parseInt(JOptionPane.showInputDialog(null, "Data de Nascimento: ")),
        JOptionPane.showInputDialog(null, "Endereço: ")));

        String [] r = new String[]{"ENCERRAR", "DEPOSITO", "SAQUE", "STATUS"};

        int x = 0;

        do {
        int op = JOptionPane.showOptionDialog(null, "ESCOLHA A OPERAÇÃO", "BANCO MAUT", 
        JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, r, 0);

        switch (op) {
            case 1:
            b1.depositar(Integer.parseInt(JOptionPane.showInputDialog(null, "Valor de deposito: ")));
            x = 1;     
            break;
            
            case 2:
            b1.sacar(Integer.parseInt(JOptionPane.showInputDialog(null, "Valor de saque: ")));
            x = 1;    
            break;
                
            case 3:
            b1.statusDaConta();
            x = 1;
            break;   

            case 0:
            default:
            x = 0;    
            break;
        }
            
        } while (x != 0);
          
        
    }
    
}
