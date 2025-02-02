package servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Movie;
import model.Person;
import model.Usuario;
import util.JPAUtil;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        EntityManager em;

        em = (EntityManager) session.getAttribute("em");

        if (em == null) {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            session.setAttribute("em", em);
        }

        Usuario usuario;
        String dni;
        String nombre;
        String paginaActual;
        String mensaje;
        String op = request.getParameter("op");
        switch (op) {
            case "actores":
                List<Person> personas = em.createQuery("SELECT p FROM Person p").getResultList();
                for (Person persona : personas) {
                    persona.setMedia();
                }
                session.setAttribute("actores", personas);
                request.getRequestDispatcher("person.jsp").forward(request, response);
                break;
            case "movies":
                List<Movie> movies = em.createQuery("SELECT m FROM Movie m").getResultList();
                session.setAttribute("movies", movies);
                request.getRequestDispatcher("movie.jsp").forward(request, response);
                break;
            case "login":
                dni = request.getParameter("dni");
                nombre = request.getParameter("nombre");
                paginaActual = request.getParameter("pagina");
                usuario = em.find(Usuario.class, dni);
                if (usuario == null) {
                    mensaje = "Datos incorrectos";
                    session.setAttribute("mensaje", mensaje);
                }
                session.setAttribute("usuario", usuario);
                request.getRequestDispatcher(paginaActual + ".jsp").forward(request, response);
                break;
            case "register":
                dni = request.getParameter("dni");
                nombre = request.getParameter("nombre");
                paginaActual = request.getParameter("pagina");
                usuario = em.find(Usuario.class, dni);
                if (usuario == null) {
                    usuario = new Usuario();
                    usuario.setDni(dni);
                    usuario.setNombre(nombre);
                    EntityTransaction transaction = em.getTransaction();
                    transaction.begin();
                    em.persist(usuario);
                    transaction.commit();
                    session.setAttribute("usuario", usuario);
                } else {
                    mensaje = "Este dni ya existe";
                    session.setAttribute("mensaje", mensaje);
                }
                request.getRequestDispatcher(paginaActual + ".jsp").forward(request, response);
                break;
            case "logout":
                paginaActual = request.getParameter("pagina");
                session.removeAttribute("usuario");
                request.getRequestDispatcher(paginaActual + ".jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
