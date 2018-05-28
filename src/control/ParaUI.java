package control;

import java.awt.Component;

import javax.swing.JInternalFrame;
import logica.Altas;
import logica.Logica;
import utiles.Validador;
import vista.UI;

public class ParaUI extends UI {

	private Altas altas;
	private Logica logica;
	private Validador validador;

	public ParaUI() {
		super();
		this.altas = new Altas(this);
		asignarListener();
	}

	/**
	 * Asigna los listener a cada boton
	 */
	private void asignarListener() {
		
	}

	private void crearJInternalFrame(String clase) {
		Class<?> cls = null;
		try {
			cls = Class.forName("vista." + clase);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object pane = null;
		try {
			pane = cls.newInstance();
			JInternalFrame frame = new JInternalFrame(clase, false, true, false);
			frame.getContentPane().add((Component) pane);
			frame.setVisible(true);
			frame.pack();
			this.contentPane.add(frame);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
