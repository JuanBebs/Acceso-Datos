package main;

import dao.SerieDao;
import pojo.Serie;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Serie serie=new Serie("Los Simpsons", 7, "Disney plus");
		SerieDao serieDao = new SerieDao();
		serieDao.insertar(serie);
	}

}
