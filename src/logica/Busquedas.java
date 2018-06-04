package logica;

import control.ParaUI;
import modelo.acceso.AlmacenArticulo;
import modelo.acceso.AlmacenCliente;
import modelo.data.Articulo;

public class Busquedas {
	
	private ParaUI paraui;
	
	public Busquedas(ParaUI paraui) {
		super();
		this.paraui = paraui;
	}
	
	
	/**
	 * hay que crear la sobrecarga de todo
	 */
	
	
	public Articulo buscarArticulo(String nombre) {
		return this.paraui.getLogica().buscarArticulo(nombre);
	}

}
