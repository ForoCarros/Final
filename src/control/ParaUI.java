package control;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JInternalFrame;

import acciones.botones.listenerBtnAltaCliente;
import acciones.ventanas.listenerAltaArticulo;
import acciones.ventanas.listenerAltaCliente;
import acciones.ventanas.listenerAltaPedido;
import acciones.ventanas.listenerConsultarArticulo;
import acciones.ventanas.listenerDeleteCliente;
import acciones.ventanas.listenerModificarArticulo;
import logica.Altas;
import logica.Logica;
import utiles.Validador;
import vista.UI;

public class ParaUI extends UI {

	private Altas altas;
	private Logica logica;
	private Validador validador;

	private listenerAltaArticulo listenerAltaArticulo;
	private listenerConsultarArticulo listenerConsultarArticulo;
	private listenerModificarArticulo listenerModificarArticulo;
	private listenerAltaCliente listenerAltaCliente;
	private listenerDeleteCliente listenerBajaCliente;
	private listenerAltaPedido listenerAltaPedido;
	private listenerBtnAltaCliente listenerBtnAltaCliente;

	public ParaUI() {
		super();
		this.altas = new Altas(this);
		asignarListenerVentana();
		asignarListenerBotones();
		Component component[] = this.contentPane.getComponents();
		for (Component component2 : component) {
			System.out.println(component2.getName());
		}
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
	
	private void asignarListenerBotones() {
		this.listenerBtnAltaCliente = new listenerBtnAltaCliente(this);
		this.panelAltaCliente.getBtnCrearCliente().addActionListener(this.listenerBtnAltaCliente);
	}

	/**
	 * Asigna los listener a cada boton
	 */
	private void asignarListenerVentana() {
		this.listenerAltaArticulo = new listenerAltaArticulo(this);
		this.listenerConsultarArticulo = new listenerConsultarArticulo(this);
		this.listenerModificarArticulo = new listenerModificarArticulo(this);
		this.listenerAltaCliente = new listenerAltaCliente(this);
		this.listenerBajaCliente = new listenerDeleteCliente(this);
		this.listenerAltaPedido = new listenerAltaPedido(this);
		this.mntmAltaArticulo.addActionListener(this.listenerAltaArticulo);
		this.mntmConsultaArticulo.addActionListener(this.listenerConsultarArticulo);
		this.mntmModificacinArticulo.addActionListener(this.listenerModificarArticulo);
		this.mntmAltaCliente.addActionListener(this.listenerAltaCliente);
		this.mntmBajaCliente.addActionListener(this.listenerBajaCliente);
		this.mntmAltaPedido.addActionListener(this.listenerAltaPedido);
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
		this.contentPane.repaint();
		this.contentPane.validate();
		this.contentPane.revalidate();
	}
}
