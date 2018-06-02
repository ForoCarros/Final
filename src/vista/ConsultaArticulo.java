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
import javax.swing.SwingConstants;

public class ConsultaArticulo extends JPanel {
	protected JComboBox comboArticulos;
	protected JTextField txtDescripcion;
	protected JTextField txtPrecioActual;
	protected JButton btnBuscar;

	/**
	 * Create the panel.
	 */
	public ConsultaArticulo() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblConsultarArticulo = new JLabel("CONSULTAR ARTICULO");
		lblConsultarArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarArticulo.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblConsultarArticulo.setFont(new Font("Century", Font.BOLD, 25));
		GridBagConstraints gbc_lblConsultarArticulo = new GridBagConstraints();
		gbc_lblConsultarArticulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblConsultarArticulo.gridwidth = 3;
		gbc_lblConsultarArticulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblConsultarArticulo.gridx = 1;
		gbc_lblConsultarArticulo.gridy = 1;
		add(lblConsultarArticulo, gbc_lblConsultarArticulo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		add(lblNombre, gbc_lblNombre);
		
		comboArticulos = new JComboBox();
		GridBagConstraints gbc_comboArticulos = new GridBagConstraints();
		gbc_comboArticulos.gridwidth = 2;
		gbc_comboArticulos.insets = new Insets(0, 0, 5, 5);
		gbc_comboArticulos.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboArticulos.gridx = 2;
		gbc_comboArticulos.gridy = 3;
		add(comboArticulos, gbc_comboArticulos);
		
		btnBuscar = new JButton("BUSCAR");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.gridwidth = 3;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 5;
		add(btnBuscar, gbc_btnBuscar);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 6;
		add(lblDescripcion, gbc_lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.gridwidth = 2;
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescripcion.gridx = 2;
		gbc_txtDescripcion.gridy = 6;
		add(txtDescripcion, gbc_txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblPrecioActual = new JLabel("Precio Actual:");
		lblPrecioActual.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblPrecioActual = new GridBagConstraints();
		gbc_lblPrecioActual.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPrecioActual.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioActual.gridx = 1;
		gbc_lblPrecioActual.gridy = 7;
		add(lblPrecioActual, gbc_lblPrecioActual);
		
		txtPrecioActual = new JTextField();
		txtPrecioActual.setEditable(false);
		GridBagConstraints gbc_txtPrecioActual = new GridBagConstraints();
		gbc_txtPrecioActual.gridwidth = 2;
		gbc_txtPrecioActual.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecioActual.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecioActual.gridx = 2;
		gbc_txtPrecioActual.gridy = 7;
		add(txtPrecioActual, gbc_txtPrecioActual);
		txtPrecioActual.setColumns(10);

	}

	public JComboBox getComboArticulos() {
		return comboArticulos;
	}

	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}

	public JTextField getTxtPrecioActual() {
		return txtPrecioActual;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	
	

}
