package acciones.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import control.ParaUI;
import modelo.data.Pedido;
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
		ventana.getTxtMensajePedido().setText("pedido creado");
		this.paraUI.getLogica().crear(this.paraUI.getLogica().getTemporal());
		this.paraUI.vaciarVentanaAltaPedido();
	}

}
