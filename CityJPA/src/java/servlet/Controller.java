package servlet;

import entities.Ciudad;
import entities.Punto;
import entities.Ruta;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        String op = request.getParameter("op");
        List<Ciudad> ciudades;
        List<Ciudad> ciudadesConRutas;
        List<Ruta> rutas;
        // Singleton
        EntityManager em = (EntityManager) session.getAttribute("em");
        if (em == null) {
            // Create the EntityManager
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            session.setAttribute("em", em);
        }

        switch (op) {
            case "inicio": {
                ciudades = em.createNamedQuery("Ciudad.findAll").getResultList();
                ciudadesConRutas = new ArrayList<>();
                for (Ciudad ciudad : ciudades) {
                    if (!ciudad.getRutaList().isEmpty()) {
                        ciudadesConRutas.add(ciudad);
                    }
                }
                session.setAttribute("ciudades", ciudades);
                session.setAttribute("ciudadesConRutas", ciudadesConRutas);
                request.getRequestDispatcher("ciudades.jsp").forward(request, response);
                break;
            }
            case "damerutas": {
                int ciudadId = Integer.parseInt(request.getParameter("ciudadId"));
                Query query = em.createNamedQuery("Ciudad.findById");
                query.setParameter("id", ciudadId);
                Ciudad ciudad = (Ciudad) query.getSingleResult();
                for (Ruta ruta : ciudad.getRutaList()) {
                    int suma = 0;
                    for (Punto punto : ruta.getPuntoList()) {
                        suma += punto.getPuntos();
                    }
                    int media = suma / ruta.getPuntoList().size();
                    ruta.setMedia(media);
                }
                session.setAttribute("ciudad", ciudad);
                session.setAttribute("rutas", ciudad.getRutaList());
                request.getRequestDispatcher("rutas.jsp").forward(request, response);
                break;
            }
            case "puntuar": {
                int puntos = Integer.parseInt(request.getParameter("puntos"));
                int rutaId = Integer.parseInt(request.getParameter("ruta"));
                int ciudadId = ((Ciudad) session.getAttribute("ciudad")).getId();
                Punto punto = new Punto();
                punto.setPuntos(puntos);
                Query query = em.createNamedQuery("Ruta.findById");
                query.setParameter("id", rutaId);
                Ruta ruta = (Ruta) query.getSingleResult();
                punto.setRuta(ruta);
                em.persist(punto);
                query = em.createNamedQuery("Ciudad.findById");
                query.setParameter("id", ciudadId);
                Ciudad ciudad = (Ciudad) query.getSingleResult();
                //em.refresh(punto);
                for (Ruta rutaDeCiudad : ciudad.getRutaList()) {
                    int suma = 0;
                    for (Punto puntoDeRuta : ruta.getPuntoList()) {
                        suma += puntoDeRuta.getPuntos();
                    }
                    int media = suma / rutaDeCiudad.getPuntoList().size();
                    ruta.setMedia(media);
                }
                session.setAttribute("rutas", ciudad.getRutaList());
                request.getRequestDispatcher("rutas.jsp").forward(request, response);
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + op);
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
