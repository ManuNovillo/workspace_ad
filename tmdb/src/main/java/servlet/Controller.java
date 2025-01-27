package servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Person;
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
            case "inicio":
                List<Person> personas = em.createQuery("SELECT p FROM Person p").getResultList();
                session.setAttribute("personas", personas);
                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
