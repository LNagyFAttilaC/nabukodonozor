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
		// célcella meghatározása
		int[] coords = Controller.getCoords(cell);
		// kép kirajzolása
		ImagePanel icon = new ImagePanel("pic/mountain_p.jpg");
		icon.setSize(40,40);
		icon.setLocation(coords[0]*40, coords[1]*40);
		// hogy adom hozzá a Game.field-hez?
	}
	
}
