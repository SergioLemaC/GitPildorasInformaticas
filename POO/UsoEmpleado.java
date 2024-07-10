package POO;
//Esta es una forma de programar con un solo fichero o archivo

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class UsoEmpleado {
    public static void main(String[] args) {
        Jefatura jefeRRHH = new Jefatura("Juan", 55000, 2006, 9, 25);
        jefeRRHH.estableceIncentivo(2570);

        /*Empleado empleado1 = new Empleado("Paco Gómez", 85000, 1990, 12, 17);
        Empleado empleado2 = new Empleado("Ana López", 95000, 1995, 06, 02);
        Empleado empleado3 = new Empleado("Maria Martín", 105000, 2002, 03, 15);

        empleado1.subeSueldo(5);
        empleado2.subeSueldo(5);
        empleado3.subeSueldo(5);

        System.out.println("Nombre: " + empleado1.dameNombre() + " Sueldo: $" + empleado1.dameSueldo() + 
        " Fecha de alta: " + empleado1.dameFechaContrato());

        System.out.println("Nombre: " + empleado2.dameNombre() + " Sueldo: $" + empleado2.dameSueldo() + 
        " Fecha de alta: " + empleado2.dameFechaContrato());

        System.out.println("Nombre: " + empleado3.dameNombre() + " Sueldo: $" + empleado3.dameSueldo() + 
        " Fecha de alta: " + empleado3.dameFechaContrato());*/

        Empleado[] misEmpleados = new Empleado[6];

        misEmpleados[0] = new Empleado("Paco Gómez", 85000, 1990, 12, 17);
        misEmpleados[1] = new Empleado("Ana López", 95000, 1995, 06, 02);
        misEmpleados[2] = new Empleado("Maria Martín", 105000, 2002, 03, 15);
        misEmpleados[3] = new Empleado("Antonio Fernández");
        misEmpleados[4] = jefeRRHH;
        misEmpleados[5] = new Jefatura("María", 95000, 1999, 5, 26);
        //Refundición o casting de objetos
        Jefatura jefaFinanzas = (Jefatura) misEmpleados[5];
        jefaFinanzas.estableceIncentivo(55000);

        /*for(int i = 0; i < 3; i++){
            misEmpleados[i].subeSueldo(5);
        }*/

        //Implementando Interfaces

        /*Empleado directorComercial = new Jefatura("Sandra", 85000, 2012, 05, 05);
        Comparable ejemplo = new Empleado("Elizabeth", 95000, 2011, 06, 07);

        if(directorComercial instanceof Empleado){
            System.out.println("Es de tipo Jefatura");
        }

        if(ejemplo instanceof Comparable){
            System.out.println("Implementa la interfaz Comparable");
        }*/

        System.out.println(jefaFinanzas.tomarDecisiones("Dar más días de vacaciones a los empleados"));

        for(Empleado e: misEmpleados){
            e.subeSueldo(5);
        }

        Arrays.sort(misEmpleados);

        /*for(int i = 0; i < 3; i++){
            System.out.println("Nombre: " + misEmpleados[i].dameNombre() + 
            " Sueldo: $" + misEmpleados[i].dameSueldo() + " Fecha de alta: " + misEmpleados[i].dameFechaContrato());
        }*/

        for(Empleado e: misEmpleados){
            System.out.println("Nombre: " + e.dameNombre() + 
            " Sueldo: $" + e.dameSueldo() + " Fecha de alta: " + e.dameFechaContrato());
        }
    }
}

class Empleado implements Comparable{
    public Empleado(String nom, double sue, int año, int mes, int dia){
        nombre = nom;
        sueldo = sue;
        //Para establecer la fecha en este caso usaremos la clase GregorianCalendar
        //Esta clase de la API de Java, que lo que hace es construir una fecha
        //y se construye con los parámetros int que le estamos pasando al constructor
        //GregorianCalendar() como tal te da la fecha actual, como TIMESTAMP en SQL
        //Pero los que reciben argumentos te devuelve ese formato fecha con los datos que le pases
        GregorianCalendar calendario = new GregorianCalendar(año, mes-1, dia);
        altaContrato = calendario.getTime();
        //Fuera de los vídeos
        ++IdSiguiente;
        Id=IdSiguiente;
    }

    public Empleado(String nom){
        //De esta forma cuando solo tienes que usar uno de los constructores
        //y ponerle datos por defecto usamos this(con argumentos) para usar el otro
        //constructor y recibir uno de los datos para no quedar sin nada
        this(nom, 30000, 2000, 01, 01);
    }

    public String dameNombre(){
        //Fuera de los vídeos
        return nombre + " Id: " + Id;
    }

    public double dameSueldo(){
        return sueldo;
    }

    public Date dameFechaContrato(){
        return altaContrato;
    }

    public void subeSueldo(double porcentaje){
        double aumento = sueldo*porcentaje/100;
        sueldo += aumento;
    }

    //Sobreescribimos la función compareTo que viene en la interfaz (Comparable)
    public int compareTo(Object miObject){
        Empleado otroEmpleado = (Empleado) miObject;
        if(this.Id<otroEmpleado.Id){
            return -1;
        }
        if(this.Id>otroEmpleado.Id){
            return 1;
        }

        return 0;
    }

    private String nombre;
    private double sueldo;
    private Date altaContrato;
    //Fuera de los vídeos
    private static int IdSiguiente;
    private int Id;
}

//Cortar la cadena de herencia para que no hayan más subclases a partir de esta (final)
class Jefatura extends Empleado implements Jefes{
    public Jefatura(String nom, double sue, int año, int mes, int dia){
        //Super para llamar al constructor de la clase padre
        super(nom, sue, año, mes, dia);
    }

    public String tomarDecisiones(String decision){
        return "Un miembro de la dirección ha tomado la decisión de: " + decision;
    }

    public void estableceIncentivo(double b){
        incentivo = b;
    }

    //Sobreescritura de métodos
    public double dameSueldo(){
        //Al colocar el super, este hace que llame la función de la clase padre
        double sueldoJefe = super.dameSueldo();
        return sueldoJefe + incentivo;
    }

    private double incentivo;
}

