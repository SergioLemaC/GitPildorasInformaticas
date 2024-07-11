package POO;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class PruebaClaseInterna {
    public static void main(String[] args) {
        Reloj miReloj = new Reloj(3000, true);
        miReloj.enMarcha();

        JOptionPane.showMessageDialog(null, "Pulsa Ok para terminar");
        System.exit(0);
    }
}

class Reloj{

    public Reloj(int intervalo, boolean sonido){
        this.intervalo = intervalo;
        this.sonido = sonido;
    }

    public void enMarcha(){
        ActionListener oyente = new DameLaHora2();

        Timer miTemporizador = new Timer(intervalo, oyente);

        miTemporizador.start();
    }

    private int intervalo;
    private boolean sonido;

    private class DameLaHora2 implements ActionListener{
        public void actionPerformed(ActionEvent evento){
            Date ahora = new Date();
            System.out.println("Te doy la hora cada 3 segs: " + ahora);

            if(sonido){
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
