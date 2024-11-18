package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import conexion.Conexion;
import daos.DaoEquipo;
import daos.DaoJugador;
import entities.Equipo;
import entities.Jugador;
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
		Connection con = null;
		ArrayList<Equipo> equipos = null;
		ArrayList<Jugador> jugadores = null;
		Equipo equipo;
		
		con = (Connection)session.getAttribute("con");
		if (con== null) {
			con = Conexion.conecta();
			session.setAttribute("con", con);
		}
		
		String op = request.getParameter("op");
		switch (op) {
			case "inicio": 
				equipos = new DaoEquipo().getEquipos(con);
				session.setAttribute("equipos", equipos);
				
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;		
			case "vaequipo":
				int equipoId = Integer.parseInt(request.getParameter("idequipo"));
				jugadores = new DaoJugador().getJugadoresByEquipo(con, equipoId);
				equipo = new DaoEquipo().getEquipo(equipoId, con);
				session.setAttribute("jugadores", jugadores);
				session.setAttribute("equipo", equipo);
				request.getRequestDispatcher("jugadores.jsp").forward(request, response);
				break;	
			case "dalike":
				int jugadorId = Integer.parseInt(request.getParameter("jugadorid"));
				equipo = (Equipo) session.getAttribute("equipo");
				new DaoJugador().darLike(jugadorId, con);
				jugadores = new DaoJugador().getJugadoresByEquipo(con, equipo.getId());
				session.setAttribute("jugadores", jugadores);
				request.getRequestDispatcher("jugadores.jsp").forward(request, response);
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
