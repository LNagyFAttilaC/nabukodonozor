package grafikus;

import nabukodonozor.Land;

public class LandView extends CellView{
	//konstruktor
	public LandView(Land land) {
		cell = land;
	}
	
	public void notifyView(){
		// c�lcella meghat�roz�sa
		Controller.getCoords(cell);
		// k�p kirajzol�sa
		
	}
	
}
