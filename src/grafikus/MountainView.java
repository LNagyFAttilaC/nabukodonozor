package grafikus;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import nabukodonozor.Mountain;

public class MountainView extends CellView{
	//konstruktor
	public MountainView(Mountain mountain) {
		cell = mountain;
	}
	
	public void notifyView(){
		// c�lcella meghat�roz�sa
		int[] coords = Controller.getCoords(cell);
		
		// k�p kirajzol�sa
		BufferedImage img;
		try {
			img = ImageIO.read(new File("pics/mountain.jpg"));
			ImageIcon icon=new ImageIcon(img);
			/*Graphics g;
			g.drawImage(null, coords[0], coords[1], null);*/
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}