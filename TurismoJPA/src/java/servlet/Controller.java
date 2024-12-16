package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import entities.Categoria;
import entities.Lugar;
import entities.Provincia;
import java.util.List;
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
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        EntityManager em = null;
        List<Provincia> provincias = null;
        List<Categoria> categorias = null;
        List<Lugar> lugares = null;
        String idprovincia;
        String idcategoria;
        String idlugar;
        String fav;
        String provincia;
        String categoria;
        String nombreLugar;
        String msg;

        em = (EntityManager) session.getAttribute("em");

        if (em == null) {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            session.setAttribute("em", em);
        }

        String op = request.getParameter("op");
        switch (op) {
            case "inicio":
                idprovincia = "%";
                idcategoria = "%";
                fav = "%";
                provincia = "CLM";
                categoria = "Todas las categorías";
                session.setAttribute("idprovincia", idprovincia);
                session.setAttribute("provincia", provincia);
                session.setAttribute("idcategoria", idcategoria);
                session.setAttribute("categoria", categoria);
                session.setAttribute("fav", fav);

                provincias = em.createQuery("SELECT p FROM Provincia p").getResultList();
                categorias = em.createQuery("SELECT c FROM Categoria c").getResultList();
                lugares = em.createQuery("SELECT l FROM Lugar l").getResultList();

                session.setAttribute("provincias", provincias);
                session.setAttribute("categorias", categorias);
                session.setAttribute("lugares", lugares);

                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
            case "opprovincia":
                idprovincia = request.getParameter("idprovincia");
                provincia = request.getParameter("provincia");
                idcategoria = (String) session.getAttribute("idcategoria");
                categoria = (String) session.getAttribute("categoria");
                fav = (String) session.getAttribute("fav");
                lugares = em.createQuery(
                        "SELECT l "
                        + "FROM Lugar l "
                        + "WHERE l.fav LIKE '" + fav + "' AND "
                        + "l.provincia.id LIKE '" + idprovincia + "' AND "
                        + "l.categoria.id like '" + idcategoria + "' "
                ).getResultList();
                session.setAttribute("idprovincia", idprovincia);
                session.setAttribute("provincia", provincia);
                session.setAttribute("lugares", lugares);

                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
            case "opcategoria":
                idcategoria = request.getParameter("idcategoria");
                categoria = request.getParameter("categoria");
                idprovincia = (String) session.getAttribute("idprovincia");
                provincia = (String) session.getAttribute("provincia");
                fav = (String) session.getAttribute("fav");
                lugares = em.createQuery(
                        "SELECT l "
                        + "FROM Lugar l "
                        + "WHERE l.fav LIKE '" + fav + "' AND "
                        + "l.provincia.id LIKE '" + idprovincia + "' AND "
                        + "l.categoria.id like '" + idcategoria + "' "
                ).getResultList();

                session.setAttribute("idcategoria", idcategoria);
                session.setAttribute("categoria", categoria);
                session.setAttribute("lugares", lugares);

                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
            case "opfav":
                fav = (String) session.getAttribute("fav");
                if (fav.equals("%")) {
                    fav = "1";
                } else {
                    fav = "%";
                }

                idprovincia = (String) session.getAttribute("idprovincia");
                provincia = (String) session.getAttribute("provincia");
                idcategoria = (String) session.getAttribute("idcategoria");
                categoria = (String) session.getAttribute("categoria");
                lugares = em.createQuery(
                        "SELECT l " + 
                        "FROM Lugar l " + 
                        "WHERE l.fav LIKE '" + fav+  "' AND " +
                        "l.provincia.id LIKE '" + idprovincia + "' AND " +
                        "l.categoria.id like '" + idcategoria +  "' "
                ).getResultList();

                session.setAttribute("fav", fav);
                session.setAttribute("lugares", lugares);

                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
            case "changefav":
                idlugar = request.getParameter("idlugar");
                nombreLugar = request.getParameter("lugar");
                String favLugar = request.getParameter("fav");
                if (favLugar.equals("0")) {
                    favLugar = "1";
                    msg = "Fav " + nombreLugar + " ON";
                } else {
                    favLugar = "0";
                    msg = "Fav " + nombreLugar + " OFF";
                }
                Lugar lugar = em.find(Lugar.class, Integer.parseInt(idlugar));
                lugar.setFav(Integer.parseInt(favLugar));
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.merge(lugar);
                transaction.commit();
                em.refresh(lugar);
                idprovincia = (String) session.getAttribute("idprovincia");
                provincia = (String) session.getAttribute("provincia");
                idcategoria = (String) session.getAttribute("idcategoria");
                categoria = (String) session.getAttribute("categoria");
                fav = (String) session.getAttribute("fav");
                request.setAttribute("msg", msg);

                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
