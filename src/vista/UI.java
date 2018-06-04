package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JInternalFrame;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Window;
import java.awt.image.BufferedImage;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.BorderLayout;

/**
 * 
 * @author Pablo
 *
 */
public class UI extends JFrame {

	private BufferedImage img;
	protected JMenuItem mntmAltaArticulo;
	protected JMenuItem mntmConsultaArticulo;
	protected JMenuItem mntmModificacinArticulo;
	protected JMenuItem mntmAltaCliente;
	protected JMenuItem mntmBajaCliente;
	protected JMenuItem mntmAltaPedido;
	protected JPanelBackground contentPane;
	protected AltaArticulo panelAltaArticulo;
	protected ConsultaArticulo panelConsultarArticulo;
	protected ModificarArticulo panelModificarArticulo;
	protected AltaCliente panelAltaCliente;
	protected BajaCliente panelBajaCliente;
	protected AltaPedido panelAltaPedido;
	protected ConsultaCliente panelConsultarCliente;

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

		crearPaneles();
		crearVentanas();
	}

	private void crearPaneles() {
		this.panelAltaArticulo = new AltaArticulo();
		this.panelConsultarArticulo = new ConsultaArticulo();
		this.panelModificarArticulo = new ModificarArticulo();
		this.panelAltaCliente = new AltaCliente();
		this.panelBajaCliente = new BajaCliente();
		this.panelAltaPedido = new AltaPedido();
		this.panelConsultarCliente = new ConsultaCliente();
	}

	private void crearVentanas() {
		JInternalFrame frameAltaArticulo = new JInternalFrame("Alta artículo.");
		frameAltaArticulo.setClosable(true);
		frameAltaArticulo.setResizable(true);
		frameAltaArticulo.setMaximizable(true);
		frameAltaArticulo.setBounds(328, 224, 55, 34);
		frameAltaArticulo.setName("Alta articulo");
		contentPane.add(frameAltaArticulo);
		frameAltaArticulo.getContentPane().add(this.panelAltaArticulo);
		frameAltaArticulo.pack();

		JInternalFrame frameConsultaArticulo = new JInternalFrame("Consultar artículo.");
		frameConsultaArticulo.setClosable(true);
		frameConsultaArticulo.setResizable(true);
		frameConsultaArticulo.setMaximizable(true);
		frameConsultaArticulo.setBounds(175, 0, 55, 34);
		frameConsultaArticulo.setName("Consultar articulo");
		contentPane.add(frameConsultaArticulo);
		frameConsultaArticulo.getContentPane().add(this.panelConsultarArticulo);
		frameConsultaArticulo.pack();

		JInternalFrame frameModificacion = new JInternalFrame("Modificar artículo.");
		frameModificacion.setClosable(true);
		frameModificacion.setResizable(true);
		frameModificacion.setMaximizable(true);
		frameModificacion.setBounds(214, 113, 55, 34);
		frameModificacion.setName("Modificar articulo");
		contentPane.add(frameModificacion);
		frameModificacion.getContentPane().add(this.panelModificarArticulo);
		frameModificacion.pack();

		JInternalFrame frameAltaCliente = new JInternalFrame("Alta cliente.");
		frameAltaCliente.setClosable(true);
		frameAltaCliente.setResizable(true);
		frameAltaCliente.setMaximizable(true);
		frameAltaCliente.setBounds(235, 0, 55, 34);
		frameAltaCliente.setName("Alta cliente");
		contentPane.add(frameAltaCliente);
		frameAltaCliente.getContentPane().add(this.panelAltaCliente);
		frameAltaCliente.pack();

		JInternalFrame frameBajCliente = new JInternalFrame("Baja cliente.");
		frameBajCliente.setClosable(true);
		frameBajCliente.setResizable(true);
		frameBajCliente.setMaximizable(true);
		frameBajCliente.setBounds(0, 0, 55, 34);
		frameBajCliente.setName("Baja cliente");
		contentPane.add(frameBajCliente);
		frameBajCliente.getContentPane().add(this.panelBajaCliente);
		frameBajCliente.pack();

		JInternalFrame frameAltaPedido = new JInternalFrame("Alta pedido.");
		frameAltaPedido.setClosable(true);
		frameAltaPedido.setResizable(true);
		frameAltaPedido.setMaximizable(true);
		frameAltaPedido.setBounds(0, 0, 55, 34);
		frameAltaPedido.setName("Alta pedido");
		contentPane.add(frameAltaPedido);
		frameAltaPedido.getContentPane().add(this.panelAltaPedido);
		frameAltaPedido.pack();
		
//		JInternalFrame frameConsultaCliente = new JInternalFrame("Consulta Cliente.");
//		frameConsultaCliente.setClosable(true);
//		frameConsultaCliente.setResizable(true);
//		frameConsultaCliente.setMaximizable(true);
//		frameConsultaCliente.setBounds(0,0,55,34);
//		frameConsultaCliente.setName("Consulta Cliente");
//		contentPane.add(frameConsultaCliente);
//		frameConsultaCliente.getContentPane().add(this.panelConsultarCliente);
//		frameConsultaArticulo.pack();
	}

	public AltaArticulo getPanelAltaArticulo() {
		return panelAltaArticulo;
	}

	public ConsultaArticulo getPanelConsultarArticulo() {
		return panelConsultarArticulo;
	}

	public ModificarArticulo getPanelModificarArticulo() {
		return panelModificarArticulo;
	}

	public AltaCliente getPanelAltaCliente() {
		return panelAltaCliente;
	}

	public BajaCliente getPanelBajaCliente() {
		return panelBajaCliente;
	}

	public AltaPedido getPanelAltaPedido() {
		return panelAltaPedido;
	}
	
	public ConsultaCliente getPanelConsultarCliente() {
		return panelConsultarCliente;
	}

}
