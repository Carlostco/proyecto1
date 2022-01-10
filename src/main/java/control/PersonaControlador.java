package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOPersona;
import DAO.DAOUsuario;
import modelo.Persona;
import modelo.Usuario;

/**
 * Servlet implementation class PersonaControlador
 */
@WebServlet("/PersonaCtrl")
public class PersonaControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String user= request.getParameter("txtusuario");
		String pass= request.getParameter("txtclave");
		System.out.println("Usuario: " + user);
		DAOPersona p = new DAOPersona();
		DAOUsuario u = new DAOUsuario();
		Usuario us=null;
		try {
			us = u.obtenerUsuario(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Persona per=null;
		try {
			per = p.obtenerPersona(us.getRut());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("persona",per);
		RequestDispatcher reqDisp= request.getRequestDispatcher("views/mostrar.jsp");
		reqDisp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
	}

}
