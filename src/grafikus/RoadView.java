package grafikus;

import nabukodonozor.Program;
import nabukodonozor.Road;

public class RoadView extends CellView{
	//konstruktor
	public RoadView(Road road) {
		cell = road;
	}
	
	public void notifyView(){
		// c�lcella meghat�roz�sa
		int c_x = x*40;
		int c_y = y*40;
		
		// k�p kirajzol�sa
		ImagePanel road = new ImagePanel("pics/road.jpg");
		road.setSize(40, 40);
		road.setLocation(c_x, c_y);
		Program.game.getPField().add(road);
	}
}
