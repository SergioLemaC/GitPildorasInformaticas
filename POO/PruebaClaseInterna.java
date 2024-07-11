package POO;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class PruebaClaseInterna {
    public static void main(String[] args) {
        Reloj miReloj = new Reloj();
        miReloj.enMarcha(3000, true);

        JOptionPane.showMessageDialog(null, "Pulsa Ok para terminar");
        System.exit(0);
    }
}

class Reloj {

    public void enMarcha(int intervalo, final boolean sonido) {
        // Clase Interna - y ahora es clase interna local
        class DameLaHora2 implements ActionListener {
            public void actionPerformed(ActionEvent evento) {
                Date ahora = new Date();
                System.out.println("Te doy la hora cada 3 segs: " + ahora);

                if (sonido) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }
        ActionListener oyente = new DameLaHora2();

        Timer miTemporizador = new Timer(intervalo, oyente);

        miTemporizador.start();
    }
}
