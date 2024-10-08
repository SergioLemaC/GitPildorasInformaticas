package ProgramacionConcurrente;

public class SincronizandoHilos {
    public static void main(String[] args) {
        HilosVarios hilo1 = new HilosVarios();
        //hilo1.start();

        //La función Join() indica que hasta que no muera o se acabe ese hilo, no se ejecute el siguiente
        /*try {
            hilo1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

        HilosVarios2 hilo2 = new HilosVarios2(hilo1);
        hilo2.start();
        hilo1.start();

        System.out.println("Terminadas las tareas");
    }
}

class HilosVarios extends Thread{

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int i = 0; i < 15; i++){
            System.out.println("Ejecutando hilo " + getName());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}

class HilosVarios2 extends Thread{

    public HilosVarios2(Thread hilo){
        this.hilo = hilo;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int i = 0; i < 15; i++){

            //Esta tarea no comience hasta que el hilo que le hemos
            //pasado por parámetros al constructor no haya terminado su tarea, no importa el orden en el código
            try {
                hilo.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("Ejecutando hilo " + getName());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    private Thread hilo;
}