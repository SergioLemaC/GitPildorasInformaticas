package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EjemploTextArea {
    public static void main(String[] args) {
        MarcoArea miMarco = new MarcoArea();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoArea extends JFrame{
    public MarcoArea(){
        setBounds(500, 300, 500, 350);

        LaminaArea miLamina = new LaminaArea();
        add(miLamina);
        setVisible(true);
    }
}

class LaminaArea extends JPanel{
    public LaminaArea(){
        miArea = new JTextArea(8, 20);

        JScrollPane laminaBarras = new JScrollPane(miArea);

        miArea.setLineWrap(true); //Permitir o no que se expanda el área o poner salto de línea horizontalmente
        add(laminaBarras);

        JButton miBoton = new JButton("Dale");
        miBoton.addActionListener(new GestionaArea());
        add(miBoton);
    }

    private class GestionaArea implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
            System.out.println(miArea.getText());
        }
        
    }
    private JTextArea miArea;
}