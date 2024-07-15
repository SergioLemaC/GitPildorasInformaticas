package graficos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class EventosVentana {
    public static void main(String[] args) {
        MarcoVentana miMarco = new MarcoVentana();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MarcoVentana miMarco2 = new MarcoVentana();
        miMarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        miMarco.setTitle("Ventana 1");
        miMarco.setBounds(300, 300, 500, 350);
        miMarco2.setTitle("Ventana 2");
        miMarco2.setBounds(900, 300, 500, 350);

    }
}

class MarcoVentana extends JFrame{
    public MarcoVentana(){
        //setTitle("Respondiendo");
        //setBounds(300, 300, 500, 350);
        setVisible(true);

        /*MVentana oyenteVentana = new MVentana();
        addWindowListener(oyenteVentana);*/
        addWindowListener(new MVentana());
    }
}

class MVentana extends WindowAdapter{
    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Ventana minimizada");
    }
}

/*class MVentana implements WindowListener{

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Ventana Activada");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
        System.out.println("La ventana ha sido cerrada");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Cerrando ventana");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Ventana desactivada");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Ventana restaurada");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Ventana minimizada");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Ventana abierta");
    }
    
}*/