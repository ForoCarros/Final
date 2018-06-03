package acciones.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import control.ParaUI;
import logica.Logica;
import modelo.data.Articulo;
import modelo.data.Cliente;
import modelo.data.Linea;
import modelo.data.Pedido;
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
		assert Integer.valueOf(panel.getTxtCantidad().getText()) > 0 : "Cantidad igual o interior a 0";
		Logica logica = this.paraUI.getLogica();
		if (logica.getTemporal() == null) {
			logica.setTemporal(
					new Pedido(logica.dameUltimoNumeroPedido(), (Cliente) panel.getComboClientes().getSelectedItem()));
		}
		Pedido pedido = logica.getTemporal();
		Linea linea = new Linea((Articulo) panel.getComboArticulos().getSelectedItem(),
				Integer.valueOf(panel.getTxtCantidad().getText()));
		pedido.insertarLinea(linea);
		logica.setTemporal(pedido);
	}
}
