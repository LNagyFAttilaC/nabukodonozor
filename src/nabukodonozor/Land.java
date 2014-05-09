package nabukodonozor;

import grafikus.*;

public class Land extends Cell {
	private LandView landView;
	
	//uj elem eltarolasa
	public void addElement(Element e) {
		e.accept(this);
		landView.notifyView();
	}
	
	//torony melle kerulhet-e
	public boolean accept(Tower t) {
		return true;
	}

	//ellenseg melle kerulhet-e
	public boolean accept(Enemy e) {
		return false;
	}

	//detektor melle kerulhet-e
	public boolean accept(Detector d) {
		return false;
	}

	//csapda melle kerulhet-e
	public boolean accept(Trap t) {
		return false;
	}
}
