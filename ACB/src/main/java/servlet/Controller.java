package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import conexion.Conexion;
import daos.DAOEquipo;
import entities.Equipo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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

		// HACER ASI LAS CONEXIONES
		// SINGLETONE, UNA SOLA INSTANCIA
		
		Connection con = null;
		con = (Connection) session.getAttribute("con");
		if (con == null) {
			con = new Conexion().getConnection();
			session.setAttribute("con", con);
		}
		List<Equipo> equipos;
		String op = request.getParameter("op");
		switch (op) {
			case "inicio": 
				// a trabajarrrrr y obtener los datos necesarios para esta opcion
				equipos = new DAOEquipo().getCategorias(con); 
				// Entregamos a la vista home estos datos en forma de objeto bajo el nombre key
				// Cuidado con la key!!. En la home habra que utilizarla y llamarla IGUAL IGUAL...
				session.setAttribute("equipos", equipos);
				request.getRequestDispatcher("home.jsp").forward(request, response);
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