package notificacoes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Sms implements Notificacao{

    LocalDateTime atual = LocalDateTime.now();
    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    String dataAtual = formatoData.format(atual);
    
    @Override
    public void enviarNotificacao(String operacao, double valor) {
        
        JOptionPane.showMessageDialog(null, "\tSMS\n" + operacao + " COM VALOR DE:" + valor + "\n" + dataAtual);

    }
    

}
