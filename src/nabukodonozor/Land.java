package nabukodonozor;

public class Land extends Cell {
	//uj elem eltarolasa
	public void addElement(Element e) {
		e.accept(this);
	}
	
	//torony melle kerulhet-e		PETI
	public boolean accept(Tower t) {
		return true;
	}

	//ellenseg melle kerulhet-e
	public boolean accept(Enemy e) {
		return false;
	}

	//detektor melle kerulhet-e		PETI
	public boolean accept(Detector d) {
		return false;
	}

	//csapda melle kerulhet-e		PETI
	public boolean accept(Trap t) {
		return false;
	}

}
