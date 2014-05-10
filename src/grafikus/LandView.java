package grafikus;

import nabukodonozor.Land;

public class LandView extends CellView{
	//konstruktor
	public LandView(Land land) {
		cell = land;
	}
	
	public void notifyView(){
		// célcella meghatározása
		Controller.getCoords(cell);
		// kép kirajzolása
		
	}
	
}
