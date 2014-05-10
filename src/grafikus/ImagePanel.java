package grafikus;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image;
	
	public ImagePanel(String image) {
		this.image = new ImageIcon(image).getImage();
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}
}