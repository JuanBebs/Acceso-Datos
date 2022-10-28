package pojo;

public class Temporada {

	private int id;
	private int num_temporada;
	private String titulo;
	private Serie serie;
	
	//este constructor es usado para crear  y por eso no incluye el id
	public Temporada(int num_temporada, String titulo, Serie serie) {
		super();
		this.num_temporada = num_temporada;
		this.titulo = titulo;
		this.serie = serie;
	}
	
	//Este constructor es usado cuando lo usamos desde la base de datos 
	public Temporada(int id, int num_temporada, String titulo, Serie serie) {
		super();
		this.id = id;
		this.num_temporada = num_temporada;
		this.titulo = titulo;
		this.serie = serie;
	}

	public int getNum_temporada() {
		return num_temporada;
	}

	public void setNum_temporada(int num_temporada) {
		this.num_temporada = num_temporada;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Temporada [id=" + id + ", num_temporada=" + num_temporada + ", titulo=" + titulo + ", serie=" + serie.getTitulo()
				+ "]";
	}
	
	
}
