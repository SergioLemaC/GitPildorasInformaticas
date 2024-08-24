package ProgramacionGenerica;

public class HerenciaGenericos {
    public static void main(String[] args) {
        /*Empleado administrativa = new Empleado("Elena", 44, 1500);

        Jefe directoraComercial = new Jefe("Ana", 27, 3500);

        Empleado nuevoEmpleado = directoraComercial;*/

        Pareja<Empleado> administrativa = new Pareja<Empleado>();

        Pareja<Jefe> directoraComercial = new Pareja<Jefe>();

        Pareja.imprimirTrabajador(administrativa);

        Pareja.imprimirTrabajador(directoraComercial);
    }
}
