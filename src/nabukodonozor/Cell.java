package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public abstract class Cell implements Incompatibility {

	private Field field;
	protected List<Cell> neighbours;
	protected List<Element> elements;
	
	public Cell() {
		field		= new Field();
		neighbours	= new ArrayList<Cell>();
		elements	= new ArrayList<Element>();
	}
	
	public List<Cell> getNeighbours() {
		return neighbours;
	}
	

	public void setNeighbour(Cell c) {
		neighbours.add(c);
	}
	
	public List<Element> getElements() {
		Object[] params = {};
		Skeleton.entry(this, "getElements()", params);
		
		Skeleton.exit("elements");
		
		return elements;
	}
	
	public void setElement(Element e) {
		Object[] params = {e};
		Skeleton.entry(this, "setElement(Element e)", params);
		
		elements.add(e);
		
		Skeleton.exit("void");
	}
	
	public abstract void addElement(Element e);
	
	public void removeElement(Element e) {
		Object[] params = {e};
		Skeleton.entry(this, "removeElement(Element e)", params);
	}
	
}
