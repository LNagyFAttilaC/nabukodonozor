package grafikus;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Object;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MountainView extends CellView{

	public void notifyView(){
		// célcella meghatározása
		int[] coords = Controller.getCoords(cell);
		// kép kirajzolása
		BufferedImage img;
		try {
			img = ImageIO.read(new File("pic//mountain_p.jpg"));
			ImageIcon icon=new ImageIcon(img);
			/*Graphics g;
			g.drawImage(null, coords[0], coords[1], null);*/
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
