package nabukodonozor;

public class Land extends Cell {

	@Override
	public void addElement(Element e) {
		Object[] params = {e};
		Skeleton.entry(this, "addElement(Element e)", params);
		
		boolean isAccepted = e.accept(this);
		if (isAccepted) {
			Timer timer = field.getTimer();			
			timer.addActive((Active)e);	// Itt már tudjuk, hogy ez az Element egy Active interfészû Tower.
		}
		
		Skeleton.exit("void");
	}
	
	@Override
	public boolean accept(Tower t) {
		Object[] params = {t};
		Skeleton.entry(this, "accept(Tower t)", params);
		Skeleton.exit("true");
		return true;
	}

	@Override
	public boolean accept(Enemy e) {
		Object[] params = {e};
		Skeleton.entry(this, "accept(Enemy e)", params);
		Skeleton.exit("false");
		return false;
	}

	@Override
	public boolean accept(Detector d) {
		Object[] params = {d};
		Skeleton.entry(this, "accept(Detector d)", params);
		Skeleton.exit("false");
		return false;
	}

	@Override
	public boolean accept(Trap t) {
		Object[] params = {t};
		Skeleton.entry(this, "accept(Trap t)", params);
		Skeleton.exit("false");
		return false;
	}

}
