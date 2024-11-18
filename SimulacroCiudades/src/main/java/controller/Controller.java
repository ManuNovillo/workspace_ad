package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import conexion.Conexion;
import daos.DAOCiudad;
import daos.DAOPunto;
import daos.DAORuta;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Ciudad;
import model.Ruta;


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
		Connection con = null;
		
		con = (Connection) session.getAttribute("con");
		if (con== null) {
			con = Conexion.conecta();
			session.setAttribute("con", con);
		}
		
		List<Ciudad> ciudadesConRutas;
		List<Ciudad> ciudades;
		List<Ruta> rutas;
		String op = request.getParameter("op");
		switch (op) {
		case "inicio":
			DAOCiudad daoCiudad = new DAOCiudad();
			ciudadesConRutas = daoCiudad.getCiudadesConRutas(con);
			ciudades = daoCiudad.getCiudades(con);
			session.setAttribute("ciudadesConRutas", ciudadesConRutas);
			session.setAttribute("ciudades", ciudades);
			request.getRequestDispatcher("ciudades.jsp").forward(request, response);
			break;
		case "damerutas":
			int ciudadId = Integer.parseInt(request.getParameter("ciudadId"));
			rutas = new DAORuta().getRutasByCiudad(con, ciudadId);
			rutas.forEach(ruta -> {
				System.out.println(ruta);
			});
			if (rutas.isEmpty()) {
				System.out.println("vacio");
			}
			session.setAttribute("ciudadId", ciudadId);
			session.setAttribute("rutas", rutas);
			request.getRequestDispatcher("rutas.jsp").forward(request, response);
			break;
		case "puntuar":
			int puntos = Integer.parseInt(request.getParameter("puntos"));
			int rutaId = Integer.parseInt(request.getParameter("ruta"));
			new DAOPunto().addPuntos(puntos, rutaId, con);
			int ciudad = (int) session.getAttribute("ciudadId");
			request.getRequestDispatcher("Controller?op=damerutas&ciudadId=" + ciudad).forward(request, response);
			break;
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
