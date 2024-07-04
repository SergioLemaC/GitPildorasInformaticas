
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio
 */
public class Bucles {
    public static void main(String[] args) {
        String clave = "klk";
        String pass = "";
        
        while(clave.equals(pass) == false){
            pass = JOptionPane.showInputDialog("Introduce la clave");
            if(clave.equals(pass) == false){
                System.out.println("Clave incorrecta");
            }
        }
        System.out.println("Bienvenido");
    }
}
