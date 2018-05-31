package acciones.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;
import vista.ModificarArticulo;

public class listenerModificarArticulo implements ActionListener {

	private ParaUI paraUI;

	public listenerModificarArticulo(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.getContentPane().getComponent(2).setVisible(true);
		ModificarArticulo ventana = this.paraUI.getPanelModificarArticulo();
		this.paraUI.agregarArticuloCombo(ventana.getComboBox());
	}

}
