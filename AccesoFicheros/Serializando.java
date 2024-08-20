package AccesoFicheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Serializando {
    public static void main(String[] args) {
        Administrador jefe = new Administrador("Juan", 80000, 2005, 12, 15);
        jefe.setIncentivo(5000);

        Empleado[] personal = new Empleado[3];
        personal[0] = jefe;
        personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
        personal[2] = new Empleado("Luis", 18000, 2012, 9, 15);

        try{
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("D:/AMD/Desktop/Curso Java/PildorasInformaticas/GitPildorasInformaticas/AccesoFicheros/empleado.dat"));
            escribiendoFichero.writeObject(personal);
            escribiendoFichero.close();

            ObjectInputStream recuperandoFichero = new ObjectInputStream(new FileInputStream("D:/AMD/Desktop/Curso Java/PildorasInformaticas/GitPildorasInformaticas/AccesoFicheros/empleado.dat"));
            Empleado[] personalRecuperado = (Empleado[])recuperandoFichero.readObject();
            recuperandoFichero.close();

            for(Empleado e : personalRecuperado){
                System.out.println(e);
            }
        }catch(Exception e){

        }
    }
}

class Empleado implements Serializable{

    private static final long serialVersionUID = 1L;

    public Empleado(String n, double s, int año, int mes, int dia){
        nombre = n;
        sueldos = s;

        GregorianCalendar calendario = new GregorianCalendar(año, mes, dia);

        fechaContrato = calendario.getTime();
    }

    public String getNombre(){
        return nombre;
    }

    public double getSueldo(){
        return sueldos;
    }

    public Date getFechaContrato(){
        return fechaContrato;
    }

    public void subirSueldo(double porcentaje){
        double aumento = sueldos * porcentaje / 100;
        sueldos += aumento;
    }

    public String toString(){
        return "El nombre es: " + nombre + ", y su sueldo es: " + sueldos + ", Fecha de contrato: " + fechaContrato;
    }

    private String nombre;
    private double sueldos;
    private Date fechaContrato;
}

class Administrador extends Empleado{

    private static final long serialVersionUID = 1L;

    public Administrador(String n, double s, int año, int mes, int dia){
        super(n, s, año, mes, dia);
        incentivo = 0;
    }

    public double getSueldo(){
        double sueldoBase = super.getSueldo();
        return sueldoBase + incentivo;
    }

    public void setIncentivo(double b){
        incentivo = b;
    }

    public String toString(){
        return super.toString() + " Incentivo: " + incentivo;
    }

    private double incentivo;
}