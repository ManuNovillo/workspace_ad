package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import conexion.Conexion;
import daos.DaoCategoria;
import daos.DaoLugar;
import daos.DaoProvincia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Categoria;
import model.Lugar;
import model.Provincia;

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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Connection con = (Connection) session.getAttribute("con");
		if (con == null) {
			con = Conexion.conecta();
			session.setAttribute("con", con);
		}

		List<Provincia> provincias = null;
		List<Categoria> categorias = null;
		List<Lugar> lugares = null;
		
		String categoria = null;
		String provincia = null;
		String fav = null;
		
		String op = request.getParameter("op");
		switch(op) {
			case "inicio" -> {
				categoria = "%";
				provincia = "%";
				fav = "%";
				
				session.setAttribute("categoria", categoria);
				session.setAttribute("provincia", provincia);
				session.setAttribute("fav", fav);
				
				provincias = new DaoProvincia().getAllProvincias(con);
				categorias = new DaoCategoria().getAllCategorias(con);
				lugares = new DaoLugar().getAllLugares(categoria, provincia, fav, con);
				
				session.setAttribute("nombreCategoria", null);
				session.setAttribute("nombreProvincia", null);
				session.setAttribute("provincias", provincias);
				session.setAttribute("categorias", categorias);
				session.setAttribute("lugares", lugares);
				
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			case "provincia" -> {
				provincia = request.getParameter("provinciaid");
				
				categoria = (String) session.getAttribute("categoria");
				fav = (String) session.getAttribute("fav");
				
				session.setAttribute("provincia", provincia);
				
				lugares = new DaoLugar().getAllLugares(categoria, provincia, fav, con);
				provincias = (List<Provincia>) session.getAttribute("provincias");
				String nombreProvincia = null;
				for (Provincia p : provincias) {
					if (String.valueOf(p.getId()).equals(provincia)) {
						nombreProvincia = p.getNombre();
						break;
					}
				}
				session.setAttribute("lugares", lugares);
				session.setAttribute("nombreProvincia", nombreProvincia);
				
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			case "categoria" -> {
				categoria = request.getParameter("categoriaid");
				
				provincia = (String) session.getAttribute("provincia");
				fav = (String) session.getAttribute("fav");
				
				session.setAttribute("categoria", categoria);
				
				lugares = new DaoLugar().getAllLugares(categoria, provincia, fav, con);
				
				categorias = (List<Categoria>) session.getAttribute("categorias");
				String nombreCategoria = null;
				for (Categoria c : categorias) {
					if (String.valueOf(c.getId()).equals(categoria)) {
						nombreCategoria = c.getNombre();
						break;
					}
				}
				session.setAttribute("nombreCategoria", nombreCategoria);
				
				session.setAttribute("lugares", lugares);
				
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			
			case "fav" -> {
				provincia = (String) session.getAttribute("provincia");
				categoria = (String) session.getAttribute("categoria");
				fav = (String) session.getAttribute("fav");
				fav = fav.equals("1") ? "%" : "1";
				session.setAttribute("fav", fav);
				
				lugares = new DaoLugar().getAllLugares(categoria, provincia, fav, con);
				
				session.setAttribute("lugares", lugares);
				
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			
			case "lugarfav" -> {
				int lugarId = Integer.parseInt(request.getParameter("lugarid"));
				lugares = (List<Lugar>) session.getAttribute("lugares");
				String nombreLugar = null;
				for (Lugar l : lugares) {
					if (l.getId() == lugarId) {
						nombreLugar = l.getNombre();
						break;
					}
				}
				
				
				int currfav = Integer.parseInt(request.getParameter("currfav"));
				int nuevoFav = currfav == 1 ? 0 : 1;
				
				request.setAttribute("lugarActualizado", nombreLugar);
				request.setAttribute("estadoLugarActualizado", nuevoFav == 1 ? "ON" : "OFF");
				
				new DaoLugar().cambiarFav(lugarId, nuevoFav, con);
				
				provincia = (String) session.getAttribute("provincia");
				categoria = (String) session.getAttribute("categoria");
				fav = (String) session.getAttribute("fav");
				
				lugares = new DaoLugar().getAllLugares(categoria, provincia, fav, con);

				session.setAttribute("lugares", lugares);
				
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
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
