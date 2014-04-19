package nabukodonozor;

public class Road extends Cell {
	//uj elem hozzaadasa			PETI
	public void addElement(Element e) {
		boolean isAccepted = e.accept(this);
		if(isAccepted){
			addElement(e);
		}
	}
	
	//torony melle kerulhet-e		PETI
	public boolean accept(Tower t) {
		return false;
	}

	//ellenseg melle kerulhet-e
	public boolean accept(Enemy e) {
		Object[] params = {e};
		Skeleton.entry(this, "accept(Enemy e)", params);
		
		Skeleton.exit("true");
		
		return true;
	}

	//detektor melle kerulhet-e
	public boolean accept(Detector d) {
		this.addElement(d);
		
		return true;
	}

	//csapda melle kerulhet-e
	public boolean accept(Trap t) {
		return true;
	}
}
