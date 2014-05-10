package grafikus;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Object;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import nabukodonozor.Game;

public class MountainView extends CellView{

	public void notifyView(){
		// c�lcella meghat�roz�sa
		int[] coords = Controller.getCoords(cell);
		// k�p kirajzol�sa
		ImagePanel icon = new ImagePanel("pic/mountain_p.jpg");
		icon.setSize(40,40);
		icon.setLocation(coords[0]*40, coords[1]*40);
		// hogy adom hozz� a Game.field-hez?
	}
	
}
