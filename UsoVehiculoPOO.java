import javax.swing.*;

public class UsoVehiculoPOO{
    public static void main(String[] args) {
        //Creamos un objeto de la clase CarroPOO
        /*CarroPOO Renault = new CarroPOO(); //Instanciar la clase
        //System.out.println("Este carro tiene " + Renault.ruedas + " ruedas");
        System.out.println(Renault.dimeLargo());

        Renault.estableceColor(JOptionPane.showInputDialog("Introduce color"));
        System.out.println(Renault.dimeColor());

        System.out.println("");
        System.out.println(Renault.dimeDatosGenerales());

        Renault.configuraAsientos(JOptionPane.showInputDialog("Contiene asientos de cuero¿?"));
        System.out.println(Renault.dimeAsientos());

        System.out.println("");
        Renault.configuraClimatizador(JOptionPane.showInputDialog("Contiene climatizador¿?"));

        System.out.println(Renault.dimeClimatizador());
        System.out.println(Renault.dimePesoCarro());

        System.out.println("El precio del carro es: $" + Renault.precioCarro());*/

        System.out.println("------------Furgoneta------------");

        //Instancia de la clase FurgonetaPOO

        CarroPOO miCarro = new CarroPOO();
        miCarro.estableceColor("Rojo");
        FurgonetaPOO miFurgoneta = new FurgonetaPOO(7, 580);
        miFurgoneta.estableceColor("Azul");
        miFurgoneta.configuraAsientos("Si");
        miFurgoneta.configuraClimatizador("Si");

        System.out.println(miCarro.dimeDatosGenerales() + " " + miCarro.dimeColor());

        System.out.println("");

        System.out.println(miFurgoneta.dimeDatosGenerales() + " " +
        miFurgoneta.dimeDatosFurgoneta());

    }
}