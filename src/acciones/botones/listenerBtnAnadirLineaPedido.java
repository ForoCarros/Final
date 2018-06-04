package acciones.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import control.ParaUI;
import logica.Logica;
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
		assert !panel.getTxtCantidad().getText().isEmpty() : "Cantidad igual o interior a 0";
		Logica logica = this.paraUI.getLogica();
		if (logica.getTemporal() == null) {
			System.out.println("listenerBtnAnadirLineaPedido > actionPerformed >> logica.getTemporal() == null");
			logica.setTemporal(new Pedido(logica.dameUltimoNumeroPedido(),
					new Cliente("12345678C", "test", "asd", "654987321")));
		}
		Pedido pedido = logica.getTemporal();
		Linea linea = new Linea(new Articulo(11, "tesst", "asd", 15),
				Integer.valueOf(panel.getTxtCantidad().getText()));
		pedido.insertarLinea(linea);
		logica.setTemporal(pedido);
		DefaultTableModel dm = (DefaultTableModel) panel.getLineasPedido().getModel();
		Vector<Linea> lineaTable = new Vector<>();
		lineaTable.addElement(linea);
		dm.addRow(lineaTable);
		System.out.println(new AlmacenCliente<>(Rutas.pathClientes).getIndice());
	}
}
