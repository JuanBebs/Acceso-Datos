package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Desarrolladora;
import pojo.Videojuego;
import util.DatabaseConnection;

public class VideojuegoDao implements InterfazDao<Videojuego>{

	private  static Connection connection;
	
	public VideojuegoDao() {
		
	}
	
	@Override
	public ArrayList<Videojuego> buscarTodos() {
		
		ArrayList<Videojuego> videojuegos = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "SELECT * FROM videojuegos";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Videojuego videojuego = new Videojuego(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("genero"),
						rs.getInt("pegi"),
						null
						);
				videojuegos.add(videojuego);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videojuegos;
	}

	@Override
	public Videojuego buscarPorId(int id) {
		
		connection = openConnection();
		
		Videojuego videojuego = null;
		
		String query = "select * from videojuegos where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				videojuego = new Videojuego(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("genero"),
						rs.getInt("pegi"),
						null
						);
				videojuego.setDesarrolladora(obtenerDesarrolladora(videojuego));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return videojuego;
	}

	@Override
	public void insertar(Videojuego videojuego) {
		
		connection = openConnection();
		
		String query = "insert into videojuegos (nombre, genero, pegi) values (?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, videojuego.getNombre());
			ps.setString(2, videojuego.getGenero());
			ps.setInt(3, videojuego.getPegi());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();		
	}

	@Override
	public void modificar(Videojuego videojuego) {
		
		int id = videojuego.getId();
		String nombre = videojuego.getNombre();
		String genero = videojuego.getGenero();
		int pegi = videojuego.getPegi();
		
		connection = openConnection();
		
		String query = "UPDATE videojuegos SET nombre = ?, genero = ?, pegi = ? WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.setString(2, genero);
			ps.setInt(3, pegi);
			ps.setInt(4, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Desarrolladora> obtenerDesarrolladora(Videojuego videojuego) {
		
		ArrayList<Desarrolladora> desarrolladoras = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "SELECT * FROM desarrolladoras WHERE videojuego_id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, videojuego.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Desarrolladora desarrolladora = new Desarrolladora(
				rs.getInt("id"),
				rs.getString("nombre"),
				rs.getString("pais"),
				videojuego
				);
				desarrolladoras.add(desarrolladora);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return desarrolladoras;
	}
	
	public Videojuego buscarPorNombre(String nombre) {
		
		connection= openConnection();
		
		Videojuego videojuego = null;
		
		String query = "select from videojuegos where nombre = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				videojuego = new Videojuego(rs.getInt("id"),
											rs.getString("nombre"),
											rs.getString("genero"),
											rs.getInt("pegi"),
											null
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
		return null;
	}
	

	@Override
	public void borrar(String nombre) {
		
		connection = openConnection();
		
		Videojuego videojuego = null;
		
		String query="DELETE from videojuegos where nombre = ?";
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
	public void borrar(Videojuego t) {
		// TODO Auto-generated method stub
		
	}

}
