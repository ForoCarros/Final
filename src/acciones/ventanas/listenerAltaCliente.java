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

//		assert !(this.paraUI.getValidador().comprobarVacio(ventana.getTxtRazon().getText()) == true) : "razon vacia";
//		assert !(this.paraUI.getValidador().comprobarVacio(ventana.getTxtNif().getText()) == true) : "nif vacia";
//		assert !(this.paraUI.getValidador()
//				.comprobarVacio(ventana.getTxtDireccion().getText()) == true) : "direccion vacia";
//		assert !(this.paraUI.getValidador()
//				.comprobarVacio(ventana.getTxtTelefono().getText()) == true) : "telefono vacia";
//		assert !(this.paraUI.getValidador()
//				.comprobarTelefono(ventana.getTxtTelefono().getText()) == true) : "telefono erroneo";
//		assert !(this.paraUI.getValidador().comprobarNif(ventana.getTxtNif().getText()) == true) : "nif erroneo";
//		if (this.paraUI.getAltas().crearCliente(ventana.getTxtRazon().getText(), ventana.getTxtNif().getText(),
//				ventana.getTxtDireccion().getText(), ventana.getTxtTelefono().getText())) {
//			ventana.getTxtMensajeAltaCliente().setText("cliente creado");
//		} else {
//			ventana.getTxtMensajeAltaCliente().setText("ERROR");
//		}
	}
}
