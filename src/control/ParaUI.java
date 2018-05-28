package control;

import java.awt.Component;

import javax.swing.JInternalFrame;

import acciones.GestorAltaArticulo;
import acciones.GestorAltaCliente;
import acciones.GestorAltaPedido;
import acciones.GestorConsultarArticulo;
import acciones.GestorDeleteCliente;
import acciones.GestorModificarArticulo;
import logica.Altas;
import logica.Logica;
import utiles.Validador;
import vista.UI;

public class ParaUI extends UI {

	private Altas altas;
	private Logica logica;
	private Validador validador;

	private GestorAltaArticulo listenerAltaArticulo;
	private GestorConsultarArticulo listenerConsultarArticulo;
	private GestorModificarArticulo listenerModificarArticulo;
	private GestorAltaCliente listenerAltaCliente;
	private GestorDeleteCliente listenerBajaCliente;
	private GestorAltaPedido listenerAltaPedido;

	public ParaUI() {
		super();
		this.altas = new Altas(this);
		asignarListener();
	}

	public Altas getAltas() {
		return altas;
	}

	public Logica getLogica() {
		return logica;
	}

	public Validador getValidador() {
		return validador;
	}

	/**
	 * Asigna los listener a cada boton
	 */
	private void asignarListener() {
		this.listenerAltaArticulo = new GestorAltaArticulo(this);
		this.listenerConsultarArticulo = new GestorConsultarArticulo(this);
		this.listenerModificarArticulo = new GestorModificarArticulo(this);
		this.listenerAltaCliente = new GestorAltaCliente(this);
		this.listenerBajaCliente = new GestorDeleteCliente(this);
		this.listenerAltaPedido = new GestorAltaPedido(this);
		this.mntmAltaArticulo.addActionListener(this.listenerAltaArticulo);
		this.mntmConsultaArticulo.addActionListener(this.listenerConsultarArticulo);
		this.mntmModificacinArticulo.addActionListener(this.listenerModificarArticulo);
		this.mntmAltaCliente.addActionListener(this.listenerAltaCliente);
		this.mntmBajaCliente.addActionListener(this.listenerBajaCliente);
		this.mntmAltaPedido.addActionListener(this.listenerAltaPedido);
	}

	public Component getSelected() {
		Component seleccionada = null;
		Component[] ventanas = this.contentPane.getComponents();
		System.out.println("- PRE -");
		System.out.println("Componenetes " + ventanas.length);
		System.out.println("Seleccionada: " + seleccionada);
		System.out.println("- OP -");
		for (Component component : ventanas) {
			if (component.hasFocus()) {
				System.out.println(component);
				seleccionada = component;
			}
		}
		System.out.println("- POST -");
		System.out.println("Componenetes " + ventanas.length);
		System.out.println("Seleccionada: " + seleccionada);
		return seleccionada;
	}

	public void crearJInternalFrame(String clase) {
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
			JInternalFrame frame = new JInternalFrame(clase + ".", true, true, true);
			frame.getContentPane().add((Component) pane);
			frame.setVisible(true);
			frame.pack();
			this.contentPane.add(frame);
			System.out.println("Parent: " + frame.getParent());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
