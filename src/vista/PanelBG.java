package vista;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelBG extends JPanel {
	private Image imagen;
	
	public PanelBG(String file) {
		try {
			this.imagen = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imagen, 0, 0, this);
	}

}
