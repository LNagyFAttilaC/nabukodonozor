package grafikus;

import nabukodonozor.Land;
import nabukodonozor.Program;

public class LandView extends CellView{
	//konstruktor
	public LandView(Land land) {
		cell = land;
	}
	
	public void notifyView(){
		// c�lcella meghat�roz�sa
		int c_x = x*40;
		int c_y = y*40;
		
		// k�p kirajzol�sa
		ImagePanel land = new ImagePanel("pics/land.png");
		land.setSize(40, 40);
		land.setLocation(c_x, c_y);
		Program.game.getPField().add(land);
	}
}
