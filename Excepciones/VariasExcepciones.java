package Excepciones;

import javax.swing.JOptionPane;

public class VariasExcepciones {
    public static void main(String[] args) {
        try{
            division();
        }catch(ArithmeticException e){
            System.out.println("Estás dividiendo por cero");
        }catch(NumberFormatException e){
            System.out.println("No haz introducido un número entero");
            System.out.println(e.getMessage()); //Nos informa acerca del error
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }
    }

    public static void division(){
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo"));

        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el divisor"));

        System.out.println("El resultado es: " + num1 / num2);
    }
}
