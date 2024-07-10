package POO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class PruebaTemporizador {
    public static void main(String[] args) {
        DameLaHora oyente = new DameLaHora();
        //ActionListener oyente = new DameLaHora();
        Timer miTemporizador = new Timer(5000, oyente);
        miTemporizador.start();
        JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener");
        System.exit(0);
    }
}

class DameLaHora implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Date ahora = new Date();
        System.out.println("Te doy la hora cada 5 segs: " + ahora);
    }
}