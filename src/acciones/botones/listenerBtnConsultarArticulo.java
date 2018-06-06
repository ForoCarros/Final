package acciones.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;
import modelo.data.Articulo;
import vista.ConsultaArticulo;

public class listenerBtnConsultarArticulo implements ActionListener {
	private ParaUI paraUI;

	public listenerBtnConsultarArticulo(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	// ESTÁ HECHO EN BASE A QUE EL .getSelectedItem() DEL COMBOBOX RETORNA UN
	// STRING, OSEA QUE LO MISMO HAY QUE CAMBIARLO
	@Override
	public void actionPerformed(ActionEvent e) {
		ConsultaArticulo ventana = this.paraUI.getPanelConsultarArticulo();
		String nombreArticulo = (String) ventana.getComboArticulos().getSelectedItem();
		Articulo articulo = this.paraUI.getLogica().buscarArticulo(nombreArticulo);
		if (articulo != null) {
			ventana.getTxtDescripcion().setText(articulo.getDescripcion());
			ventana.getTxtPrecioActual().setText(String.valueOf(articulo.getCurrentPrice()));
		} else {
			System.out.println("El artículo no existe :/");
		}

	}

}
