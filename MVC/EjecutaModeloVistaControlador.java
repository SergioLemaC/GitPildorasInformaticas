package MVC;

import javax.swing.JFrame;

import MVC.vista.MarcoAplicacion;

public class EjecutaModeloVistaControlador {
    public static void main(String[] args) {
        MarcoAplicacion miMarco = new MarcoAplicacion();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}
