package ma.fstt.controller;

import java.io.IOException;
import java.sql.Date;
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


import ma.fstt.dao.CommandeDao;
import ma.fstt.dao.LigneDeCommandeDao;

import ma.fstt.dao.ProduitDao;
import ma.fstt.model.Commande;
import ma.fstt.model.LigneDeCommande;
import ma.fstt.model.Produit;
import ma.fstt.model.Utilisateur;

/**
 * Servlet implementation class CommandesServlet
 */
@WebServlet("/CommandesServlet")
public class CommandesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Inject private CommandeDao commandeDao;
	@Inject private LigneDeCommandeDao ligneCommandeDao;
	@Inject private ProduitDao produitDao;
    public CommandesServlet() throws ClassNotFoundException, SQLException {
        super();
        commandeDao = new  CommandeDao();
        ligneCommandeDao = new LigneDeCommandeDao();
        produitDao = new ProduitDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//String action = request.getParameter("act");//(String) session.getAttribute("page");
		String action  = (String)request.getParameter("act");
		
		//list 
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		List<Commande> listCmd = new ArrayList<Commande>();
		List<LigneDeCommande> listLigCmd = new ArrayList<LigneDeCommande>(); 
		System.out.println("hello in commandes" + action);
		try {
		// --- 1 : Commandes ---
			if(action.equals("saveC") ) {
			java.util.Date date = new java.util.Date();
			Commande commande = new Commande(0, new Date(date.getTime()), user.getIdUtil());
			
			commandeDao.save(commande);
			this.getServletContext().getRequestDispatcher("/CommandesServlet?act=list").forward(request, response);
		               }
					if(action.equals("list") )
					{
					
						if(user.getTypeUtil() == 1)
						{
						
								listCmd = commandeDao.List();
							
							request.setAttribute("listCmd", listCmd);
							this.getServletContext().getRequestDispatcher("/Commandes.jsp").forward(request, response);
						}
						else
						{
							listCmd = commandeDao.getByIdUser(user.getIdUtil());
							request.setAttribute("listCmd", listCmd);
							this.getServletContext().getRequestDispatcher("/Commandes.jsp").forward(request, response);
						}
					}if(action.equals("detail"))
					{
						int id  = Integer.parseInt(request.getParameter("id"));
						session.setAttribute("idCmd", id);
						
						listLigCmd = ligneCommandeDao.getByIdCmd(id);
						
						request.setAttribute("listLigCmd", listLigCmd);
						
						this.getServletContext().getRequestDispatcher("/lignesCommandes.jsp").forward(request, response);
					}
					if(action.equals("delete"))
					{   
						int id  = Integer.parseInt(request.getParameter("id"));
						commandeDao.delete(id);
						
						
						this.getServletContext().getRequestDispatcher("/CommandesServlet?act=list").forward(request, response);
					}
					if(action.equals("deleteL"))
					{   
						int id  = Integer.parseInt(request.getParameter("id"));
						int idCmd = (Integer) session.getAttribute("idCmd");
						ligneCommandeDao.delete(id);
						
						
						this.getServletContext().getRequestDispatcher("/CommandesServlet?act=detail&id="+idCmd+"").forward(request, response);
					}
					if(action.equals("ajouteL"))
					{   
						List<Produit> listProd = new ArrayList<Produit>();
						//int idCmd = (Integer) session.getAttribute("idCmd");
						listProd = produitDao.List();
						
						request.setAttribute("listProd", listProd);
					
						
						
						this.getServletContext().getRequestDispatcher("/createLigneCommande.jsp").forward(request, response);
					}if(action.equals("saveL"))
					{    
						System.out.println("lignes cmd" +request.getParameter("idProd") +request.getParameter("quantite") + request.getParameter("idCmd"));
						int idCmd = (Integer) session.getAttribute("idCmd");
							//int idCmd = Integer.parseInt(request.getParameter("idCmd"));
						int idProd = Integer.parseInt(request.getParameter("idProd"));
						int  quantite = Integer.parseInt(request.getParameter("quantite"));
						LigneDeCommande ligneCommande = new LigneDeCommande(0, quantite, idCmd, idProd);
						
						ligneCommandeDao.save(ligneCommande);
						this.getServletContext().getRequestDispatcher("/CommandesServlet?act=detail&id="+idCmd+"").forward(request, response);
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
