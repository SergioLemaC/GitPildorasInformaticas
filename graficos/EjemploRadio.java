package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class EjemploRadio {
    public static void main(String[] args) {
        MarcoRadio miMarco = new MarcoRadio();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoRadio extends JFrame{
    public MarcoRadio(){
        setVisible(true);
        setBounds(550, 300, 500, 350);

        LaminaRadio miLamina = new LaminaRadio();
        add(miLamina);
    }
}

class LaminaRadio extends JPanel{
    public LaminaRadio(){
        setLayout(new BorderLayout());

        texto = new JLabel("En un lugar de la mancha de cuyo nombre...");

        texto.setFont(new Font("Serif", Font.PLAIN, 12));

        add(texto, BorderLayout.CENTER);

        laminaBotones = new JPanel();

        miGrupo = new ButtonGroup();
        
        // ButtonGroup miGrupo = new ButtonGroup();

        // boton1 = new JRadioButton("Pequeño", false);
        // boton2 = new JRadioButton("Mediano", true);
        // boton3 = new JRadioButton("Grande", false);
        // boton4 = new JRadioButton("Muy grande", false);

        // JPanel laminaRadio = new JPanel();

        // EventoRadio miEvento = new EventoRadio();
        // boton1.addActionListener(miEvento);
        // boton2.addActionListener(miEvento);
        // boton3.addActionListener(miEvento);
        // boton4.addActionListener(miEvento);

        // miGrupo.add(boton1);
        // miGrupo.add(boton2);
        // miGrupo.add(boton3);
        // miGrupo.add(boton4);

        // laminaRadio.add(boton1);
        // laminaRadio.add(boton2);
        // laminaRadio.add(boton3);
        // laminaRadio.add(boton4);

        // add(laminaRadio, BorderLayout.SOUTH);

        colocarBotones("Pequeño", false, 10);
        colocarBotones("Mediano", true, 12);
        colocarBotones("Grande", false, 18);
        colocarBotones("Muy grande", false, 26);

        add(laminaBotones, BorderLayout.SOUTH);
    }

    public void colocarBotones(String nombre, boolean seleccionado, final int tamaño){
        JRadioButton boton = new JRadioButton(nombre, seleccionado);

        miGrupo.add(boton);

        laminaBotones.add(boton);

        ActionListener miEvento = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
                texto.setFont(new Font("Serif", Font.PLAIN, tamaño));
            }
            
        };
        boton.addActionListener(miEvento);
    }

    // private class EventoRadio implements ActionListener{

    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         // TODO Auto-generated method stub
            
    //         if(e.getSource() == boton1){
    //             texto.setFont(new Font("Serif", Font.PLAIN, 10));
    //         }else if(e.getSource() == boton2){
    //             texto.setFont(new Font("Serif", Font.PLAIN, 12));
    //         }else if(e.getSource() == boton3){
    //             texto.setFont(new Font("Serif", Font.PLAIN, 18));
    //         }else if(e.getSource() == boton4){
    //             texto.setFont(new Font("Serif", Font.PLAIN, 24));
    //         }
    //     }
        
    // }

    private JLabel texto;
    //private JRadioButton boton1, boton2, boton3, boton4;
    private ButtonGroup miGrupo;
    private JPanel laminaBotones;
}