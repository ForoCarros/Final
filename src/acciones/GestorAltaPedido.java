package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;

public class GestorAltaPedido implements ActionListener {

	private ParaUI paraUI;

	public GestorAltaPedido(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.crearJInternalFrame(e.getActionCommand());
	}

}
