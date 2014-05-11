package grafikus;

import nabukodonozor.Mountain;
import nabukodonozor.Program;

public class MountainView extends CellView {
	//konstruktor
	public MountainView(Mountain mountain) {
		cell = mountain;
	}
	
	public void notifyView(){
		// célcella meghatározása
		int c_x = x*40;
		int c_y = y*40;
		
		// kép kirajzolása
		ImagePanel mountain = new ImagePanel("pics/mountain.jpg");
		mountain.setSize(40, 40);
		mountain.setLocation(c_x, c_y);
		Program.game.getPField().add(mountain);
	}
}