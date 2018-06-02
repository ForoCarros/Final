package acciones.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;
import vista.AltaPedido;
import vista.BajaCliente;

public class listenerAltaPedido implements ActionListener {

	private ParaUI paraUI;

	public listenerAltaPedido(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.getContentPane().getComponent(5).setVisible(true);
		AltaPedido ventana = this.paraUI.getPanelAltaPedido();
		this.paraUI.agregarClienteCombo(ventana.getComboClientes());
		this.paraUI.agregarArticuloCombo(ventana.getComboArticulos());
	}

}
