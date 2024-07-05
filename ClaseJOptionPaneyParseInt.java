import javax.swing.JOptionPane;
/**
 *
 * @author Sergio
 */
public class ClaseJOptionPaneyParseInt {
    public static void main(String[] args) {
        /*String nombre = JOptionPane.showInputDialog("Introduce el nombre");
        String edad = JOptionPane.showInputDialog("Introduce la edad");
        int edad_u = Integer.parseInt(edad);
        System.out.println("Hola " + nombre + ", pronto vas a cumplir " + (edad_u+1));*/
        String num1 = JOptionPane.showInputDialog("Introduce un número");
        double num2 = Double.parseDouble(num1);
        System.out.print("La raíz cuadrada de " + num1 + " es: ");
        System.out.printf("%1.2f", Math.sqrt(num2));
        System.out.println("");
    }
}
