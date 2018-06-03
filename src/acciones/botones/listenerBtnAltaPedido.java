package acciones.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import control.ParaUI;
import vista.AltaPedido;

public class listenerBtnAltaPedido implements ActionListener{
	private ParaUI paraUI;
	
	public listenerBtnAltaPedido(ParaUI paraUI) {
		super();
		this.paraUI = paraUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AltaPedido ventana = this.paraUI.getPanelAltaPedido();
		System.out.println("pedido creado");
		ventana.getTxtMensajePedido().setText("pedido creado");
		//this.paraUI.
	}

}
