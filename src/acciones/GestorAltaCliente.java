package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.ParaUI;

/**
 * 
 * @author Fernan
 *
 */
public class GestorAltaCliente implements ActionListener {

	private ParaUI paraUI;

	public GestorAltaCliente(ParaUI paraui) {
		super();
		this.paraUI = paraui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.getContentPane().getComponent(3).setVisible(true);
	}
}
