package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class BajaCliente extends JPanel {
	protected JTextField txtMensajeBorrar;
	protected JComboBox comboClientes;
	protected JButton btnEliminar;

	/**
	 * Create the panel.
	 */
	public BajaCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("BAJA CLIENTE");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Playbill", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblEligeClienteBorrar = new JLabel("Elige Cliente Borrar:");
		lblEligeClienteBorrar.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblEligeClienteBorrar = new GridBagConstraints();
		gbc_lblEligeClienteBorrar.fill = GridBagConstraints.BOTH;
		gbc_lblEligeClienteBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_lblEligeClienteBorrar.gridx = 1;
		gbc_lblEligeClienteBorrar.gridy = 4;
		add(lblEligeClienteBorrar, gbc_lblEligeClienteBorrar);
		
		comboClientes = new JComboBox();
		GridBagConstraints gbc_comboClientes = new GridBagConstraints();
		gbc_comboClientes.insets = new Insets(0, 0, 5, 5);
		gbc_comboClientes.fill = GridBagConstraints.BOTH;
		gbc_comboClientes.gridx = 2;
		gbc_comboClientes.gridy = 4;
		add(comboClientes, gbc_comboClientes);
		
		btnEliminar = new JButton("ELIMINAR");
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.gridwidth = 2;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 1;
		gbc_btnEliminar.gridy = 6;
		add(btnEliminar, gbc_btnEliminar);
		
		JLabel lblMensaje = new JLabel("Mensaje:");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
		gbc_lblMensaje.fill = GridBagConstraints.BOTH;
		gbc_lblMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblMensaje.gridx = 1;
		gbc_lblMensaje.gridy = 8;
		add(lblMensaje, gbc_lblMensaje);
		
		txtMensajeBorrar = new JTextField();
		txtMensajeBorrar.setEditable(false);
		GridBagConstraints gbc_txtMensajeBorrar = new GridBagConstraints();
		gbc_txtMensajeBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_txtMensajeBorrar.fill = GridBagConstraints.BOTH;
		gbc_txtMensajeBorrar.gridx = 2;
		gbc_txtMensajeBorrar.gridy = 8;
		add(txtMensajeBorrar, gbc_txtMensajeBorrar);
		txtMensajeBorrar.setColumns(10);

	}

	public JTextField getTxtMensajeBorrar() {
		return txtMensajeBorrar;
	}

	public JComboBox getComboClientes() {
		return comboClientes;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	
	

}
