/**
 *
 * @author Sergio
 */
public class ClaseMathyString {
    public static void main(String[] args) {
        
        //CLASE Math***************************************
        System.out.println("Función round - Redondeo");
        double num1 = 5.85;
        int resultado = (int)Math.round(num1);
        System.out.println(resultado);
        
        
        System.out.println("Función pow - Potencia");
        double base = 5;
        double exp = 3;
        int resp = (int)Math.pow(base, exp);
        System.out.println(resp);
        
        //CLASE String******************************************
        System.out.println("Función length - Longitud de texto");
        String nombre = "Sergio";
        System.out.println("Mi nombre es " + nombre);
        System.out.println("Mi nombre tiene " + nombre.length() + " letras");
        
        
        System.out.println("Función charAt - Posición desde un índice");
        System.out.println("La primera letra de mi nombre es " + nombre.charAt(0));
        int ultima_letra = nombre.length();
        System.out.println("La ultima letra de mi nombre es " + nombre.charAt(ultima_letra-1));
        
        
        System.out.println("Función substring - Subcadena de un texto");
        String frase = "Eleganteklk";
        String frase_resumida = frase.substring(1, 3);
        System.out.println(frase_resumida);
        
        
        System.out.println("Función equals & equalsIgnoreCase - Compara "
                + "si dos cadenas de texto son iguales");
        String nombre1, nombre2, nombre3;
        nombre1 = "Sergio";
        nombre2 = "Sergio";
        nombre3 = "sergio";
        
        //Esta es la que jode por mayúsculas y minúsculas
        System.out.println(nombre1.equals(nombre2));
        System.out.println(nombre1.equals(nombre3));
        
        //Esta no jode por eso
        System.out.println(nombre1.equalsIgnoreCase(nombre3));
    }
}
