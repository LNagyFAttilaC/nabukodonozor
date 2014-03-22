package nabukodonozor;

public class Road extends Cell {
	
	@Override
	public void addElement(Element e) {
		Object[] params = {e};
		Skeleton.entry(this, "addElement(Element e)", params);
		
		e.accept(this);
		
		Skeleton.exit("void");
	}
	
	@Override
	public boolean accept(Tower t) {
		Skeleton.entry("r", "Road", "accept", new String[] {"t:Tower"});
		Skeleton.exit("false");
		return false;
	}

	@Override
	public boolean accept(Enemy e) {
		Skeleton.entry("r", "Road", "accept", new String[] {"e:Enemy"});
		Skeleton.exit("true");
		return true;
	}

	@Override
	public boolean accept(Detector d) {
		Skeleton.entry("r", "Road", "accept", new String[] {"d:Detector"});
		Skeleton.exit("true");
		return true;
	}

	@Override
	public boolean accept(Trap t) {
		Skeleton.entry("r", "Road", "accept", new String[] {"t:Trap"});
		Skeleton.exit("true");
		return true;
	}
}
