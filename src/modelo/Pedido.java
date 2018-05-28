package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Pedido implements Serializable{
	private ArrayList<Linea> lineas;
	private Cliente cliente;
	private double total;
	private int numeroPedido;
	private GregorianCalendar fecha;

	public Pedido(ArrayList<Linea> lineas, Cliente cliente, double total, int numeroPedido,
			GregorianCalendar fecha) {
		super();
		this.lineas = lineas;
		this.cliente = cliente;
		this.total = total;
		this.numeroPedido = numeroPedido;
		this.fecha = fecha;
	}

	public ArrayList<Linea> getLineas() {
		return lineas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public double getTotal() {
		return total;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}


}
