package nabukodonozor;

public class Road extends Cell {
	//uj elem hozzaadasa
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
		addElement(d);
		
		return true;
	}

	//csapda melle kerulhet-e
	public boolean accept(Trap t) {
		return true;
	}
}
