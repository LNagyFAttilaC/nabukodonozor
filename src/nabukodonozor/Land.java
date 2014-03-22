package nabukodonozor;

public class Land extends Cell {

	@Override
	public void addElement(Element e) {
		Skeleton.entry("l", "Land", "addElement", new String[] {"e:Element"});
		e.accept(this);
	}
	
	@Override
	public boolean accept(Tower t) {
		Skeleton.entry("l", "Land", "accept", new String[] {"t:Tower"});
		Skeleton.exit("true");
		return true;
	}

	@Override
	public boolean accept(Enemy e) {
		Skeleton.entry("l", "Land", "accept", new String[] {"e:Enemy"});
		Skeleton.exit("false");
		return false;
	}

	@Override
	public boolean accept(Detector d) {
		Skeleton.entry("l", "Land", "accept", new String[] {"d:Detector"});
		Skeleton.exit("false");
		return false;
	}

	@Override
	public boolean accept(Trap t) {
		Skeleton.entry("l", "Land", "accept", new String[] {"t:Trap"});
		Skeleton.exit("false");
		return false;
	}

}
