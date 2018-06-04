//package acciones.botones;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import control.ParaUI;
//import modelo.data.Cliente;
//import vista.ConsultaCliente;
//
//public class listenerBtnConsultarCliente implements ActionListener {
//	private ParaUI paraUI;
//	
//	
//	public listenerBtnConsultarCliente(ParaUI paraUI) {
//		super();
//		this.paraUI = paraUI;
//	}
//
//
//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		ConsultaCliente ventana = this.paraUI.getPanelConsultarCliente();
//		String clienteBuscado = (String)ventana.getComboClientes().getSelectedItem();
//		Cliente cliente = this.paraUI.getLogica().buscarCliente(clienteBuscado);
//		if (cliente!=null) {
//			ventana.getTxtDireccion().setText(cliente.getDireccion());
//			ventana.getTxtNif().setText(cliente.getDniCif());
//			ventana.getTxtTelefono().setText(cliente.getTelefono());
//		}else {
//			System.out.println("El cliente no existe :/");
//		}
//	}
//
//}
