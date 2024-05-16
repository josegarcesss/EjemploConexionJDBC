

package ejemploconexionjdbc;

import java.sql.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

//try {
//            //1. CREAR CONEXIÓN
//            Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
//            
//            //2. CREAR OBJETO STATEMENT
//            Statement miStatement=miConexion.createStatement();
//            
//            //3. EJECUTAR LA INSTRUCCION SQL
//            ResultSet miResulset=miStatement.executeQuery("SELECT * FROM herramienta");
//            
//            //4. RECORRER EL RESULSET
//            while(miResulset.next()){
//                System.out.println(miResulset.getString("idHerramienta")+" "+ miResulset.getString("nombre")+" "+ miResulset.getString("descripcion"));
//            }
//            
//        } catch (Exception e) {
//            System.out.println("No se a conectado");
//            e.printStackTrace();
//        }



public class EjemploConexionJDBC {
        //@param args the command line arguments
    public static void main(String[] args) {
        int dni,acceso;
        Scanner sc= new Scanner(System.in);
       
        //ACTIVIDAD 3
        for (int i = 1; i <= 3; i++) {
            try{
            Connection con=Conexion.getConexion();
                
                System.out.println("-------------INSERTAR NUEVO EMPLEADO----------");
                System.out.print("Ingrese DNI: ");
                dni=sc.nextInt();
                System.out.print("Ingrese Apellido: ");
                String apellido=sc.nextLine();
                sc.nextLine();
                System.out.print("Ingrese Nombre: ");
                String nombreE=sc.nextLine();
                System.out.print("Ingrese Grado de acceso: ");
                acceso=sc.nextInt();                
                //2. CREAR OBJETO STATEMENT
                String sql="INSERT INTO empleado ( dni , apellido , nombre , acceso , estado) VALUES ("+dni+" , \'"+apellido+"\' , \'"+nombreE+"\' , "+acceso+" , "+"true)";
                PreparedStatement miStatement=con.prepareStatement(sql);            
                //3. EJECUTAR LA INSTRUCCION SQL
                ResultSet miResulset=miStatement.executeQuery();
                System.out.println("Fue Insertado con Exito!");            
                //4. RECORRER EL RESULSET
                while(miResulset.next()){
                    System.out.println(miResulset.getInt("idHerramienta")+" "+ miResulset.getString("nombre")+" "+ miResulset.getString("descripcion"));
                }
            
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "No se pudo conectar");
            
            }
        }
        
        
       //ACTIVIDAD 4
       for (int i = 1; i <= 2; i++) {
            try{
            Connection con=Conexion.getConexion();
                System.out.println("-------------INSERTAR NUEVA HERRAMIENTA----------");
                System.out.print("Ingrese Nombre: ");
                String nombreH=sc.nextLine();
                sc.nextLine();
                System.out.print("Ingrese una breve descripcion: ");
                String descripcion=sc.nextLine();
                System.out.print("Ingrese cantidad de Stock: ");
                int stock=sc.nextInt();                                
                //2. CREAR OBJETO STATEMENT
                String sql="INSERT INTO herramienta ( nombre , descripcion , stock , estado) VALUES (\'"+nombreH+"\',\'"+descripcion+"\',"+stock+",true)";
                PreparedStatement miStatement=con.prepareStatement(sql);            
//                3. EJECUTAR LA INSTRUCCION SQL
                ResultSet miResulset=miStatement.executeQuery();
                System.out.println("HERRAMIENTA INSERTADA CON EXITO!");            
//                4. RECORRER EL RESULSET
                while(miResulset.next()){
                    System.out.println(miResulset.getInt("idHerramienta")+" "+ miResulset.getString("nombre")+" "+ miResulset.getString("descripcion"));
                }            
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "No se pudo conectar");            
            }
        }        
       
       //ACTIVIDAD 5
       try{
            Connection con=Conexion.getConexion();
            System.out.println("----- Herramientas con Stock superior a 10 -----");
            String sql=("SELECT * FROM herramienta WHERE stock > 10 AND estado = true");
            PreparedStatement miStatement=con.prepareStatement(sql);
            ResultSet miResulset=miStatement.executeQuery();
            System.out.println("Consulta logreada con exito!");
            while(miResulset.next()){
                System.out.println(miResulset.getInt("idHerramienta")+" "+ miResulset.getString("nombre")+" "+ miResulset.getString("descripcion")+" "+ miResulset.getInt("stock")+" "+miResulset.getBoolean("estado"));
            }            
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "No se pudo conectar");
       }       
       
       //ACTIVIDAD 6
       try{
            Connection con=Conexion.getConexion();
            System.out.println("----- Dar de Baja al Empleado id=1 -----");
            String sql=("UPDATE empleado SET estado = 0 WHERE idEmpleado = 1");
            PreparedStatement miStatement=con.prepareStatement(sql);
            miStatement.executeQuery();
            System.out.println("Se ha dado de baja al empleado 1 con exito!");            
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "No se pudo conectar");
       }
    }
}
