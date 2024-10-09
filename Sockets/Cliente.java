package Sockets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cliente {
    public static void main(String[] args) {
        MarcoCliente miMarco = new MarcoCliente();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoCliente extends JFrame{
    public MarcoCliente(){
        setBounds(600, 300, 280, 350);

        LaminaMarcoCliente miLamina = new LaminaMarcoCliente();
        add(miLamina);

        setVisible(true);

        addWindowListener(new EnvioOnline());
    }
}

//Envía señal de que está online
class EnvioOnline extends WindowAdapter{
    @Override
    public void windowOpened(WindowEvent e){
        try {
            Socket miSocket = new Socket("192.168.1.61", 9999);

            PaqueteEnvio datos = new PaqueteEnvio();
            datos.setMensaje("Online");

            ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
            paqueteDatos.writeObject(datos);
            miSocket.close();
        } catch (UnknownHostException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

class LaminaMarcoCliente extends JPanel implements Runnable{
    public LaminaMarcoCliente(){
        String nickUsuario = JOptionPane.showInputDialog("Nick: ");

        JLabel nNick = new JLabel("Nick: ");
        add(nNick);

        nick = new JLabel();
        nick.setText(nickUsuario);
        add(nick);

        JLabel texto = new JLabel("Online: ");
        add(texto);

        ip = new JComboBox();
        add(ip);

        campoChat = new JTextArea(12, 20);
        add(campoChat);

        campo1 = new JTextField(20);
        add(campo1);

        miBoton = new JButton("Enviar");

        EnviaTexto miEvento = new EnviaTexto();
        miBoton.addActionListener(miEvento);

        add(miBoton);

        Thread miHilo = new Thread(this);
        miHilo.start();
    }

    private class EnviaTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
            campoChat.append("\n" + campo1.getText());

            try {
                Socket miSocket = new Socket("192.168.1.61", 9999);

                PaqueteEnvio datos = new PaqueteEnvio();
                datos.setNick(nick.getText());
                datos.setIp(ip.getSelectedItem().toString());
                datos.setMensaje(campo1.getText());

                ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
                paqueteDatos.writeObject(datos);
                //DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());
                //flujoSalida.writeUTF(campo1.getText());
                //flujoSalida.close();
                miSocket.close();
            } catch (UnknownHostException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                System.out.println(e1.getMessage());
            }

        }
        
    }

    private JTextField campo1;
    private JComboBox ip;
    private JLabel nick;
    private JTextArea campoChat;
    private JButton miBoton;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
        try {
            ServerSocket servidorCliente = new ServerSocket(9090);

            Socket cliente;

            PaqueteEnvio paqueteRecibido;

            while (true) {
                cliente = servidorCliente.accept();

                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());

                paqueteRecibido = (PaqueteEnvio) flujoEntrada.readObject();

                if(!paqueteRecibido.getMensaje().equals("Online")){
                    campoChat.append("\n" + paqueteRecibido.getNick() + ": -" + paqueteRecibido.getMensaje() + "- ");
                }else{
                    //campoChat.append("\n" + paqueteRecibido.getIps());

                    ArrayList<String> IpsMenu = new ArrayList<String>();
                    IpsMenu = paqueteRecibido.getIps();

                    ip.removeAllItems();

                    for (String z : IpsMenu) {
                        ip.addItem(z);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

class PaqueteEnvio implements Serializable{
    
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArrayList<String> getIps() {
        return Ips;
    }

    public void setIps(ArrayList<String> ips) {
        Ips = ips;
    }

    private String nick, ip, mensaje;
    private ArrayList<String> Ips;
}