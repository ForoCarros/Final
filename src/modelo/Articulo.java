package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Articulo implements Serializable{
	private int id;
	private String nombre, descripcion;
	private ArrayList<Float> serieHistorica;

	public Articulo(int id, String nombre, String descripcion, ArrayList<Float> serieHistorica) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.serieHistorica = serieHistorica;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public ArrayList<Float> getSerieHistorica() {
		return serieHistorica;
	}
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}

}
