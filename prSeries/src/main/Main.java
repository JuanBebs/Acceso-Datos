package main;

import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Serie serie=new Serie("Los Simpsons", 7, "Disney plus");
		SerieDao serieDao = new SerieDao();
		//serieDao.insertar(serie);
		
		//System.out.println(serieDao.buscarPorId(1));
		//Serie s = new Serie(2, "titulo", 3, "plataforma", null);
		//Serie serie = serieDao.buscarPorId(1);
//		Temporada t1= new Temporada(1, "Temporada 1", serie);
//		Temporada t2 = new Temporada(2, "Temporada 2", serie);
		
		//TemporadaDao temporadaDao = new TemporadaDao();
		//temporadaDao.insertar(t1);
		//temporadaDao.insertar(t2);
		
		//Serie s = new Serie("The Mandalorian", 12, "Disney Plus");
		//serieDao.insertar(s);
		
		Serie los_simpsons= serieDao.buscarPorId(1);
		//los_simpsons.setPlataforma("Netflix");
		//serieDao.modificar(los_simpsons);
		//ArrayList<Serie> series= serieDao.buscarTodos();
		
		ArrayList<Temporada> temporadas = serieDao.obtenerTemporadas(los_simpsons);

		for (Temporada temporada: temporadas) {
			System.out.println(temporadas);
		}
		/*
		for (Serie serie : series) {
			System.out.println(serie);
		}*/
	}

}
