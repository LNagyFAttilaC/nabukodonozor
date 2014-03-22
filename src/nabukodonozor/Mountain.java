package nabukodonozor;

public class Mountain extends Cell {

	@Override
	public void addElement(Element e) {
		Skeleton.entry("m", "Mountain", "addElement", new String[] {"e:Element"});
		e.accept(this);
	}
	
	@Override
	public boolean accept(Tower t) {
		Skeleton.entry("m", "Mountain", "accept", new String[] {"t:Tower"});
		Skeleton.exit("false");
		return false;
	}

	@Override
	public boolean accept(Enemy e) {
		Skeleton.entry("m", "Mountain", "accept", new String[] {"e:Enemy"});
		Skeleton.exit("false");
		return true;
	}

	@Override
	public boolean accept(Detector d) {
		Skeleton.entry("m", "Mountain", "accept", new String[] {"d:Detector"});
		Skeleton.exit("false");
		return false;
	}

	@Override
	public boolean accept(Trap t) {
		Skeleton.entry("m", "Mountain", "accept", new String[] {"t:Trap"});
		Skeleton.exit("false");
		return false;
	}	

}
