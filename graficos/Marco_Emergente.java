package graficos;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class Marco_Emergente {
    public static void main(String[] args) {
        MarcoEmergenteM miMarco = new MarcoEmergenteM();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoEmergenteM extends JFrame{
    public MarcoEmergenteM(){
        setBounds(100, 100, 300, 250);

        LaminaEmergenteM miLamina = new LaminaEmergenteM();
        add(miLamina);
        setVisible(true);
    }
}

class LaminaEmergenteM extends JPanel{
    public LaminaEmergenteM(){
        JPopupMenu emergente = new JPopupMenu();

        JMenuItem opcion1 = new JMenuItem("Opción 1");
        JMenuItem opcion2 = new JMenuItem("Opción 2");
        JMenuItem opcion3 = new JMenuItem("Opción 3");

        emergente.add(opcion1);
        emergente.add(opcion2);
        emergente.add(opcion3);
        
        setComponentPopupMenu(emergente);
    }
}