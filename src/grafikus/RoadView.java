package grafikus;

import nabukodonozor.Road;

public class RoadView extends CellView{
	//konstruktor
	public RoadView(Road road) {
		cell = road;
	}
	
	public void notifyView(){
		// c�lcella meghat�roz�sa
		Controller.getCoords(cell);
		// k�p kirajzol�sa
		
	}
	
}
