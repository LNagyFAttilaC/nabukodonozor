package grafikus;

import java.awt.Image;

import javax.swing.ImageIcon;

import nabukodonozor.Mountain;
import nabukodonozor.Program;

public class MountainView extends CellView{
	//konstruktor
	public MountainView(Mountain mountain) {
		cell = mountain;
	}
	
	public void notifyView(){
		// célcella meghatározása
		int[] coords = Controller.getCoords(cell);
		
		// kép kirajzolása
		Image image = new ImageIcon("pics/mountain.jpg").getImage();
		Program.game.getGraphics().drawImage(image, coords[0], coords[1], null);
	}
}
