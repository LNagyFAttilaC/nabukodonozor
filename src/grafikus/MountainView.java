package grafikus;

import nabukodonozor.Mountain;
import nabukodonozor.Program;

public class MountainView extends CellView{
	//konstruktor
	public MountainView(Mountain mountain) {
		cell = mountain;
	}
	
	public void notifyView(){
		// c�lcella meghat�roz�sa
		int[] coords = Controller.getCoords(cell);
		
		// k�p kirajzol�sa
		ImagePanel m = new ImagePanel("pics/mountain.jpg");
		m.setSize(40, 40);
		m.setLocation(coords[0], coords[1]);
		Program.game.add(m);
		Program.game.repaint();
	}
}
