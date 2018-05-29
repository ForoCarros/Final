package acciones.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;
import vista.AltaCliente;

public class listenerBtnAltaCliente implements ActionListener {
	private ParaUI paraUI;

	public listenerBtnAltaCliente(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AltaCliente ventana = this.paraUI.getPanelAltaCliente();
		assert !this.paraUI.getValidador().comprobarVacio(ventana.getTxtRazon().getText()) : "razon vacia";
		assert !this.paraUI.getValidador().comprobarVacio(ventana.getTxtNif().getText()) : "nif vacia";
		assert !this.paraUI.getValidador().comprobarVacio(ventana.getTxtDireccion().getText()) : "direccion vacia";
		assert !this.paraUI.getValidador().comprobarVacio(ventana.getTxtTelefono().getText()) : "telefono vacia";
		assert this.paraUI.getValidador().comprobarTelefono(ventana.getTxtTelefono().getText()) : "telefono erroneo";
		assert this.paraUI.getValidador().comprobarNif(ventana.getTxtNif().getText()) : "nif erroneo";
		if (this.paraUI.getAltas().crearCliente(ventana.getTxtRazon().getText(), ventana.getTxtNif().getText(),
				ventana.getTxtDireccion().getText(), ventana.getTxtTelefono().getText())) {
			ventana.getTxtMensajeAltaCliente().setText("cliente creado");
		} else {
			ventana.getTxtMensajeAltaCliente().setText("ERROR");
		}
	}
}
