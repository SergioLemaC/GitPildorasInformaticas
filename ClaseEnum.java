import java.util.Scanner;

public class ClaseEnum {
    enum Talla{
        MINI("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");

        private Talla(String abreviatura){
            this.abreviatura = abreviatura;
        }

        public String dameAbreviatura(){
            return abreviatura;
        }

        private String abreviatura;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe una talla: MINI, MEDIANO, GRANDE, MUY_GRANDE");

        String entradaDatos = sc.next().toUpperCase();

        sc.close();

        Talla laTalla = Enum.valueOf(Talla.class, entradaDatos);

        System.out.println("Talla: " + laTalla);

        System.out.println("Abreviatura: " + laTalla.dameAbreviatura());
    }
}
