package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ConsultaCliente extends JFrame {
	protected JComboBox comboClientes;
	protected JTextField txtNIF;
	protected JTextField txtDireccion;
	protected JButton btnBuscar;
	private JLabel lblTelefono;
	private JTextField txtTelefono;

	/**
	 * Create the panel.
	 */
	public ConsultaCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblConsultarCliente = new JLabel("CONSULTAR CLIENTE");
		lblConsultarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarCliente.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblConsultarCliente.setFont(new Font("Century", Font.BOLD, 25));
		GridBagConstraints gbc_lblConsultarCliente = new GridBagConstraints();
		gbc_lblConsultarCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblConsultarCliente.gridwidth = 3;
		gbc_lblConsultarCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblConsultarCliente.gridx = 1;
		gbc_lblConsultarCliente.gridy = 1;
		getContentPane().add(lblConsultarCliente, gbc_lblConsultarCliente);
		
		JLabel lblRazonSocial = new JLabel("Razon Social:");
		lblRazonSocial.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblRazonSocial = new GridBagConstraints();
		gbc_lblRazonSocial.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRazonSocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblRazonSocial.gridx = 1;
		gbc_lblRazonSocial.gridy = 3;
		getContentPane().add(lblRazonSocial, gbc_lblRazonSocial);
		
		comboClientes = new JComboBox();
		GridBagConstraints gbc_comboClientes = new GridBagConstraints();
		gbc_comboClientes.gridwidth = 2;
		gbc_comboClientes.insets = new Insets(0, 0, 5, 5);
		gbc_comboClientes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboClientes.gridx = 2;
		gbc_comboClientes.gridy = 3;
		getContentPane().add(comboClientes, gbc_comboClientes);
		
		btnBuscar = new JButton("BUSCAR");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.gridwidth = 3;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 4;
		getContentPane().add(btnBuscar, gbc_btnBuscar);
		
		JLabel lblNIF = new JLabel("NIF/CIF:");
		lblNIF.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNIF = new GridBagConstraints();
		gbc_lblNIF.anchor = GridBagConstraints.NORTH;
		gbc_lblNIF.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNIF.insets = new Insets(0, 0, 5, 5);
		gbc_lblNIF.gridx = 1;
		gbc_lblNIF.gridy = 6;
		getContentPane().add(lblNIF, gbc_lblNIF);
		
		txtNIF = new JTextField();
		txtNIF.setEditable(false);
		GridBagConstraints gbc_txtNIF = new GridBagConstraints();
		gbc_txtNIF.gridwidth = 2;
		gbc_txtNIF.insets = new Insets(0, 0, 5, 5);
		gbc_txtNIF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNIF.gridx = 2;
		gbc_txtNIF.gridy = 6;
		getContentPane().add(txtNIF, gbc_txtNIF);
		txtNIF.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.NORTH;
		gbc_lblDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 1;
		gbc_lblDireccion.gridy = 7;
		getContentPane().add(lblDireccion, gbc_lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		GridBagConstraints gbc_txtDireccion = new GridBagConstraints();
		gbc_txtDireccion.gridwidth = 2;
		gbc_txtDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDireccion.gridx = 2;
		gbc_txtDireccion.gridy = 7;
		getContentPane().add(txtDireccion, gbc_txtDireccion);
		txtDireccion.setColumns(10);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.NORTH;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 8;
		getContentPane().add(lblTelefono, gbc_lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.gridwidth = 2;
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefono.gridx = 2;
		gbc_txtTelefono.gridy = 8;
		getContentPane().add(txtTelefono, gbc_txtTelefono);

	}

	public JComboBox getComboClientes() {
		return comboClientes;
	}

	public JTextField getTxtNif() {
		return txtNIF;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}
	
	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	
	

	
}
