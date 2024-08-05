package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TiposCuadrosDialogos {
    public static void main(String[] args) {
        CuadrosDialogos miMarco = new CuadrosDialogos();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class CuadrosDialogos extends JFrame{
    public CuadrosDialogos(){
        setBounds(500, 300, 400, 250);
        add(new LaminaCuadrosDialogos());
    }
}

class LaminaCuadrosDialogos extends JPanel{
    public LaminaCuadrosDialogos(){
        boton1 = new JButton("Botón 1");
        boton2 = new JButton("Botón 2");
        boton3 = new JButton("Botón 3");
        boton4 = new JButton("Botón 4");

        boton1.addActionListener(new AccionBotones());
        boton2.addActionListener(new AccionBotones());
        boton3.addActionListener(new AccionBotones());
        boton4.addActionListener(new AccionBotones());

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
    }

private class AccionBotones implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
        if(e.getSource() == boton1){
            JOptionPane.showMessageDialog(LaminaCuadrosDialogos.this, "Mensaje de prueba", "Advertencia", 0);
        }else if(e.getSource() == boton2){
            JOptionPane.showInputDialog(LaminaCuadrosDialogos.this,"Introduce nombre", "Introducción datos", 2);
        }else if(e.getSource() == boton3){
            JOptionPane.showConfirmDialog(LaminaCuadrosDialogos.this, "Elige opción",  "V confirmar", 1);
        }else{
            JOptionPane.showOptionDialog(LaminaCuadrosDialogos.this, "Elige", "V de opciones", 1, 3, null, null, null);
        }
    }
    
}

private JButton boton1, boton2, boton3, boton4;

}