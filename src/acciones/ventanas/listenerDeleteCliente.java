package acciones.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;
import vista.BajaCliente;
import vista.ModificarArticulo;

public class listenerDeleteCliente implements ActionListener {

	private ParaUI paraUI;

	public listenerDeleteCliente(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.getContentPane().getComponent(4).setVisible(true);
		BajaCliente ventana = this.paraUI.getPanelBajaCliente();
		this.paraUI.agregarClienteCombo(ventana.getComboClientes());
	}

}
