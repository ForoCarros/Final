package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JInternalFrame;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class UI extends JFrame {

	private BufferedImage img;
	protected JMenuItem mntmAltaArticulo;
	protected JMenuItem mntmConsultaArticulo;
	protected JMenuItem mntmModificacinArticulo;
	protected JMenuItem mntmAltaCliente;
	protected JMenuItem mntmBajaCliente;
	protected JMenuItem mntmAltaPedido;
	protected JPanelBackground contentPane;

	/**
	 * Create the frame.
	 */
	public UI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 426);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArtculo = new JMenu("Art\u00EDculo");
		menuBar.add(mnArtculo);

		mntmAltaArticulo = new JMenuItem("Alta");
		mntmAltaArticulo.setActionCommand("AltaArticulo");
		mntmAltaArticulo.setName("AltaArticulo");
		mnArtculo.add(mntmAltaArticulo);

		mntmConsultaArticulo = new JMenuItem("Consulta");
		mntmConsultaArticulo.setActionCommand("ConsultarArticulo");
		mnArtculo.add(mntmConsultaArticulo);

		mntmModificacinArticulo = new JMenuItem("Modificaci\u00F3n");
		mntmModificacinArticulo.setActionCommand("ModificarArticulo");
		mnArtculo.add(mntmModificacinArticulo);

		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);

		mntmAltaCliente = new JMenuItem("Alta");
		mntmAltaCliente.setActionCommand("AltaCliente");
		mntmAltaCliente.setName("AltaCliente");
		mnCliente.add(mntmAltaCliente);

		mntmBajaCliente = new JMenuItem("Baja");
		mntmBajaCliente.setActionCommand("BajaCliente");
		mntmBajaCliente.setName("BajaCliente");
		mnCliente.add(mntmBajaCliente);

		JMenu mnPedido = new JMenu("Pedido");
		mnPedido.setActionCommand("AltaPedido");
		menuBar.add(mnPedido);

		mntmAltaPedido = new JMenuItem("Alta");
		mntmAltaPedido.setActionCommand("AltaPedido");
		mnPedido.add(mntmAltaPedido);

		contentPane = new JPanelBackground();
		contentPane.setBackground("src/assets/ESTEEM.png");
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
