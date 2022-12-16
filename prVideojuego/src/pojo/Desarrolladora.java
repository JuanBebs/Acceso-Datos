package pojo;

public class Desarrolladora {

	private int id;
	private String nombre;
	private String pais;
	private Videojuego videojuego;
	
	public Desarrolladora(String nombre, String pais, Videojuego videojuego) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.videojuego = videojuego;
	}

	public Desarrolladora(int id, String nombre, String pais, Videojuego videojuego) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.videojuego = videojuego;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Desarrolladora [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", videojuego=" + videojuego.getNombre()
				+ "]";
	}
	
	
}
