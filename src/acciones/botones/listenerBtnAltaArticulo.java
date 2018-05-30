package acciones.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;
import modelo.data.Articulo;
import vista.AltaArticulo;
import vista.AltaCliente;

public class listenerBtnAltaArticulo implements ActionListener {
	private ParaUI paraUI;

	public listenerBtnAltaArticulo(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AltaArticulo ventana = this.paraUI.getPanelAltaArticulo();
		assert !this.paraUI.getValidador().comprobarVacio(ventana.getTxtId().getText()) : "id vacia";
		assert !this.paraUI.getValidador().comprobarVacio(ventana.getTxtNombre().getText()) : "nombre vacio";
		assert !this.paraUI.getValidador().comprobarVacio(ventana.getTxtDescripcion().getText()) : "descripcion vacia";
		assert !this.paraUI.getValidador().comprobarVacio(ventana.getTxtPrecio().getText()) : "precio vacio";
		assert !this.paraUI.getValidador().comprobarDigitos(ventana.getTxtPrecio().getText()) : "precio erroneo";

		if (this.paraUI.getLogica().crear(new Articulo(Integer.valueOf(ventana.getTxtId().getText()),
				ventana.getTxtNombre().getText(), ventana.getTxtDescripcion().getText(),
				Float.valueOf(ventana.getTxtPrecio().getText())))) {
			ventana.getTxtMensaje().setText("articulo creado");
		} else {
			ventana.getTxtMensaje().setText("error al crear");
		}
	}

}
