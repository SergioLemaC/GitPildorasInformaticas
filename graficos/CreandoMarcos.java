package graficos;

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
        setSize(500, 300);
    }
}