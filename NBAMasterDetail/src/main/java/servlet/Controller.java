package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Player;
import model.Team;

import java.io.IOException;
import java.util.List;

import dao.NBA;

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
		
		String op = request.getParameter("op");
		switch (op) {
			case "inicio": 
				List<Team> teams = new NBA().getTeams();
				// Entregamos a la vista home estos datos en forma de objeto bajo el nombre key
				// Cuidado con la key!!. En la home habra que utilizarla y llamarla IGUAL IGUAL...
				session.setAttribute("teams", teams);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;
			case "dameplayers": 
				String name = request.getParameter("name");
				List<Player> players = new NBA().getPlayers(name);
				// Entregamos a la vista home estos datos en forma de objeto bajo el nombre key
				// Cuidado con la key!!. En la home habra que utilizarla y llamarla IGUAL IGUAL...
				session.setAttribute("players", players);
				session.setAttribute("name", name);
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
