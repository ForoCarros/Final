package acciones.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;
import modelo.data.Articulo;
import vista.AltaArticulo;
import vista.ModificarArticulo;

public class listenerBtnModificarArticulo implements ActionListener {
	private ParaUI paraUI;

	public listenerBtnModificarArticulo(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ModificarArticulo ventana = this.paraUI.getPanelModificarArticulo();
		System.out.println("comprueba modificar");
		assert !this.paraUI.getValidador().comprobarVacio(ventana.getTxtNuevoPrecio().getText()) : "id vacia";

		// modificar el precio del articulo
		float nuevoPrecio = Float.valueOf(ventana.getTxtNuevoPrecio().getText());
		String nombreArticulo = (String) ventana.getComboBox().getSelectedItem();
		if (this.paraUI.actualizarPrecio(nombreArticulo, nuevoPrecio)) {
			ventana.getTxtMensajeModificar().setText("precio modificado");
			ventana.getTxtNuevoPrecio().setText("");
		} else {
			ventana.getTxtMensajeModificar().setText("error");
		}

	}

}
