package acciones.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;
import vista.ConsultaArticulo;

public class listenerBtnConsultarArticulo implements ActionListener {
	private ParaUI paraUI;

	public listenerBtnConsultarArticulo(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ConsultaArticulo ventana = this.paraUI.getPanelConsultarArticulo();
		
		ventana.getTxtDescripcion().setText("encontrado");

	}

}
