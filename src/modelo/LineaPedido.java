package modelo;

public class LineaPedido {
	private Articulo articulo;
	private int cantidad;
	private float precio;

	public LineaPedido(Articulo articulo, int cantidad, float precio) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public float getPrecio() {
		return precio;
	}

}
