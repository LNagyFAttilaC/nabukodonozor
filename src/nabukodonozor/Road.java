package nabukodonozor;

import javax.lang.model.element.Element;

public class Road extends Cell {
	
	@Override
	public void addElement(Element e) {
		Skeleton.entry("r", "Road", "addElement", new String[] {"e:Element"});
		e.accept(this);
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
