
package co.edu.intecap.clinicaveterinaria.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    protected static Connection cnn;
    
    protected static void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.7.200:3306/veterinaria", 
                    "root", 
                    ""
            );
        } catch (Exception e) {
        
            e.printStackTrace(System.err);
        }
    }
    
    protected static void desconectar(){
        try {
            cnn.close();
            
        } catch (Exception e) {
        e.printStackTrace(System.err);
        }
    }
}
