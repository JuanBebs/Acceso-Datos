package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import pojo.Temporada;
import util.DatabaseConnection;

public class SerieDao extends ObjetoDao implements InterfazDao<Serie> {

	private static Connection connection;
	
	public SerieDao () {
		
	}
	
	@Override
	public ArrayList<Serie> buscarTodos() {
		// TODO Auto-generated method stub
		connection = openConnection();
		
		ArrayList<Serie> series = new ArrayList<>();
		
		String query = "select * from series";
		
		
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				Serie serie = new Serie(rs.getInt("id"),
						rs.getString("titulo"),
						rs.getInt("edad"),
						rs.getString("plataforma"),
						null);
				series.add(serie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return series;
	}

	@Override
	public Serie buscarPorId(int id) {
		connection = openConnection();
		
		String query = "select * from series where id = ?";
		Serie serie=null;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next() ) {
				 serie = new Serie(rs.getInt("id"),
						rs.getString("titulo"),
						rs.getInt("edad"),
						rs.getString("plataforma"),
						null
						 );
				 serie.setTemporadas(obtenerTemporadas(serie));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return serie;
	}

	@Override
	public void insertar(Serie serie) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
		String query = "insert into series (titulo, edad, plataforma)"
				+ " values (?, ?, ?)";
		
		try {
		PreparedStatement ps=connection.prepareStatement(query);
		
		ps.setString(1, serie.getTitulo());
		ps.setInt(2, serie.getEdad());
		ps.setString(3, serie.getPlataforma());
		ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	@Override
	public void modificar(Serie serie) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
		int id = serie.getId();
		String titulo = serie.getTitulo();
		int edad = serie.getEdad();
		String plataforma = serie.getPlataforma();
		
		String query= "update series set titulo=?, edad=?, plataforma=?"
				+" where id=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, titulo);
			ps.setInt(2, edad);
			ps.setString(3, plataforma);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	public ArrayList<Temporada> obtenerTemporadas(Serie serie) {
		
		connection = openConnection();
		
		ArrayList<Temporada> temporadas = new ArrayList<>();
		
		String query = "select * from temporadas where serie_id = ?";
		
		try {
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, serie.getId());
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Temporada temporada=new Temporada(
						rs.getInt("id"),
						rs.getInt("num_temporada"),
						rs.getString("titulo"),
						serie);
				temporadas.add(temporada);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//closeConnection();
		
		return temporadas;
	}
	
	@Override
	public void borrar(Serie t) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
		String query= "delete from series";
		
		
	}
	
	

}
