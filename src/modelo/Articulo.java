package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Articulo implements Comparable<Articulo>, Serializable {
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
		if (this == obj) {
			return true;
		}
		if (obj instanceof Articulo) {
			return this.nombre.equals(((Articulo) obj).getNombre());
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hasCode = 1;
		hasCode = 31 * hasCode + nombre.hashCode();
		return hasCode;
	}

	@Override
	public String toString() {
		return "Nombre articulo es : " + nombre;
	}

	@Override
	public int compareTo(Articulo o) {
		return this.nombre.compareTo(o.getNombre());
	}

}
