package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Sergio
 */
public class CreandoMarcos {
    public static void main(String[] args) {
        MiMarco marco1 = new MiMarco();
        
        marco1.setVisible(true);
        
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MiMarco extends JFrame{
    public MiMarco(){
        //setSize(500, 300);
        //setLocation(500,300);
        
        //setBounds(500, 300, 550, 250);
        
        //setResizable(false);
        
        //setExtendedState(Frame.MAXIMIZED_BOTH);
        
        Toolkit miPantalla  = Toolkit.getDefaultToolkit();
        
        Dimension tamañoPantalla = miPantalla.getScreenSize();
        
        int alturaPantalla = tamañoPantalla.height;
        
        int anchoPantalla = tamañoPantalla.width;
        
        setSize(anchoPantalla, alturaPantalla);
        
        setLocation(anchoPantalla/4, alturaPantalla/4);
        
        setTitle("Yonki Programón");
        
        Image miIcono = miPantalla.getImage("icono.gif");
        
        setIconImage(miIcono);
    }
}