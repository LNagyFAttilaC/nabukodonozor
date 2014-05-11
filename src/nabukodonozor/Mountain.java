package nabukodonozor;

import grafikus.*;

public class Mountain extends Cell {
	//konstruktor
	public Mountain() {
		super();
		view = new MountainView(this);
	}
	
	//uj elem eltarolasa
	public boolean addElement(Element e) {
		return e.accept(this);
	}
	
	//torony melle kerulhet-e
	public boolean accept(Tower t) {
		return false;
	}

	//ellenseg melle kerulhet-e
	public boolean accept(Enemy e) {
		return true;
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
