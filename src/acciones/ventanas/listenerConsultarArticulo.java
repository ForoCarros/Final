package acciones.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;

public class listenerConsultarArticulo implements ActionListener {
	
	private ParaUI paraUI;
	
	

	public listenerConsultarArticulo(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.getContentPane().getComponent(1).setVisible(true);
	}

}
