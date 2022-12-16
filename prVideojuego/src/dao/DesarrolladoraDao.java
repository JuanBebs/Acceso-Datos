package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Desarrolladora;
import pojo.Videojuego;
import util.DatabaseConnection;

public class DesarrolladoraDao implements InterfazDao<Desarrolladora> {

	private  static Connection connection;
	
	public DesarrolladoraDao() {
		
	}
	@Override
	public ArrayList<Desarrolladora> buscarTodos() {
		
		ArrayList<Desarrolladora> desarrolladoras = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "SELECT * FROM desarrolladoras";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Desarrolladora desarrolladora = new Desarrolladora(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("pais"),
						null
						);
				desarrolladoras.add(desarrolladora);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return desarrolladoras;
	}

	@Override
	public Desarrolladora buscarPorId(int id) {
		connection = openConnection();
		
		Desarrolladora desarrolladora = null;
		
		String query = "select * from desarrolladoras where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				desarrolladora = new Desarrolladora(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("pais"),
						null
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return desarrolladora;
	}
	

	@Override
	public void insertar(Desarrolladora t) {
		
		connection = openConnection();
		
		String query = "insert into desarrolladoras (nombre, pais, videojuego_id) values (?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getPais());
			ps.setInt(3, t.getVideojuego().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}

	@Override
	public void modificar(Desarrolladora desarrolladora) {
		
		int id = desarrolladora.getId();
		String nombre = desarrolladora.getNombre();
		String pais = desarrolladora.getPais();
		
		connection = openConnection();
		
		String query = "UPDATE videojuegos SET nombre = ?, genero = ?, pegi = ? WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setString(2, pais);
			ps.setInt(3, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void borrar(Desarrolladora t) {
		// TODO Auto-generated method stub
		
	}
	
	private static Connection openConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}
	
	private static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void borrar(String nombre) {
		
		connection = openConnection();
		
		Desarrolladora desarrolladora = null;
		
		String query="DELETE from desarrolladora where nombre = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
	}

}
