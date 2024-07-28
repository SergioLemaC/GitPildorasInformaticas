package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LibreDisposicion {
    public static void main(String[] args) {
        MarcoLibre miMarco = new MarcoLibre();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoLibre extends JFrame{
    public MarcoLibre(){
        setBounds(450,350,600,400);

        LaminaLibre miLamina = new LaminaLibre();
        add(miLamina);

        setVisible(true);
    }
}

class LaminaLibre extends JPanel{
    public LaminaLibre(){
        setLayout(null);

        JButton boton1 = new JButton("Botón 1");
        boton1.setBounds(50, 50, 150, 50);
        add(boton1);
    }
}