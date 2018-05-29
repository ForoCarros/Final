package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ModificarArticulo extends JPanel {
	protected JTextField txtNuevoPrecio;
	protected JButton btnActualizarPrecio;
	protected JTextField txtMensajeModificar;
	protected JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public ModificarArticulo() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblModificarArticulo = new JLabel("MODIFICAR ARTICULO");
		lblModificarArticulo.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblModificarArticulo.setFont(new Font("Snap ITC", Font.BOLD, 30));
		GridBagConstraints gbc_lblModificarArticulo = new GridBagConstraints();
		gbc_lblModificarArticulo.fill = GridBagConstraints.VERTICAL;
		gbc_lblModificarArticulo.gridwidth = 2;
		gbc_lblModificarArticulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModificarArticulo.gridx = 1;
		gbc_lblModificarArticulo.gridy = 1;
		add(lblModificarArticulo, gbc_lblModificarArticulo);
		
		JLabel lblSeleccionaArticulo = new JLabel("Selecciona Articulo");
		GridBagConstraints gbc_lblSeleccionaArticulo = new GridBagConstraints();
		gbc_lblSeleccionaArticulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeleccionaArticulo.gridx = 1;
		gbc_lblSeleccionaArticulo.gridy = 3;
		add(lblSeleccionaArticulo, gbc_lblSeleccionaArticulo);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 3;
		add(comboBox, gbc_comboBox);
		
		JLabel lblIntroduceNuevoPrecio = new JLabel("Introduce Nuevo Precio:");
		GridBagConstraints gbc_lblIntroduceNuevoPrecio = new GridBagConstraints();
		gbc_lblIntroduceNuevoPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntroduceNuevoPrecio.gridx = 1;
		gbc_lblIntroduceNuevoPrecio.gridy = 4;
		add(lblIntroduceNuevoPrecio, gbc_lblIntroduceNuevoPrecio);
		
		txtNuevoPrecio = new JTextField();
		GridBagConstraints gbc_txtNuevoPrecio = new GridBagConstraints();
		gbc_txtNuevoPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtNuevoPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNuevoPrecio.gridx = 2;
		gbc_txtNuevoPrecio.gridy = 4;
		add(txtNuevoPrecio, gbc_txtNuevoPrecio);
		txtNuevoPrecio.setColumns(10);
		
		btnActualizarPrecio = new JButton("Actualizar");
		GridBagConstraints gbc_btnActualizarPrecio = new GridBagConstraints();
		gbc_btnActualizarPrecio.fill = GridBagConstraints.VERTICAL;
		gbc_btnActualizarPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_btnActualizarPrecio.gridx = 2;
		gbc_btnActualizarPrecio.gridy = 6;
		add(btnActualizarPrecio, gbc_btnActualizarPrecio);
		
		JLabel lblMensaje = new JLabel("Mensaje:");
		GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
		gbc_lblMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblMensaje.gridx = 1;
		gbc_lblMensaje.gridy = 7;
		add(lblMensaje, gbc_lblMensaje);
		
		txtMensajeModificar = new JTextField();
		txtMensajeModificar.setEditable(false);
		GridBagConstraints gbc_txtMensajeModificar = new GridBagConstraints();
		gbc_txtMensajeModificar.insets = new Insets(0, 0, 5, 5);
		gbc_txtMensajeModificar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMensajeModificar.gridx = 2;
		gbc_txtMensajeModificar.gridy = 7;
		add(txtMensajeModificar, gbc_txtMensajeModificar);
		txtMensajeModificar.setColumns(10);

	}

	public JTextField getTxtNuevoPrecio() {
		return txtNuevoPrecio;
	}

	public JButton getBtnActualizarPrecio() {
		return btnActualizarPrecio;
	}

	public JTextField getTxtMensajeModificar() {
		return txtMensajeModificar;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
	
	

}
