
package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            List<Cliente> clientes = new ClienteDaoJDBC().listar();
            for(Cliente cliente: clientes){
            System.out.println("clientes: " + cliente.toString() );
            }
            request.setAttribute("clientes", clientes);
            request.setAttribute("mensaje", "hola mundo");
            request.getRequestDispatcher("clientes.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    } 
}
