package nabukodonozor;

import java.util.List;

public abstract class Cell implements Incompatibility {

	private Field field;
	protected List<Cell> neighbours;
	
	public abstract void addElement(Element e);
	
	public void removeElement(Element e) {
		Skeleton.entry("c", "Cell", "removeElement", new String[] {"e:Element"});
	}
	
}
