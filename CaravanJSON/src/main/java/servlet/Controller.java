package servlet;

import java.io.IOException;
import java.util.List;

import dao.Caravan;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Lieux;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Lieux> lugares;

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
		switch (request.getParameter("op")) {
			case "inicio":
				lugares = Caravan.getLugares();
				// Entregamos a la vista home estos datos en forma de objeto bajo el nombre key
				// Cuidado con la key!!. En la home habra que utilizarla y llamarla IGUAL IGUAL...
				session.setAttribute("lugares", lugares);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;
			case "search":
				System.out.println("sadada");
				for (Lieux lugar: lugares) {
					System.out.println("dentro");
					if (lugar.getId().equals(request.getParameter("id"))) {
						session.setAttribute("lugar", lugar);
						request.getRequestDispatcher("lugar.jsp").forward(request, response);
						break;
					}
				}
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
