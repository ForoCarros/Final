package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class AltaPedido extends JPanel {
	protected JTextField txtNumPedido;
	protected JComboBox comboPedido;
	protected JComboBox comboArticulos;
	protected JTextArea txtLineasPedido;
	protected JTextField txtPrecioFinal;
	protected JTextField txtMensajePedido;
	protected JTextField txtCantidad;

	/**
	 * Create the panel.
	 */
	public AltaPedido() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblCrearPedido = new JLabel("CREAR PEDIDO");
		lblCrearPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearPedido.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblCrearPedido.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblCrearPedido = new GridBagConstraints();
		gbc_lblCrearPedido.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCrearPedido.gridwidth = 3;
		gbc_lblCrearPedido.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrearPedido.gridx = 1;
		gbc_lblCrearPedido.gridy = 1;
		add(lblCrearPedido, gbc_lblCrearPedido);
		
		JLabel lblNPedido = new JLabel("N\u00BA Pedido");
		lblNPedido.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNPedido = new GridBagConstraints();
		gbc_lblNPedido.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNPedido.insets = new Insets(0, 0, 5, 5);
		gbc_lblNPedido.gridx = 1;
		gbc_lblNPedido.gridy = 3;
		add(lblNPedido, gbc_lblNPedido);
		
		txtNumPedido = new JTextField();
		txtNumPedido.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtNumPedido = new GridBagConstraints();
		gbc_txtNumPedido.gridwidth = 2;
		gbc_txtNumPedido.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumPedido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumPedido.gridx = 2;
		gbc_txtNumPedido.gridy = 3;
		add(txtNumPedido, gbc_txtNumPedido);
		txtNumPedido.setColumns(10);
		
		JLabel lblCliente = new JLabel("Elige Cliente:");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 4;
		add(lblCliente, gbc_lblCliente);
		
		comboPedido = new JComboBox();
		GridBagConstraints gbc_comboPedido = new GridBagConstraints();
		gbc_comboPedido.gridwidth = 2;
		gbc_comboPedido.insets = new Insets(0, 0, 5, 5);
		gbc_comboPedido.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboPedido.gridx = 2;
		gbc_comboPedido.gridy = 4;
		add(comboPedido, gbc_comboPedido);
		
		comboArticulos = new JComboBox();
		GridBagConstraints gbc_comboArticulos = new GridBagConstraints();
		gbc_comboArticulos.insets = new Insets(0, 0, 5, 5);
		gbc_comboArticulos.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboArticulos.gridx = 1;
		gbc_comboArticulos.gridy = 5;
		add(comboArticulos, gbc_comboArticulos);
		
		JLabel lblCantidad = new JLabel("Inserta Cantidad:");
		GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.anchor = GridBagConstraints.EAST;
		gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad.gridx = 2;
		gbc_lblCantidad.gridy = 5;
		add(lblCantidad, gbc_lblCantidad);
		
		txtCantidad = new JTextField();
		GridBagConstraints gbc_txtCantidad = new GridBagConstraints();
		gbc_txtCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_txtCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCantidad.gridx = 3;
		gbc_txtCantidad.gridy = 5;
		add(txtCantidad, gbc_txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnAnadirArticulo = new JButton("A\u00F1adir");
		GridBagConstraints gbc_btnAnadirArticulo = new GridBagConstraints();
		gbc_btnAnadirArticulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAnadirArticulo.gridwidth = 3;
		gbc_btnAnadirArticulo.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnadirArticulo.gridx = 1;
		gbc_btnAnadirArticulo.gridy = 6;
		add(btnAnadirArticulo, gbc_btnAnadirArticulo);
		
		txtLineasPedido = new JTextArea();
		GridBagConstraints gbc_txtLineasPedido = new GridBagConstraints();
		gbc_txtLineasPedido.gridwidth = 3;
		gbc_txtLineasPedido.insets = new Insets(0, 0, 5, 5);
		gbc_txtLineasPedido.fill = GridBagConstraints.BOTH;
		gbc_txtLineasPedido.gridx = 1;
		gbc_txtLineasPedido.gridy = 7;
		add(txtLineasPedido, gbc_txtLineasPedido);
		
		JLabel lblPrecioTotal = new JLabel("Precio Total:");
		GridBagConstraints gbc_lblPrecioTotal = new GridBagConstraints();
		gbc_lblPrecioTotal.anchor = GridBagConstraints.EAST;
		gbc_lblPrecioTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioTotal.gridx = 2;
		gbc_lblPrecioTotal.gridy = 8;
		add(lblPrecioTotal, gbc_lblPrecioTotal);
		
		txtPrecioFinal = new JTextField();
		txtPrecioFinal.setEditable(false);
		txtPrecioFinal.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtPrecioFinal = new GridBagConstraints();
		gbc_txtPrecioFinal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecioFinal.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecioFinal.gridx = 3;
		gbc_txtPrecioFinal.gridy = 8;
		add(txtPrecioFinal, gbc_txtPrecioFinal);
		txtPrecioFinal.setColumns(10);
		
		JLabel lblMensaje = new JLabel("Mensaje:");
		GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
		gbc_lblMensaje.anchor = GridBagConstraints.EAST;
		gbc_lblMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblMensaje.gridx = 1;
		gbc_lblMensaje.gridy = 9;
		add(lblMensaje, gbc_lblMensaje);
		
		txtMensajePedido = new JTextField();
		txtMensajePedido.setEditable(false);
		txtMensajePedido.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtMensajePedido = new GridBagConstraints();
		gbc_txtMensajePedido.gridwidth = 2;
		gbc_txtMensajePedido.insets = new Insets(0, 0, 5, 5);
		gbc_txtMensajePedido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMensajePedido.gridx = 2;
		gbc_txtMensajePedido.gridy = 9;
		add(txtMensajePedido, gbc_txtMensajePedido);
		txtMensajePedido.setColumns(10);

	}

}
