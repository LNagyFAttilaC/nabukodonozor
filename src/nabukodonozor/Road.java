package nabukodonozor;

public class Road extends Cell {
	//uj elem hozzaadasa
	public void addElement(Element e) {
		Object[] params = {e};
		Skeleton.entry(this, "addElement(Element e)", params);
		
		e.accept(this);
		
		Skeleton.exit("void");
	}
	
	//torony melle kerulhet-e
	public boolean accept(Tower t) {
		Object[] params = {t};
		Skeleton.entry(this, "accept(Tower t)", params);
		
		Skeleton.exit("false");
		
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
		Object[] params = {d};
		Skeleton.entry(this, "accept(Detector d)", params);
		
		Skeleton.exit("true");
		
		return true;
	}

	//csapda melle kerulhet-e
	public boolean accept(Trap t) {
		Object[] params = {t};
		Skeleton.entry(this, "accept(Trap t)", params);
		
		Skeleton.exit("true");
		
		return true;
	}
}
