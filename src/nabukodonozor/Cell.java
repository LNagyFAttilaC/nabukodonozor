package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public abstract class Cell implements Incompatibility {
	protected Field field; //palya
	protected List<Cell> neighbours; //szomszed cellak
	protected List<Element> elements; //tartalmazott elemek
	
	//konstruktor
	public Cell() {
		field		= new Field();
		neighbours	= new ArrayList<Cell>();
		elements	= new ArrayList<Element>();	
	}

	//elem hozzaadasa
	public abstract void addElement(Element e);
	
	//elem eltavolitasa
	public void removeElement(Element e) {
		Object[] params = {e};
		Skeleton.entry(this, "removeElement(Element e)", params);
		
		Skeleton.exit("void");
	}
	
	//getter: elements
	public List<Element> getElements() {
		Object[] params = {};
		Skeleton.entry(this, "getElements()", params);
		
		Skeleton.exit("elements");
		
		return elements;
	}
	
	//uj elem eltarolasa
	public void setElement(Element e) {
		Object[] params = {e};
		Skeleton.entry(this, "setElement(Element e)", params);
		
		elements.add(e);
		
		Skeleton.exit("void");
	}
	
	//getter: neighbours
	public List<Cell> getNeighbours() {		
		//Object[] params = {};
		//Skeleton.entry(this, "getNeighbours()", params);
		
		//Skeleton.exit("neighbours");
		
		return neighbours;
	}
	
	//uj szomszed eltarolasa
	public void setNeighbour(Cell c) {
		Object[] params = {c};
		Skeleton.entry(this, "setNeighbour(Cell c)", params);

		neighbours.add(c);
		
		Skeleton.exit("void");
	}
	
	//getter: field
	public Field getField() {
		Object[] params = {};
		Skeleton.entry(this, "getField()", params);
		
		Skeleton.exit("field");
		
		return field;
	}
	
	//setter: field
	public void setField(Field f){
		field = f;
	}
}
