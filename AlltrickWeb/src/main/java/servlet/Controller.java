package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import conexion.Conexion;
import daos.DaoBici;
import daos.DaoMarca;
import entities.Bici;
import entities.Marca;
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
		ArrayList<Bici> bicis = null;
		ArrayList<Marca> marcas = null;
		String marca = null;
		String order = null;
		String fav = null;
		
		con = (Connection)session.getAttribute("con");
		if (con== null) {
			con = Conexion.conecta();
			session.setAttribute("con", con);
		}
		
		String op = request.getParameter("op");
		switch (op) {
			case "inicio":
				marca = "%";
				order = null;
				fav = "%";
					
				bicis = new DaoBici().getBicis(con, marca, order, fav);
				marcas = new DaoMarca().getMarcas(con);
				
				session.setAttribute("marca", marca);
				session.setAttribute("order", order);
				session.setAttribute("fav", fav);
				session.setAttribute("bicis", bicis);
				session.setAttribute("marcas", marcas);
				
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;	
			case "vamarca":
				System.out.println("aa");
				marca = request.getParameter("marca");
				order = (String) session.getAttribute("order");
				fav = session.getAttribute("fav").toString();
				System.out.println(marca);
				System.out.println(order);
				System.out.println(fav);
				request.getAttribute(op);
				bicis = new DaoBici().getBicis(con, marca, order, fav);
				for (Bici bici : bicis) {
					System.out.println(bici);
				}
				session.setAttribute("bicis", bicis);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;			
			case "vaorder":
				order = request.getParameter("order");
				session.setAttribute("order", order);
				marca = (String) session.getAttribute("marca");
				fav = (String) session.getAttribute("fav");
				bicis = new DaoBici().getBicis(con, marca, order, fav);
				session.setAttribute("bicis", bicis);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;			
			case "vafav":
				fav = (String) session.getAttribute("fav");
				fav = fav.equals("%") ? "1" : "%";
				session.setAttribute("fav", fav);
				marca = (String) session.getAttribute("marca");
				order = (String) session.getAttribute("order");
				bicis = new DaoBici().getBicis(con, marca, order, fav);
				session.setAttribute("bicis", bicis);
				request.getRequestDispatcher("home.jsp").forward(request, response);
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
