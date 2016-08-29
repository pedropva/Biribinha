package Apps;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class StatusBar extends JPanel{	
    public JLabel texto;
    public StatusBar(String tx){
        texto = new JLabel(tx);        
        this.add(texto);
        
        Border borda = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);       
        this.setBorder(borda);
        
        this.setLayout(new BoxLayout(this, 1));
        
        this.setVisible(true);
        
    }
    public void setTexto(String tx){
    	texto.setText(tx);
    }
}
