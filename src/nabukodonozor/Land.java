package nabukodonozor;

import grafikus.*;

public class Land extends Cell {
	private LandView landView;
	
	//konstruktor
	public Land() {
		super();
		landView = new LandView(this);
	}
	
	//uj elem eltarolasa
	public void addElement(Element e) {
		e.accept(this);
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

	@Override
	public void callView() {
		landView.notifyView();
	}
}
