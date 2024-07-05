
import java.util.Scanner;

/**
 *
 * @author Sergio
 */
public class CondicionalesIfySwitch {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce tu edad: ");
        int edad = teclado.nextInt();
        if(edad<18){
            System.out.println("Eres un adolescente");
        }else if(edad<40){
            System.out.println("Eres joven");
        }else if(edad<65){
            System.out.println("Eres maduro");
        }else{
            System.out.println("Cuídate");
        }
    }
}
