package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import ma.fstt.model.Utilisateur;
import ma.fstt.service.UtilisateurRepository;


public class UtilisateurDAO implements UtilisateurRepository {
	
	private Connection cnx;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	public UtilisateurDAO() throws SQLException, ClassNotFoundException {
		super();
		cnx = GConnection.getConnection();
	}

	@Override
	public void save(Utilisateur objetc) throws SQLException  {
		String request = "insert into utilisateur (nomUtil , passwordUtil,adresseUtil,emailUtil, typeUtil) values (? , ?,?, ?, ?)" ;
		preparedStatement = cnx.prepareStatement(request);
		preparedStatement.setString(1, objetc.getNomUtil());
		preparedStatement.setString(2, objetc.getPasswordUtil());
		preparedStatement.setString(3, objetc.getAdresseUtil());
		preparedStatement.setString(4, objetc.getEmailUtil());
		preparedStatement.setInt(5, objetc.getTypeUtil());
		preparedStatement.execute() ;
		
	}

	@Override
	public void update(Utilisateur objetc) throws SQLException {
	String request = "update  etudiant  set  nomUtil  = ? , passwordUtil = ? , adresseUtil  = ?,emailUtil  = ?, typeUtil  = ?  where  id_etudant = ? " ;
		
		// MOR
		preparedStatement = cnx.prepareStatement(request);
		
		preparedStatement = cnx.prepareStatement(request);
		preparedStatement.setString(1, objetc.getNomUtil());
		preparedStatement.setString(2, objetc.getPasswordUtil());
		preparedStatement.setString(3, objetc.getAdresseUtil());
		preparedStatement.setString(4, objetc.getEmailUtil());
		preparedStatement.setInt(5, objetc.getTypeUtil());
		
		
		preparedStatement.execute() ;
		
	}



	

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public java.util.List<Utilisateur> List() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getByEmail(String email) throws SQLException {
		String qry = "select * from utilisateur where emailUtil = ?";
		Utilisateur utilisateur = null;
		this.preparedStatement = this.cnx.prepareStatement(qry);
		this.preparedStatement.setString(1, email);
		this.resultSet = this.preparedStatement.executeQuery();
		while(this.resultSet.next()) {
			utilisateur = new Utilisateur(this.resultSet.getInt(1), this.resultSet.getString(2), this.resultSet.getString(3), this.resultSet.getString(4), 
					this.resultSet.getString(5), this.resultSet.getInt(6));
			break;
		}
		return utilisateur;
	}

	

}
