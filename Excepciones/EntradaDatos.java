package Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaDatos {
    public static void main(String[] args) {
        System.out.println("Qué deseas hacer¿?");
        System.out.println("1. Introducir datos");
        System.out.println("2. Salir del programa");

        Scanner teclado = new Scanner(System.in);

        int decision = teclado.nextInt();

        if(decision == 1){
            try{
                pedirDatos();
            }catch(InputMismatchException e){
                System.out.println("Qué putas pusiste ahí?????");
            }
        }else{
            System.out.println("Adiós");
            System.exit(0);
        }

        teclado.close();
    }

    public static void pedirDatos() throws InputMismatchException{
        //try{
            Scanner teclado = new Scanner(System.in);

            System.out.println("Introduce tu nombre, por favor");

            String nombreUsuario = teclado.nextLine();

            System.out.println("Introduce tu edad, por favor");

            int edad = teclado.nextInt();

            System.out.println("Hola " + nombreUsuario + ", el año que viene tendrás " + (edad + 1) + " años");

            teclado.close();
        /*}catch(Exception e){
            System.out.println("Qué putas pusiste ahí?????");
        }*/

        System.out.println("Hemos terminado");
    }

}
