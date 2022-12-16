package main;

import java.util.ArrayList;

import dao.DesarrolladoraDao;
import dao.VideojuegoDao;
import pojo.Desarrolladora;
import pojo.Videojuego;

public class Main {

	public static void main(String[] args) {
		
//		Videojuego videojuego1 = new Videojuego("Halo", "disparos", 16);
		VideojuegoDao videojuegoDao = new VideojuegoDao();
//		videojuegoDao.insertar(videojuego1);
		
//		System.out.println(videojuegoDao.buscarPorId(3)); //no imprime por id y en su lugar imprime null
		
//		Videojuego videojuego = videojuegoDao.buscarPorId(1);
//		System.out.println(videojuego); //null
//		Desarrolladora d1 = new Desarrolladora("343 Industries", "USA", videojuego);
		
		//Desarrolladora d2 = new Desarrolladora("EpicGames", "USA", videojuego);
		
//		DesarrolladoraDao desarrolladoraDao = new DesarrolladoraDao();
//		desarrolladoraDao.insertar(d1); //Da NullpointerException por que getVideojuego is null at DesarrolladoraDao.insertar
		
//		Videojuego v = new Videojuego("Elden ring", "RPG", 16);
//		videojuegoDao.insertar(v);
		
		Videojuego halo = videojuegoDao.buscarPorId(1);
//		halo.setGenero("aventura");							//NO FUNCIONA POR QUE "halo" is null.....cannot invoke pojo.videojuego.setGenero(String)
//		videojuegoDao.modificar(halo);
		
		/*ArrayList<Videojuego> videojuegos = videojuegoDao.buscarTodos();
		
		for (Videojuego videojuego : videojuegos) {
			System.out.println(videojuego);									//FUNCIONA
		}*/
		
		ArrayList<Desarrolladora> desarrolladoras = videojuegoDao.obtenerDesarrolladora(halo);
		
//		for (Desarrolladora desarrolladora : desarrolladoras) {
//			System.out.println(desarrolladora);								//NO FUNCIONA no puede invocar Videojuegos.getid() por que "videojuegos" is null
//		}
		
		
	}

}
