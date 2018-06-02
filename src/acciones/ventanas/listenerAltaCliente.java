package acciones.ventanas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import control.ParaUI;
import vista.AltaCliente;

/**
 * 
 * @author Fernan, Pablo
 *
 */
public class listenerAltaCliente implements ActionListener {

	private ParaUI paraUI;

	public listenerAltaCliente(ParaUI paraui) {
		super();
		this.paraUI = paraui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.getContentPane().getComponent(3).setVisible(true);
		AltaCliente ventana = this.paraUI.getPanelAltaCliente();
	}
}
