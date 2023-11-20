package co.empresa.banco.controller;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import co.empresa.test.dao.UsuarioDao;
import co.empresa.test.modelo.Usuario;

@WebServlet("/usuarios/*")
public class UsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UsuarioDao usuarioDao;

    public UsuarioServlet() {
        super();
    }

    public void init() throws ServletException {
        this.usuarioDao = new UsuarioDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertarUsuario(request, response);
                    break;
       
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
              
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
        dispatcher.forward(request, response);
    }

    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException {
        // Extracting parameters from the request
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String pais = request.getParameter("pais");

        // Creating a new Usuario object with the provided data
        Usuario usuario = new Usuario(nombre, email, pais);

        // Inserting the usuario into the database
        usuarioDao.insert(usuario);

        // Redirecting to the list page
        response.sendRedirect("list");
    }

 

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Extracting the id parameter from the request
        Long id = Long.parseLong(request.getParameter("id"));

        // Retrieving the Usuario object from the database using the id

