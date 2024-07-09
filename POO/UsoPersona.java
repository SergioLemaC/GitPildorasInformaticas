package POO;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoPersona {
    public static void main(String[] args) {
        Persona[] lasPersonas = new Persona[2];
        lasPersonas[0] = new Empleado2("Luis Conde", 50000, 2009, 02, 25);
        lasPersonas[1] = new Alumno("Ana López", "Biológicas");

        for (Persona p : lasPersonas) {
            System.out.println(p.dameNombre() + ", " + p.dameDescripcion());
        }
    }
}

abstract class Persona{
    public Persona(String nom){
        nombre = nom;
    }

    public String dameNombre(){
        return nombre;
    }

    public abstract String dameDescripcion();

    private String nombre;
}

//Heredamos de la clase Persona (extends)
class Empleado2 extends Persona{
    public Empleado2(String nom, double sue, int año, int mes, int dia){
        //Invocamos el constructor de la clase padre (super)
        super(nom);
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

    //Sobreescribimos la clase asbtracta
    public String dameDescripcion(){
        return "Este empleado tiene un Id = " + Id + " con un sueldo = $" + sueldo;
    }

    private double sueldo;
    private Date altaContrato;
    //Fuera de los vídeos
    private static int IdSiguiente;
    private int Id;
}

class Alumno extends Persona{
    public Alumno(String nom, String carr){
        super(nom);
        carrera = carr;
    }

    public String dameDescripcion(){
        return "Este alumno está estudiando " + carrera;
    }

    private String carrera;
}