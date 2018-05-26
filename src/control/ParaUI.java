package control;

import acciones.Altas;
import logica.Logica;
import utiles.Validador;
import vista.UI;

public class ParaUI extends UI {
	
	private Altas altas;
	private Logica logica;
	private Validador validador;
	
	
	public ParaUI() {
		super();
		this.altas=new Altas(this);
		asignarListener();
	}
	
	/**
	 * Asigna los listener a cada boton
	 */
	private void asignarListener() {
		
	}

}
