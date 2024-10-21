package BBDD_JDBC.AplicacionFinal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AplicacionUniversal {
    public static void main(String[] args) {
        MarcoBBDD miMarco = new MarcoBBDD();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
}

class MarcoBBDD extends JFrame{
    public MarcoBBDD(){
        setBounds(300, 300, 700, 700);
        
        LaminaBBDD miLamina = new LaminaBBDD();
        add(miLamina);
    }
}

class LaminaBBDD extends JPanel{
    public LaminaBBDD(){
        setLayout(new BorderLayout());
        
        comboTablas = new JComboBox();

        areaInformacion = new JTextArea();

        add(areaInformacion, BorderLayout.CENTER);

        conectarBBDD();

        obtenerTablas();

        comboTablas.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
                String nombreTabla = (String) comboTablas.getSelectedItem();

                mostrarInfoTabla(nombreTabla);

            }
            
        });

        add(comboTablas, BorderLayout.NORTH);

    }

    public void conectarBBDD(){
        miConexion = null;

        String datos[] = new String[3];

        try {

            entrada = new FileReader("D:/AMD/Desktop/Curso Java/PildorasInformaticas/GitPildorasInformaticas/BBDD_JDBC/AplicacionFinal/DatosConfig.txt");

        }catch (IOException e) {
            // TODO Auto-generated catch block
            JFileChooser chooser = new JFileChooser();

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
    
            chooser.setFileFilter(filter);
    
            int returnVal = chooser.showOpenDialog(this);
    
            if(returnVal == JFileChooser.APPROVE_OPTION){
                //System.out.println("You choose to open this file: " + chooser.getSelectedFile().getAbsolutePath());

                try {
                    entrada = new FileReader(chooser.getSelectedFile().getAbsolutePath());
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }

        }

        try{

            BufferedReader miBuffer = new BufferedReader(entrada);

            for(int i = 0; i <= 2; i++){
                datos[i] = miBuffer.readLine();
            }

            //MYSQL
            miConexion = DriverManager.getConnection(datos[0], datos[1], datos[2]);

            //ORACLE
            //Primero desde la terminal hay que iniciar el servicio de Oracle "lsnrctl start"
            //miConexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "Contraseña");

            //SQLSERVER
            //miConexion = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-P70AUTP:1433;databaseName=elqsea;trustServerCertificate=true" ,"lemac1nside", "Contraseña");

            //POSTGRESQL
            //miConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Contraseña");

            entrada.close();
        }catch(IOException | SQLException e){
            e.printStackTrace();
        }

    }

    public void obtenerTablas(){
        ResultSet miResultSet = null;

        try {
            DatabaseMetaData datosBBDD = miConexion.getMetaData();

            miResultSet = datosBBDD.getTables(null, null, null, null);
            //miResultSet = datosBBDD.getSchemas(null, null);

            while (miResultSet.next()) {
                comboTablas.addItem(miResultSet.getString("TABLE_NAME"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void mostrarInfoTabla(String tabla){
        ArrayList<String> campos = new ArrayList<String>();

        String consulta = "SELECT * FROM " + tabla;

        try {
            areaInformacion.setText("");

            Statement miStatement = miConexion.createStatement();

            ResultSet miResultSet = miStatement.executeQuery(consulta);

            ResultSetMetaData rsBBDD = miResultSet.getMetaData();

            for(int i = 1; i < rsBBDD.getColumnCount(); i++){
                campos.add(rsBBDD.getColumnLabel(i));
            }

            while (miResultSet.next()) {
                for (String nombreCampo : campos) {
                    areaInformacion.append(miResultSet.getString(nombreCampo) + " | ");
                }
                areaInformacion.append("\n");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private JComboBox comboTablas;
    private JTextArea areaInformacion;
    private Connection miConexion;
    private FileReader entrada;
}