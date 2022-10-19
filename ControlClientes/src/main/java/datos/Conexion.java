
package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USERNAME = "admin";
    private static final String JDBC_PASSWORD = "admin";
    
    //con este metodo se establece la conexion con el servidor y el pool de conexiones para tener varias disponibles
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USERNAME);
        ds.setPassword(JDBC_PASSWORD);
        //definimos  50 gates de acceso disponible
        ds.setInitialSize(50);
        return ds;
    }
    
    
    public static Connection getConnection() throws SQLException{
        //llama al metodo para tene run pool de conexiones
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs){
        try{
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        
    }
    
    public static void close(PreparedStatement stmt) throws SQLException{
       try{ 
        stmt.close(); 
       }catch(SQLException ex){
           ex.printStackTrace(System.out);
       }
       
        
    }
    
    public static void close(Connection conn){
            try{
                conn.close();
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        
    }
    
}
