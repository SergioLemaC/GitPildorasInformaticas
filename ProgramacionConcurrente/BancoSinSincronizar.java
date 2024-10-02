package ProgramacionConcurrente;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSinSincronizar {
    public static void main(String[] args) {
        Banco b = new Banco();

        for (int i = 0; i < 100; i++) {
            EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);

            Thread t = new Thread(r);

            t.start();
        }
    }
}

class Banco {

    public Banco() {
        cuentas = new double[100];

        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;
        }
        //El bloqueo cierreBanco tiene que establecerse en base a una condición
        saldoSuficiente = cierreBanco.newCondition();
    }

    //El hilo entra en la función
    public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
        //Bloquea para que no entre un hilo más
        cierreBanco.lock();

        try {
            //Mientras se cumpla esta condición, el hilo permanece a la espera, esto con la función await()
            while (cuentas[cuentaOrigen] < cantidad) { // Evalúa que el saldo no sea inferior a la transferencia
                System.out.println("-----------------CANTIDAD INSUFICIENTE: " + cuentaOrigen + " Saldo: $" + cuentas[cuentaOrigen] + "...." + cantidad);
                //return;
                //Además de ponerse a la espera, se libera el bloqueo y que entre el siguiente hilo
                saldoSuficiente.await();
            }/*else{
                System.out.println("-------------CANTIDAD OK-------------" + cuentaOrigen);
            }*/

            System.out.println(Thread.currentThread());

            cuentas[cuentaOrigen] -= cantidad; // Dinero que sale de la cuenta origen

            System.out.printf("%10.2f de %d para %d ", cantidad, cuentaOrigen, cuentaDestino);

            cuentas[cuentaDestino] += cantidad;

            System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());

            //Despierta a todos los hilos que estaban a la espera para informar de esa operación
            saldoSuficiente.signalAll();
        } finally {
            cierreBanco.unlock();
        }
    }

    public double getSaldoTotal() {
        double sumaCuentas = 0;

        for (double a : cuentas) {
            sumaCuentas += a;
        }

        return sumaCuentas;
    }

    private final double[] cuentas;
    private Lock cierreBanco = new ReentrantLock();
    private Condition saldoSuficiente;
}

class EjecucionTransferencias implements Runnable {

    public EjecucionTransferencias(Banco b, int de, double max) {
        banco = b;
        deLaCuenta = de;
        cantidadMax = max;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            while (true) {
                int paraLaCuenta = (int) (100 * Math.random());

                double cantidad = cantidadMax * Math.random();

                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);

                // try {
                Thread.sleep((int) (Math.random() * 10));
                /*
                 * } catch (InterruptedException e) {
                 * // TODO Auto-generated catch block
                 * e.printStackTrace();
                 * }
                 */
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Banco banco;
    private int deLaCuenta;
    private double cantidadMax;
}