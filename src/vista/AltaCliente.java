package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaCliente extends JPanel {
	protected JTextField txtRazon;
	protected JTextField txtNif;
	protected JTextField txtDireccion;
	protected JTextField txtTelefono;
	protected JTextField txtMensajeAltaCliente;
	protected JButton btnCrearCliente;

	/**
	 * Create the panel.
	 */
	public AltaCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel_1 = new JLabel("ALTA CLIENTE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblNewLabel_1.setFont(new Font("Gigi", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNombre = new JLabel("Razon Social:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		add(lblNombre, gbc_lblNombre);

		txtRazon = new JTextField();
		GridBagConstraints gbc_txtRazon = new GridBagConstraints();
		gbc_txtRazon.gridwidth = 2;
		gbc_txtRazon.insets = new Insets(0, 0, 5, 5);
		gbc_txtRazon.fill = GridBagConstraints.BOTH;
		gbc_txtRazon.gridx = 2;
		gbc_txtRazon.gridy = 3;
		add(txtRazon, gbc_txtRazon);
		txtRazon.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nif/Cif:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 4;
		add(lblNewLabel, gbc_lblNewLabel);

		txtNif = new JTextField();
		GridBagConstraints gbc_txtNif = new GridBagConstraints();
		gbc_txtNif.gridwidth = 2;
		gbc_txtNif.insets = new Insets(0, 0, 5, 5);
		gbc_txtNif.fill = GridBagConstraints.BOTH;
		gbc_txtNif.gridx = 2;
		gbc_txtNif.gridy = 4;
		add(txtNif, gbc_txtNif);
		txtNif.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.fill = GridBagConstraints.BOTH;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 1;
		gbc_lblDireccion.gridy = 5;
		add(lblDireccion, gbc_lblDireccion);

		txtDireccion = new JTextField();
		GridBagConstraints gbc_txtDireccion = new GridBagConstraints();
		gbc_txtDireccion.gridwidth = 2;
		gbc_txtDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDireccion.fill = GridBagConstraints.BOTH;
		gbc_txtDireccion.gridx = 2;
		gbc_txtDireccion.gridy = 5;
		add(txtDireccion, gbc_txtDireccion);
		txtDireccion.setColumns(10);

		JLabel lblTele = new JLabel("Telefono:");
		lblTele.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTele = new GridBagConstraints();
		gbc_lblTele.fill = GridBagConstraints.BOTH;
		gbc_lblTele.insets = new Insets(0, 0, 5, 5);
		gbc_lblTele.gridx = 1;
		gbc_lblTele.gridy = 6;
		add(lblTele, gbc_lblTele);

		txtTelefono = new JTextField();
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.gridwidth = 2;
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefono.fill = GridBagConstraints.BOTH;
		gbc_txtTelefono.gridx = 2;
		gbc_txtTelefono.gridy = 6;
		add(txtTelefono, gbc_txtTelefono);
		txtTelefono.setColumns(10);

		JLabel lblMensaje = new JLabel("Mensaje:");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
		gbc_lblMensaje.fill = GridBagConstraints.BOTH;
		gbc_lblMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblMensaje.gridx = 1;
		gbc_lblMensaje.gridy = 8;
		add(lblMensaje, gbc_lblMensaje);

		txtMensajeAltaCliente = new JTextField();
		txtMensajeAltaCliente.setEditable(false);
		GridBagConstraints gbc_txtMensajeAltaCliente = new GridBagConstraints();
		gbc_txtMensajeAltaCliente.gridwidth = 2;
		gbc_txtMensajeAltaCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtMensajeAltaCliente.fill = GridBagConstraints.BOTH;
		gbc_txtMensajeAltaCliente.gridx = 2;
		gbc_txtMensajeAltaCliente.gridy = 8;
		add(txtMensajeAltaCliente, gbc_txtMensajeAltaCliente);
		txtMensajeAltaCliente.setColumns(10);

		btnCrearCliente = new JButton("CREAR");
		GridBagConstraints gbc_btnCrearCliente = new GridBagConstraints();
		gbc_btnCrearCliente.fill = GridBagConstraints.BOTH;
		gbc_btnCrearCliente.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearCliente.gridx = 3;
		gbc_btnCrearCliente.gridy = 9;
		add(btnCrearCliente, gbc_btnCrearCliente);
	}

	public JTextField getTxtRazon() {
		return txtRazon;
	}

	public JTextField getTxtNif() {
		return txtNif;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public JTextField getTxtMensajeAltaCliente() {
		return txtMensajeAltaCliente;
	}

	public JButton getBtnCrearCliente() {
		return btnCrearCliente;
	}

}
