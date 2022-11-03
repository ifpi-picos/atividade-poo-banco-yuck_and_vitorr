package notificacoes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Email implements Notificacao{

    LocalDateTime atual = LocalDateTime.now();
    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    String dataAtual = formatoData.format(atual);
      
    @Override
    public void enviarNotificacao(String operacao, double valor) {
        
        JOptionPane.showMessageDialog(null, "\tEMAIL\n" + operacao + " COM VALOR DE:" + valor + "\n" + dataAtual);

    }
    
}
