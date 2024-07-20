package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VariosOyentes {
    public static void main(String[] args) {
        MarcoPrincipal miMarco = new MarcoPrincipal();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoPrincipal extends JFrame{
    public MarcoPrincipal(){
        setTitle("Prueba Varios");
        setBounds(1300, 100, 300, 200);

        LaminaPrincipal lamina = new LaminaPrincipal();
        add(lamina);
    }
}

class LaminaPrincipal extends JPanel{
    public LaminaPrincipal(){
        JButton botonNuevo = new JButton("Nueva");
        add(botonNuevo);

        botonCerrar = new JButton("Cerrar todo");
        add(botonCerrar);

        OyenteNuevo miOyente = new OyenteNuevo();
        botonNuevo.addActionListener(miOyente);
    }

    private class OyenteNuevo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            MarcoEmergente marco = new MarcoEmergente(botonCerrar);
            marco.setVisible(true);
        }
        
    }

    JButton botonCerrar;
}

class MarcoEmergente extends JFrame{
    public MarcoEmergente(JButton botonDePrincipal){
        contador++;
        setTitle("Ventana " + contador);

        setBounds(40*contador, 40*contador, 300, 150);

        CierraTodos oyenteCerrar = new CierraTodos();
        botonDePrincipal.addActionListener(oyenteCerrar);
    }

    private class CierraTodos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            dispose();
        }
        
    }

    private static int contador = 0;
}
