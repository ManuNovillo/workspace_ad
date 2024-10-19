package servlet;

import java.io.IOException;
import java.util.List;

import dao.DAOProducto;
import dao.DAOPunto;
import dao.DaoCategoria;
import entities.Categoria;
import entities.Producto;
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
		
		String op = request.getParameter("op");
		switch (op) {
			case "inicio": 
				// a trabajarrrrr y obtener los datos necesarios para esta opcion
				List<Categoria> categorias = DaoCategoria.getCategorias(); 
				// Entregamos a la vista home estos datos en forma de objeto bajo el nombre key
				// Cuidado con la key!!. En la home habra que utilizarla y llamarla IGUAL IGUAL...
				session.setAttribute("categorias", categorias);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				break;		
			case "productos":
				List<Producto> productos = DAOProducto.getProductos(Integer.parseInt(request.getParameter("categoriaid")));
				session.setAttribute("productos", productos);
				request.getRequestDispatcher("productos.jsp").forward(request, response);
				break;
			case "detail":
				String body = request.getParameter("body");
				String name = request.getParameter("name");
				String fondo = request.getParameter("fondo");
				String imagen = request.getParameter("imagen");
				int media = DAOPunto.getMedia(Integer.parseInt(request.getParameter("id")));
				session.setAttribute("body", body);
				session.setAttribute("name", name);
				session.setAttribute("fondo", fondo);
				session.setAttribute("imagen", imagen);
				session.setAttribute("media", media);
				request.getRequestDispatcher("detail.jsp").forward(request, response);
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