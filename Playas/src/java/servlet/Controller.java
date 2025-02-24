/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.*/
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Ccaa;
import model.Municipio;
import model.Playa;
import model.Provincia;
import model.Punto;
import model.Puntuacion;
import model.Usuario;
import util.JPAUtil;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EntityManager em;
		String msg = "";
		em = (EntityManager) session.getAttribute("em");

		if (em == null) {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();
			session.setAttribute("em", em);
		}

		String op = request.getParameter("op");
		switch (op) {
			case "inicio": {
				List<Ccaa> comunidades = em.createNamedQuery("Ccaa.findAll").getResultList();
				session.setAttribute("comunidades", comunidades);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;
			}

			case "comunidadSeleccionada": {
				String comunidadId = request.getParameter("comunidadId");
				Ccaa comunidad = em.find(Ccaa.class, Short.parseShort(comunidadId));
				session.setAttribute("comunidadSeleccionada", comunidad);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;
			}

			case "provinciaSeleccionada": {
				String provinciaId = request.getParameter("provinciaId");
				Provincia provincia = em.find(Provincia.class, Short.parseShort(provinciaId));
				session.setAttribute("provinciaSeleccionada", provincia);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;
			}

			case "municipioSeleccionado": {
				String municipioId = request.getParameter("municipioId");
				System.out.println("DENTRO DE MUNICIPIO");
				Municipio municipio = em.find(Municipio.class, Integer.parseInt(municipioId));
				session.setAttribute("municipioSeleccionado", municipio);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;
			}

			case "logreg": {
				String nick = request.getParameter("nick");
				String pass = request.getParameter("pass");
				List<Usuario> resultado = em.createQuery("SELECT u FROM Usuario u WHERE u.nick = :nick AND u.pass = :pass")
					.setParameter("nick", nick)
					.setParameter("pass", pass)
					.getResultList();
				System.out.println("Nick: " + nick + " Pass: " + pass);
				Usuario usuario;
				System.out.println("RESULTADO: " + resultado.size());
				if (resultado.size() == 1) {
					usuario = resultado.get(0);
				} else {
					usuario = new Usuario((short) -1);
					usuario.setNick(nick);
					usuario.setPass(pass);
					EntityTransaction t = em.getTransaction();
					t.begin();
					em.persist(usuario);
					t.commit();
				}
				session.setAttribute("usuario", usuario);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;
			}

			case "logout": {
				session.removeAttribute("usuario");
				System.out.println("Usuario eliminado");
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;
			}

			case "loadDetail": {
				String idPlaya = request.getParameter("idPlaya");
				Playa playa = em.find(Playa.class, Integer.parseInt(idPlaya));

				session.setAttribute("playa", playa);
				request.getRequestDispatcher("detail.jsp").forward(request, response);
				break;
			}

			case "loadReviews": {
				String idPlaya = request.getParameter("idPlaya");
				String select = "SELECT p.puntos, count(p.puntos) from Punto p where p.playa.id = :idPlaya group by p.puntos";
				List<Object[]> lista = em.createQuery(select)
					.setParameter("idPlaya", Integer.parseInt(idPlaya))
					.getResultList();
				List<Puntuacion> puntuaciones = new ArrayList<>();
				for (Object[] row : lista) {
					Puntuacion puntuacion = new Puntuacion();
					Short puntos = (Short) row[0];
					Long cuantos = (Long) row[1];
					puntuacion.setPuntos(puntos);
					puntuacion.setCuantos(cuantos);
					puntuaciones.add(puntuacion);
				}
				for (Puntuacion p : puntuaciones) {
					System.out.println(p.getCuantos());
					System.out.println(p.getPuntos());
				}
				session.setAttribute("puntuaciones", puntuaciones);
				request.getRequestDispatcher("reviews.jsp").forward(request, response);
				break;
			}

			case "puntuar": {
				short puntos = Short.parseShort(request.getParameter("puntos"));
				Playa playa = (Playa) session.getAttribute("playa");
				if (playa == null) System.out.println("KK");
				Usuario usuario = (Usuario) session.getAttribute("usuario");
				Punto punto = new Punto(-1);
				punto.setPlaya(playa);
				punto.setUsuario(usuario);
				punto.setPuntos(puntos);
				EntityTransaction transaction = em.getTransaction();
				transaction.begin();
				em.persist(punto);
				transaction.commit();
				em.refresh(playa);
				playa.getMedia();
				session.setAttribute("playa", playa);
				request.getRequestDispatcher("detail.jsp").forward(request, response);
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
