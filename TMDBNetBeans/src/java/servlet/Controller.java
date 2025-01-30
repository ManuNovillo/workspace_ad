package servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Movie;
import model.Person;
import model.Rating;
import util.JPAUtil;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        EntityManager em = null;

        em = (EntityManager) session.getAttribute("em");

        if (em == null) {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            session.setAttribute("em", em);
        }

        String op = request.getParameter("op");
        switch (op) {
            case "actores":
                List<Person> personas = em.createQuery("SELECT p FROM Person p").getResultList();
		for (Person persona :personas) {
			int suma =0;
			for (Rating rating :persona.getRatingList()) {
				suma += rating.getPuntos();
			}
			int tamano = persona.getRatingList().size();
			persona.setMedia(tamano == 0? 0 : suma/tamano);
		}
                session.setAttribute("actores", personas);
                request.getRequestDispatcher("person.jsp").forward(request, response);
                break;
	    case "movies":
                List<Movie> movies = em.createQuery("SELECT m FROM Movie m").getResultList();
                session.setAttribute("movies", movies);
                request.getRequestDispatcher("movie.jsp").forward(request, response);
	    	break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
