package acciones.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.ParaUI;
import vista.AltaArticulo;
import vista.AltaCliente;

public class listenerAltaArticulo implements ActionListener {
	
	private ParaUI paraUI;
	
	public listenerAltaArticulo(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.paraUI.getContentPane().getComponent(0).setVisible(true);
		AltaArticulo ventana = this.paraUI.getPanelAltaArticulo();
		int numeroIndice=(this.paraUI.getLogica().dameUltimoNumero())+1;
		System.out.println(numeroIndice);
		ventana.getTxtId().setText(String.valueOf(numeroIndice));
	}

}
