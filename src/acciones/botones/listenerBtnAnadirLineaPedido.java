package acciones.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import control.ParaUI;
import logica.Logica;
import modelo.acceso.AlmacenArticulo;
import modelo.acceso.AlmacenCliente;
import modelo.data.Articulo;
import modelo.data.Cliente;
import modelo.data.Linea;
import modelo.data.Pedido;
import utiles.Rutas;
import vista.AltaPedido;

public class listenerBtnAnadirLineaPedido implements ActionListener {
	private ParaUI paraUI;

	public listenerBtnAnadirLineaPedido(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AltaPedido panel = this.paraUI.getPanelAltaPedido();
		assert panel.getComboClientes() != null : "Cliente nulo";
		assert panel.getComboArticulos() != null : "Artículo nulo";
		assert !panel.getTxtCantidad().getText().isEmpty() : "Cantidad igual o inferior a 0";
		Logica logica = this.paraUI.getLogica();
		if (logica.getTemporal() == null) {
			logica.setTemporal(
					new Pedido(logica.dameUltimoNumeroPedido(), new Cliente("12345678C", "test", "asd", "654987321")));
		}
		Pedido pedido = logica.getTemporal();
		Articulo articulo = (Articulo) new AlmacenArticulo<>("./data/articulos/")
				.leer((String) (panel.getComboArticulos().getSelectedItem()));
		Linea linea = new Linea(articulo, Integer.valueOf(panel.getTxtCantidad().getText()));
		pedido.insertarLinea(linea);
		logica.setTemporal(pedido);
		DefaultTableModel dm = (DefaultTableModel) panel.getLineasPedido().getModel();
		Vector<Vector> lineaTable = new Vector<>();
		this.paraUI.getPanelAltaPedido().setRowData(rowData);
		this.paraUI.actualizarPrecioVentanaPedido(
				Float.valueOf(this.paraUI.getPanelAltaPedido().getTxtPrecioFinal().getText())
						+ articulo.getCurrentPrice());
	}

	public Vector toVector(Linea obj) {
		Vector vector = new Vector<>();
		String nombre = obj.getArticulo().getNombre();
		int cantidad = obj.getCantidad();
		float precio = obj.getArticulo().getCurrentPrice();
		float total = cantidad * precio;
		vector.add(nombre);
		vector.add(cantidad);
		vector.add(precio);
		vector.add(total);
		return vector;
	}
}
