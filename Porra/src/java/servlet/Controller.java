package servlet;
// find persist merge remove
import entities.Jornada;
import entities.Usuario;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import util.JPAUtil;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String op = request.getParameter("op");
		String msg;
		Usuario usuario;
		// Singleton
		EntityManager em = (EntityManager) session.getAttribute("em");
		if (em==null) {
                    // Create the EntityManager
                        em = JPAUtil.getEntityManagerFactory().createEntityManager();
			session.setAttribute("em", em);
		}
		List<Jornada> jornadas;	
		switch (op) {
		case "inicio": {
			jornadas = em.createNamedQuery("Jornada.findAll").getResultList();
			session.setAttribute("jornadas", jornadas);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			break;
		}
		case "vajornada": {
			int jornadaid = Integer.parseInt(request.getParameter("jornada"));
			Jornada jornada = em.find(Jornada.class, jornadaid);
			session.setAttribute("partidos", jornada.getPartidoList());
			request.getRequestDispatcher("partidos.jsp").forward(request, response);
		}
		case "login": {
			String dni = request.getParameter("dni");

			usuario = em.find(Usuario.class, dni);
			if (usuario == null) {
				msg = "DNI NO REGISTRADO";
			} else {
				session.setAttribute("usuario", usuario);
			}
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		case "signin": {
			String dni = request.getParameter("dni");
			String nombre = request.getParameter("nombre");

			usuario = em.find(Usuario.class, dni);
			if (usuario == null) {
			    usuario = new Usuario();
			    usuario.setDni(dni);
			    usuario.setNombre(nombre);
			    EntityTransaction t = em.getTransaction();
			    t.begin();
			    em.persist(usuario);
			    t.commit();
			} else {
				msg = "DNI YA EN LA BBDD";
			}
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}