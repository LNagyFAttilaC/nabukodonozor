package nabukodonozor;

import grafikus.*;

public class Mountain extends Cell {
	private MountainView mountainView;
	
	//uj elem eltarolasa
	public void addElement(Element e) {
		e.accept(this);
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

	@Override
	public void callView() {
		mountainView.notifyView();
	}
}
