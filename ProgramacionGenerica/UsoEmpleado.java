package ProgramacionGenerica;

import java.util.ArrayList;
import java.util.Iterator;

public class UsoEmpleado {
    public static void main(String[] args) {

        //USANDO ArrayList

        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

        //listaEmpleados.ensureCapacity(4); //Asignar la cantidad de elementos mínimos que puede tener el ArrayList

        listaEmpleados.add(new Empleado("Ana", 45, 2500));
        listaEmpleados.add(new Empleado("Antonio", 55, 2000));
        listaEmpleados.add(new Empleado("María", 25, 2600));

        listaEmpleados.set(1, new Empleado("Juan", 20, 2200));

        //listaEmpleados.trimToSize(); //Con este recortas el sobrante de memoria que queda cuando no se ocupa todo el ArrayList

        System.out.println(listaEmpleados.size()); //Ver la cantidad de elementos que tiene en su interior


        //VARIAS FORMAS DE RECORRER UN ArrayList

        /*for (Empleado e : listaEmpleados) {
            System.out.println(e.dameDatos());
        }*/

        Iterator<Empleado> miIterador = listaEmpleados.iterator();

        while (miIterador.hasNext()) {
            System.out.println(miIterador.next().dameDatos());
        }

        /*for(int i = 0; i < listaEmpleados.size(); i++){
            Empleado e = listaEmpleados.get(i);
            System.out.println(e.dameDatos());
        }*/

        /*Empleado arrayEmpleados[] = new Empleado[listaEmpleados.size()];
        listaEmpleados.toArray(arrayEmpleados);

        for(int i = 0; i < arrayEmpleados.length; i++){
            System.out.println(arrayEmpleados[i].dameDatos());
        }*/

        //System.out.println(listaEmpleados.get(1).dameDatos());
    }
}

class Empleado{
    public Empleado(String nombre, int edad, double salario){
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String dameDatos(){
        return "El empleado se llama: " + nombre + ", tiene " + edad + " años, y un salario de: " + salario;
    }

    private String nombre;
    private int edad;
    private double salario;
}

class Jefe extends Empleado{
    public Jefe(String nombre, int edad, double salario){
        super(nombre, edad, salario);
    }

    double incentivo(double inc){
        return inc;
    }
}