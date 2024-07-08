
import java.util.Scanner;

/**
 *
 * @author Sergio
 */
public class ClaseScanner {
    public static void main(String[] args) {
        //CLASE Scanner***********************************
        System.out.println("Clase Scanner - Para introducir datos"
                + " desde el teclado mediante cmd de Netbeans");
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Introduce tu edad: ");
        int edad = teclado.nextInt();
        System.out.println("Hola " + nombre + ", tienes " + edad + " años!.");
        
        //Maricaditas del Visual Studio
        teclado.close();
    }
}
