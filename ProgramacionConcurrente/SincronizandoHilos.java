package ProgramacionConcurrente;

public class SincronizandoHilos {
    public static void main(String[] args) {
        HilosVarios hilo1 = new HilosVarios();
        hilo1.start();

        //La función Join() indica que hasta que no muera o se acabe ese hilo, no se ejecute el siguiente
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        HilosVarios hilo2 = new HilosVarios();
        hilo2.start();

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