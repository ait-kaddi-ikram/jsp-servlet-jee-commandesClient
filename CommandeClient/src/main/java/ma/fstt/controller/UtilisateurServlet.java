package ma.fstt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.fstt.dao.ProduitDao;
import ma.fstt.dao.UtilisateurDAO;
import ma.fstt.model.Utilisateur;

/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet("/UtilisateurServlet")
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UtilisateurDAO util;
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurServlet() throws ClassNotFoundException, SQLException {
        super();
        util= new  UtilisateurDAO(); 
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		
		String action = request.getParameter("action");
		try {
		if(action.equals("save") ) {
			String nomUtil = request.getParameter("nomUtil"); 
			String passwordUtil = request.getParameter("passwordUtil");
			String adresseUtil = request.getParameter("adresseUtil");
			String emailUtil = request.getParameter("emailUtil");
			
			Utilisateur utilisateur = new Utilisateur(0,nomUtil,passwordUtil, adresseUtil, emailUtil, 1);
			
				util.save(utilisateur);
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}else if(action.equals("auth")) {
			String emailUtil = request.getParameter("emailUtil");
			String passwordUtil = request.getParameter("passwordUtil");
			Utilisateur utilisateur =  util.getByEmail(emailUtil);
			if(utilisateur.getPasswordUtil().equals(passwordUtil)) {
			session.setAttribute("user", utilisateur);
			this.getServletContext().getRequestDispatcher("/ProduitsServlet?act=2").forward(request, response);
			}else {
				this.getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
			}
		}else if (action.equals("logout")) {
			session.removeAttribute("user");
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
