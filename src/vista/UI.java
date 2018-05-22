package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class UI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public UI() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

}
