package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ma.fstt.model.Utilisateur;

public abstract class BaseDAO <T> {
	
	
	protected Connection cnx ;
	
	protected Statement stm ;
	
	protected PreparedStatement preparedStatement ;
	
	
	protected ResultSet resultSet ;
	
	
	
	public BaseDAO() throws SQLException, ClassNotFoundException {
		// singleton 
		this.cnx = GConnection.getConnection();
		
	}
	
	
	public abstract void save(T objetc) throws SQLException;
	
	public abstract void update(T objetc) throws SQLException;
	
	public abstract void delete (T objetc) throws SQLException;
	
	public abstract List<T> getAll () throws SQLException;
	
	public abstract T getOne(Integer id) throws SQLException;


	
	
	
	
	
	

}
