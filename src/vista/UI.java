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

public class UI extends JFrame {

	private JPanel contentPane;
	private BufferedImage img;

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

		JMenuItem mntmAltaArticulo = new JMenuItem("Alta");
		mntmAltaArticulo.setActionCommand("AltaArticulo");
		mntmAltaArticulo.setName("AltaArticulo");
		mnArtculo.add(mntmAltaArticulo);

		JMenuItem mntmConsultaArticulo = new JMenuItem("Consulta");
		mnArtculo.add(mntmConsultaArticulo);

		JMenuItem mntmModificacinArticulo = new JMenuItem("Modificaci\u00F3n");
		mnArtculo.add(mntmModificacinArticulo);

		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);

		JMenuItem mntmAltaCliente = new JMenuItem("Alta");
		mntmAltaCliente.setActionCommand("AltaCliente");
		mntmAltaCliente.setName("AltaCliente");
		mnCliente.add(mntmAltaCliente);

		JMenuItem mntmBajaCliente = new JMenuItem("Baja");
		mntmBajaCliente.setActionCommand("BajaCliente");
		mntmBajaCliente.setName("BajaCliente");
		mnCliente.add(mntmBajaCliente);

		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);

		JMenuItem mntmAltaPedido = new JMenuItem("Alta");
		mnPedido.add(mntmAltaPedido);

		JPanelBackground contentPane = new JPanelBackground();
		contentPane.setBackground("C:/Users/Adsan/git/Final/src/assets/ESTEEM.png");
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

}
