package graficos;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculadoraLayouts {
    public static void main(String[] args) {
        MarcoCalculadora miMarco = new MarcoCalculadora();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoCalculadora extends JFrame{
    public MarcoCalculadora(){
        setTitle("Calculadora");
        setBounds(500, 300, 450, 300);

        LaminaCalculadora miLamina = new LaminaCalculadora();
        add(miLamina);
    }
}

class LaminaCalculadora extends JPanel{
    public LaminaCalculadora(){
        setLayout(new BorderLayout());

        JButton pantalla = new JButton("0");
        pantalla.setEnabled(false);
        add(pantalla, BorderLayout.NORTH);

        miLamina2 = new JPanel();
        miLamina2.setLayout(new GridLayout(4, 4));

        ponerBoton("7");
        ponerBoton("8");
        ponerBoton("9");
        ponerBoton("/");

        ponerBoton("4");
        ponerBoton("5");
        ponerBoton("6");
        ponerBoton("*");

        ponerBoton("1");
        ponerBoton("2");
        ponerBoton("3");
        ponerBoton("-");

        ponerBoton("0");
        ponerBoton(".");
        ponerBoton("=");
        ponerBoton("+");

        add(miLamina2, BorderLayout.CENTER);
    }

    private void ponerBoton(String rotulo){
        JButton boton = new JButton(rotulo);
        miLamina2.add(boton);
    }
    private JPanel miLamina2;
}