package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDaoJDBC {

    private static final String SQL_SELECT = "CALL select_cliente";
    private static final String SQL_SELECT_BY_ID = "CALL get_cliente(?)";
    private static final String SQL_INSERT = "CALL insert_cliente(?,?,?,?,?)";
    private static final String SQL_UPDATE = "CALL update_cliente(?,?,?,?,?,?)";
    private static final String SQL_DELETE = "CALL delete_cliente(?)";

    public List<Cliente> listar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                String nombreCliente = rs.getString("nombre");
                String apellidoCliente = rs.getString("apellido");
                String emailCliente = rs.getString("email");
                String telefonoCLiente = rs.getString("telefono");
                double saldoCLiente = rs.getDouble("saldo");

                cliente = new Cliente(idCliente, nombreCliente, apellidoCliente, emailCliente, telefonoCLiente, saldoCLiente);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return clientes;
    }

    public Cliente encontrar(Cliente cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            rs.absolute(1); // seleccionamos el primer registro
            // est evalor ya lo tenemos int idCliente = rs.getInt("id_cliente");
            String nombreCliente = rs.getString("nombre");
            String apellidoCliente = rs.getString("apellido");
            String emailCliente = rs.getString("email");
            String telefonoCLiente = rs.getString("telefono");
            double saldoCLiente = rs.getDouble("saldo");

            cliente.setNombre(nombreCliente);
            cliente.setApellido(apellidoCliente);
            cliente.setEmail(emailCliente);
            cliente.setTelefono(telefonoCLiente);
            cliente.setSaldo(saldoCLiente);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }
    
    public int insertar(Cliente cliente) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int actualizar(Cliente cliente) throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, cliente.getIdCliente());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getApellido());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getTelefono());
            stmt.setDouble(6, cliente.getSaldo());
            
            rows = stmt.executeUpdate();
            
            
        }catch(SQLException ex){
            
            ex.printStackTrace(System.out);
            
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
            
        }
        return rows;
        
    }
    
    public int eliminar(Cliente cliente) throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdCliente());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
