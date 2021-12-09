package ma.fstt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.fstt.dao.ProduitDao;
import ma.fstt.dao.UtilisateurDAO;
import ma.fstt.model.Produit;
import ma.fstt.model.Utilisateur;

/**
 * Servlet implementation class ProduitsServlet
 */
@WebServlet("/ProduitsServlet")
public class ProduitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Inject private ProduitDao produitDao;
    public ProduitsServlet() throws ClassNotFoundException, SQLException {
        super();
        produitDao = new ProduitDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//String action = request.getParameter("act");//(String) session.getAttribute("page");
		int action  = Integer.parseInt(request.getParameter("act"));
	
		try {
		List<Produit> listProd = new ArrayList<Produit>();
		 if(action == 2)
		{
		
				listProd = produitDao.List();
			
			request.setAttribute("listProd", listProd);
		
			this.getServletContext().getRequestDispatcher("/produits.jsp").forward(request, response);
		}if(action == 33) {
			int id  = Integer.parseInt(request.getParameter("id"));
			produitDao.delete(id);
			System.out.println("in delet prod");
			 this.getServletContext().getRequestDispatcher("/ProduitsServlet?act=2").forward(request, response);
		}if(action == 22) {
			int id  = Integer.parseInt(request.getParameter("id"));
			Produit prodToUpdate = produitDao.getById(id);
			session.setAttribute("prodToUpdate", prodToUpdate);
			
			this.getServletContext().getRequestDispatcher("/updateProduit.jsp").forward(request, response);
			
		}if(action == 44) {
			
			String nomProd = request.getParameter("nomProd");
			double prixProd = Double.parseDouble(request.getParameter("prixProd"));
			Produit produit = new Produit(0, nomProd, prixProd);
			
			produitDao.save(produit);
			this.getServletContext().getRequestDispatcher("/ProduitsServlet?act=2").forward(request, response);
		} if(action == 55)
		{
			int id  = Integer.parseInt(request.getParameter("id"));
			String nomProd = request.getParameter("nomProd");
			double prixProd = Double.parseDouble(request.getParameter("prixProd"));
			Produit produit = new Produit(id, nomProd, prixProd);
			
			produitDao.update(produit);
			this.getServletContext().getRequestDispatcher("/ProduitsServlet?act=2").forward(request, response);
		}
       
		
		} catch (SQLException e) {
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
