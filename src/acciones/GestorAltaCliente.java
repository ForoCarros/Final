package acciones;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import control.ParaUI;

/**
 * 
 * @author Fernan, Pablo
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
		JInternalFrame ventana = (JInternalFrame) this.paraUI.getContentPane().getComponent(3);
		ventana.setVisible(true);
		
		
		
//		assert !(this.paraUI.getValidador().comprobarVacio(ventana.txtRazon.getText()) == true) : "razon vacia";
//		assert !(this.paraUI.getValidador().comprobarVacio(ventana.txtNif.getText()) == true) : "nif vacia";
//		assert !(this.paraUI.getValidador().comprobarVacio(ventana.txtDireccion.getText()) == true) : "direccion vacia";
//		assert !(this.paraUI.getValidador().comprobarVacio(ventana.txtTelefono.getText()) == true) : "telefono vacia";
//		assert !(this.paraUI.getValidador()
//				.comprobarTelefono(ventana.txtTelefono.getText()) == true) : "telefono erroneo";
//		assert !(this.paraUI.getValidador().comprobarNif(ventana.txtNif.getText()) == true) : "nif erroneo";
//
//		/**
//		 * Los botones como los añadimos??
//		 */
//
//		if (this.paraUI.getAltas().crearCliente(ventana.txtRazon.getText(), ventana.txtNif.getText(),
//				ventana.txtDireccion.getText(), ventana.txtTelefono.getText())) {
//			txtMensajeAltaCliente.setText("cliente creado");
//		} else {
//			txtMensajeAltaCliente.setText("ERROR");
//		}
	}
}
