/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.*/
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Alergeno;
import model.Categoria;
import model.Pedido;
import model.Plato;

import util.JPAUtil;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EntityManager em;

		em = (EntityManager) session.getAttribute("em");

		if (em == null) {
			em = JPAUtil.getEntityManagerFactory().createEntityManager();
			session.setAttribute("em", em);
		}

		List<Plato> platos;

		String op = request.getParameter("op");
		switch (op) {
			case "inicio": {
				List<Alergeno> alergenos = em.createNamedQuery("Alergeno.findAll").getResultList();
				session.setAttribute("alergenos", alergenos);

				List<Categoria> categorias = em.createNamedQuery("Categoria.findAll").getResultList();
				session.setAttribute("categorias", categorias);

				platos = em.createNamedQuery("Plato.findAll").getResultList();
				session.setAttribute("platos", platos);	
				
				session.setAttribute("nombreCategoria", "TODAS");
				session.setAttribute("nombreAlergeno", "TODOS");
				
				List<Plato> platosCarrito = new ArrayList<>();
				session.setAttribute("platosCarrito", platosCarrito);

				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;
			}

			case "filtroCategoria": {
				int categoriaId = Integer.parseInt(request.getParameter("categoria"));
				String nombreCategoria;
				if (categoriaId == 0) {
					platos = em.createNamedQuery("Plato.findAll").getResultList();
					nombreCategoria = "TODAS";
				} else {
					Categoria categoria = em.find(Categoria.class, categoriaId);
					nombreCategoria = categoria.getNombre();
					platos = categoria.getPlatoList();
				}
				
				session.setAttribute("platos", platos);
				session.setAttribute("nombreCategoria", nombreCategoria);
				session.setAttribute("nombreAlergeno", "TODOS");
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;
			}

			case "filtroAlergeno": {
				int alergenoId = Integer.parseInt(request.getParameter("alergeno"));
				String nombreAlergeno;
				if (alergenoId == 0) {
					platos = em.createNamedQuery("Plato.findAll").getResultList();
					nombreAlergeno = "TODOS";
				} else {
					Alergeno alergeno = em.find(Alergeno.class, alergenoId);
					nombreAlergeno = alergeno.getNombre();
					platos = alergeno.getPlatoList();
				}
				
				session.setAttribute("platos", platos);
				session.setAttribute("nombreAlergeno", nombreAlergeno);
				session.setAttribute("nombreCategoria", "TODAS");
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;
			}
			
			case "carrito": {
				int platoId = Integer.parseInt(request.getParameter("plato"));
				Plato plato = em.find(Plato.class, platoId);
				List<Plato> platosCarrito = (List<Plato>) session.getAttribute("platosCarrito");
				platosCarrito.add(plato);
				session.setAttribute("platosCarrito", platosCarrito);
				request.setAttribute("msg", plato.getNombre() + " añadido al pedido");
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;
			}
			
			case "submitCarrito": {
				int mesa = Integer.parseInt(request.getParameter("mesa"));
				System.out.println(mesa);
				List<Plato> platosCarrito = (List<Plato>) session.getAttribute("platosCarrito");
				Pedido pedido = new Pedido(-1);
				pedido.setMesa(mesa);
				pedido.setPlatoList(platosCarrito);
				/*EntityTransaction t = em.getTransaction();
				t.begin();
				em.persist(pedido);
				t.commit();*/
				platosCarrito.clear();
				session.setAttribute("platosCarrito", platosCarrito);
				request.setAttribute("msg", "Pedido de la mesa " + mesa + " anotado");
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;			
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
