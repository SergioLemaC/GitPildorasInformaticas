package Sockets;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Servidor {
    public static void main(String[] args) {
        MarcoServidor miMarco = new MarcoServidor();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoServidor extends JFrame implements Runnable {
    public MarcoServidor() {
        setBounds(1200, 300, 280, 350);

        JPanel miLamina = new JPanel();
        miLamina.setLayout(new BorderLayout());

        areaTexto = new JTextArea();

        miLamina.add(areaTexto, BorderLayout.CENTER);
        add(miLamina);

        setVisible(true);

        Thread miHilo = new Thread(this);
        miHilo.start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        try {
            ServerSocket servidor = new ServerSocket(9999);

            String nick, ip, mensaje;

            ArrayList<String> listaIp = new ArrayList<String>();

            PaqueteEnvio paqueteRecibido;

            while (true) {

                Socket miSocket = servidor.accept();

                // Detecta usuarios online-------------------------------------------
                // InetAddress localizacion = miSocket.getInetAddress();
                // String ipRemota = localizacion.getHostAddress();
                // ------------------------------------------------------------------

                ObjectInputStream paqueteDatos = new ObjectInputStream(miSocket.getInputStream());

                paqueteRecibido = (PaqueteEnvio) paqueteDatos.readObject();

                nick = paqueteRecibido.getNick();
                ip = paqueteRecibido.getIp();
                mensaje = paqueteRecibido.getMensaje();
                // DataInputStream flujoEntrada = new
                // DataInputStream(miSocket.getInputStream());

                // String mensajeTexto = flujoEntrada.readUTF();

                // areaTexto.append("\n" + mensajeTexto);

                if (!mensaje.equals("Online")) {

                    areaTexto.append("\n" + nick + ": -" + mensaje + "- para: " + ip);

                    // Detecta usuarios online-------------------------------------------
                    Socket enviaDestinatario = new Socket(ip, 9090);

                    ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                    paqueteReenvio.writeObject(paqueteRecibido);
                    paqueteReenvio.close();

                    enviaDestinatario.close();

                    miSocket.close();
                } else {
                    InetAddress localizacion = miSocket.getInetAddress();
                    String ipRemota = localizacion.getHostAddress();
                    listaIp.add(ipRemota);

                    paqueteRecibido.setIps(listaIp);

                    for (String z : listaIp) {
                        System.out.println("- " + z);

                        Socket enviaDestinatario = new Socket(z, 9090);

                        ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                        paqueteReenvio.writeObject(paqueteRecibido);
                        paqueteReenvio.close();

                        enviaDestinatario.close();

                        miSocket.close();
                    }
                }
                // servidor.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private JTextArea areaTexto;
}