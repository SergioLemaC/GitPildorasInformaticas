package graficos;

import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

public class Pruebas {
    public static void main(String[] args) {
        //Mirar los tipos de fuentes que tenemos instalados en el sistema operativo

        String fuente = JOptionPane.showInputDialog("Introduce fuente");
        boolean estaLaFuente = false;

        String [] nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (String nombreDeFuente : nombresDeFuentes) {
            if(nombreDeFuente.equalsIgnoreCase(fuente)){
                estaLaFuente = true;
            }
        }

        if(estaLaFuente){
            System.out.println("Fuente instalada");
        }else{
            System.out.println("No está instalada");
        }
    }
}
