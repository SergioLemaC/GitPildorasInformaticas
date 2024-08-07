package practicas;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class LaminaBotones extends JPanel{
    public LaminaBotones(String titulo, String[] opciones){
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        ButtonGroup grupo = new ButtonGroup();

        for(int i = 0; i<opciones.length; i++){
            JRadioButton bot = new JRadioButton(opciones[i]);
            add(bot);
            grupo.add(bot);
            bot.setSelected(i == 0);
        }
    }
}
