package practicas;

import javax.swing.JFrame;

public class AplicacionDialogos {
    public static void main(String[] args) {
        MarcoDialogo miMarco = new MarcoDialogo();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}
