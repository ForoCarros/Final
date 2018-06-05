package control;

import java.awt.Color;
import java.awt.Component;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import acciones.botones.listenerBtnAltaArticulo;
import acciones.botones.listenerBtnAltaCliente;
import acciones.botones.listenerBtnAltaPedido;
import acciones.botones.listenerBtnAnadirLineaPedido;
import acciones.botones.listenerBtnConsultarArticulo;
import acciones.botones.listenerBtnDeleteCliente;
import acciones.botones.listenerBtnModificarArticulo;
import acciones.ventanas.listenerAltaArticulo;
import acciones.ventanas.listenerAltaCliente;
import acciones.ventanas.listenerAltaPedido;
import acciones.ventanas.listenerConsultarArticulo;
import acciones.ventanas.listenerDeleteCliente;
import acciones.ventanas.listenerModificarArticulo;
import logica.Logica;
import modelo.acceso.AlmacenArticulo;
import modelo.acceso.AlmacenCliente;
import modelo.data.Articulo;
import modelo.data.Cliente;
import utiles.Validador;
import vista.UI;

public class ParaUI extends UI {

	private Logica logica;
	private Validador validador;
	private listenerAltaArticulo listenerAltaArticulo;
	private listenerConsultarArticulo listenerConsultarArticulo;
	private listenerModificarArticulo listenerModificarArticulo;
	private listenerAltaCliente listenerAltaCliente;
	private listenerDeleteCliente listenerBajaCliente;
	private listenerAltaPedido listenerAltaPedido;
	private listenerBtnAltaArticulo listenerBtnAltaArticulo;
	private listenerBtnAltaCliente listenerBtnAltaCliente;
	private listenerBtnModificarArticulo listenerBtnModificarArticulo;
	private listenerBtnDeleteCliente listenerBtnDeleteCliente;
	private listenerBtnConsultarArticulo listenerBtnConsultarArticulo;
	private listenerBtnAnadirLineaPedido listenerBtnAnadirLineaPedido;
	private listenerBtnAltaPedido listenerBtnAltaPedido;

	public ParaUI() {
		super();
		this.logica = new Logica();
		this.validador = new Validador();
		asignarListenerVentana();
		asignarListenerBotones();
	}

	public Logica getLogica() {
		return logica;
	}

	public Validador getValidador() {
		return validador;
	}

	/**
	 * asigna los listener a cada boton
	 */
	private void asignarListenerBotones() {
		this.listenerBtnAltaCliente = new listenerBtnAltaCliente(this);
		this.listenerBtnAltaArticulo = new listenerBtnAltaArticulo(this);
		this.listenerBtnModificarArticulo = new listenerBtnModificarArticulo(this);
		this.listenerBtnDeleteCliente = new listenerBtnDeleteCliente(this);
		this.listenerBtnConsultarArticulo = new listenerBtnConsultarArticulo(this);
		this.listenerModificarArticulo = new listenerModificarArticulo(this);
		this.listenerBajaCliente = new listenerDeleteCliente(this);
		this.listenerAltaPedido = new listenerAltaPedido(this);
		this.listenerConsultarArticulo = new listenerConsultarArticulo(this);
		this.listenerBtnAnadirLineaPedido = new listenerBtnAnadirLineaPedido(this);
		this.listenerBtnAltaPedido = new listenerBtnAltaPedido(this);

		this.panelAltaCliente.getBtnCrearCliente().addActionListener(this.listenerBtnAltaCliente);
		this.panelAltaArticulo.getBtnAceptar().addActionListener(this.listenerBtnAltaArticulo);
		this.panelModificarArticulo.getBtnActualizarPrecio().addActionListener(this.listenerBtnModificarArticulo);
		this.panelBajaCliente.getBtnEliminar().addActionListener(this.listenerBtnDeleteCliente);
		this.panelAltaPedido.getBtnCrearPedido().addActionListener(this.listenerAltaPedido);
		this.panelConsultarArticulo.getBtnBuscar().addActionListener(this.listenerBtnConsultarArticulo);
		this.panelAltaPedido.getBtnAnadirLinea().addActionListener(this.listenerBtnAnadirLineaPedido);
		this.panelAltaPedido.getBtnCrearPedido().addActionListener(this.listenerBtnAltaPedido);
	}

	/**
	 * Asigna los listener a cada botonde ventana
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

	/**
	 * crea todos los internalFrame segun los vas llamando!
	 * 
	 * @param clase
	 */
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

	/**
	 * agreaga todos los articulos que hay en los ficheros y los mete en el comboBox
	 * 
	 * @param comboArticulos
	 */
	public void agregarArticuloCombo(JComboBox comboArticulos) {
		comboArticulos.removeAllItems();
		TreeMap indice = (TreeMap) new AlmacenArticulo<>("./data/articulos").getIndice();
		if (!(indice == null)) {
			// Creia que seria un SortedSet... pero me obliga al Set
			Set clave = indice.keySet();
			for (Object articulo : clave) {
				comboArticulos.addItem(articulo);
			}
		} else {
			System.out.println("combo nulo");
		}
	}

	/**
	 * agrega todos los clientes ,que hay en el paquete de indice, en el comboBox
	 * 
	 * @param comboClientes
	 */
	public void agregarClienteCombo(JComboBox comboClientes) {
		comboClientes.removeAllItems();
		TreeMap indice = (TreeMap) new AlmacenCliente<>("./data/clientes").getIndice();
		if (!(indice == null)) {
			Set clave = indice.keySet();
			for (Object clienteClave : clave) {
				comboClientes.addItem(clienteClave);
				
				// podria ser asi pero no....peta todo
//				Cliente cliente = (Cliente) new AlmacenCliente<>("./data/clientes").obtener(clienteClave);
//				comboClientes.addItem(cliente.getDniCif());
			}
		} else {
			System.out.println("combo nulo");
		}

	}

	/**
	 * modifica el precio del articulo elegido en el combo
	 * 
	 * @param nuevoPrecio
	 * @param object
	 * @return true o false, si lo consigue o no
	 */
	public boolean actualizarPrecio(String nombreArticulo, float nuevoPrecio) {
		System.out.println("haber si actualizamos el precio...");
		boolean encontrado = false;
		Articulo articulo = (Articulo) new AlmacenArticulo<>("./data/articulos/").leer(nombreArticulo);
		articulo.insertarNuevoPrecio(nuevoPrecio, false);
		if (new AlmacenArticulo<>("./data/articulos").grabar(articulo, articulo.getIdArticulo(),
				articulo.getNombre())) {
			encontrado = true;
			System.out.println("cambiado");
		}
		return encontrado;
	}

	public void vaciarVentanaAltaPedido() {
		DefaultTableModel modelo = (DefaultTableModel) this.panelAltaPedido.getLineasPedido().getModel();
		int filas = modelo.getRowCount();
		for (int i = filas - 1; i >= 0; i--) {
			modelo.removeRow(i);
		}
		this.panelAltaPedido.getTxtPrecioFinal().setText("0.0");
	}

	public void actualizarPrecioVentanaPedido(float precio) {
		this.panelAltaPedido.getTxtPrecioFinal().setText(String.valueOf(precio));
	}
}
