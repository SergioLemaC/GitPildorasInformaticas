
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

        System.out.println("Entrenando git antes de usar una nueva rama creada");


        System.out.println("Este es un párrafo añadido desde ramex");

        System.out.println("Cambio desde la rama master");


        System.out.println("Párrafo desde adicional");

        System.out.println("Esto lo hago desde la app GitHub en el teléfono");
    }
}
