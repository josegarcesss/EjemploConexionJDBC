/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploconexionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    //url="jdbc:mariadb://localhost/(nombre_BD)
    //url="jdbc:mysql://localhost/(nombre_BD)
    private static String url="jdbc:mariadb://localhost/tpo10";
    private static String usuario="root";
    private static String password="";
    
    private static Conexion conexion=null;
    
    private Conexion(){
        try{
            //Cargar Driver
            Class.forName("org.mariadb.jdbc.Driver");
        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Clase Conexion: Error al cargar el Driver");
       
        }
    }
        
        public static Connection getConexion(){
            Connection con=null;
            if(conexion == null){
                conexion= new Conexion();
            }
            try{
                //Setup the connection with the DB
                con= DriverManager.getConnection(url+"?useLegacyDatatimeCode=false&serverTimezone=UTC"+"&user="+usuario+"&password="+password);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error de conexion");
                }
            return con;
        }
    
}

    
    
    
    
    
    
    
    
    
    

