package logica;

import control.ParaUI;
import modelo.acceso.AlmacenArticulo;
import modelo.acceso.AlmacenCliente;
import modelo.data.Articulo;
import modelo.data.Cliente;

public class Busquedas {
	
	private ParaUI paraui;
	
	public Busquedas(ParaUI paraui) {
		super();
		this.paraui = paraui;
	}
	
	public Articulo buscarArticulo(String nombre) {
		return this.paraui.getLogica().buscarArticulo(nombre);
	}
	
	public Cliente buscarCliente(String dni) {
		return this.paraui.getLogica().buscarCliente(dni);
	}

}
