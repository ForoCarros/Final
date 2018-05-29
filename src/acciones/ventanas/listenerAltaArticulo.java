package acciones.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;

public class listenerAltaArticulo implements ActionListener {
	
	private ParaUI paraUI;
	
	public listenerAltaArticulo(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.getContentPane().getComponent(0).setVisible(true);
	}

}
