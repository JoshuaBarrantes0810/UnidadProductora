package cr.ac.una.landuna.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection connection;
    
    public Conexion(){
        
    }
    
    public static Connection getConnection(){
        if(connection == null){
            try{
                String url = "jdbc:oracle:thin:@localhost:1521:xe";
                String user = "C##UnidadProductoraUNA";
                String password = "Joshua1234";
                connection = DriverManager.getConnection(url,user,password);
            } catch(SQLException ex){
                System.out.println("Error: "+ex.getMessage());
                return null;
            }
        }
        return connection;
    }
}
