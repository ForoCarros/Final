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
		this.paraUI.crearJInternalFrame(e.getActionCommand());
		assert this.paraUI.getValidador.comprobarVacio(txtRazon.getText())==true : "razon vacia";
		
		if (this.paraUI.getAltas().crearCliente(txtRazon.getText(), txtNif.getText(), txtDireccion.getText(),
				txtTelefono.getText())) {
			txtMensajeAltaCliente.setText("cliente creado");
		} else {
			txtMensajeAltaCliente.setText("ERROR");
		}
	}
}
