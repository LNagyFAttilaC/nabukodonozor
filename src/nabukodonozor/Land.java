package nabukodonozor;

import grafikus.*;

public class Land extends Cell {
	//konstruktor
	public Land() {
		super();
		view = new LandView(this);
	}
	
	//uj elem eltarolasa
	public boolean addElement(Element e) {
		return e.accept(this);
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

	public CellView getView() {
		return view;
	}

	public void callView() {
		view.notifyView();
	}
}
