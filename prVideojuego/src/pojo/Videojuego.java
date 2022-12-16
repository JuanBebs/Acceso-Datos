package pojo;

import java.util.ArrayList;

public class Videojuego {

	public int id;
	public String nombre;
	private String genero;
	private int pegi;
	private ArrayList<Desarrolladora> desarrolladora;
	
	public Videojuego(String nombre, String genero, int pegi) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.pegi = pegi;
	}

	public Videojuego(int id, String nombre, String genero, int pegi, ArrayList<Desarrolladora> desarrolladora) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.pegi = pegi;
		this.desarrolladora = desarrolladora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

	public ArrayList<Desarrolladora> getDesarrolladora() {
		return desarrolladora;
	}

	public void setDesarrolladora(ArrayList<Desarrolladora> desarrolladora) {
		this.desarrolladora = desarrolladora;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", pegi=" + pegi + "]";
	}
	
	
	
	
}
