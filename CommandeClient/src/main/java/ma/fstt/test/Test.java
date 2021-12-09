package ma.fstt.test;

import java.sql.SQLException;

import ma.fstt.dao.UtilisateurDAO;
import ma.fstt.model.Utilisateur;

public class Test {
   
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	
				
		  UtilisateurDAO	utilDAO= new   UtilisateurDAO();
			
		Utilisateur util = new Utilisateur(0,"ikram","1234", "d1234", "ikram@gmail.com", 1);
		utilDAO.save(util);
	}

}
