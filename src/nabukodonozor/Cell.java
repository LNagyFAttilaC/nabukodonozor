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
		elements.remove(e);
	}
	
	//getter: elements				PETI
	public List<Element> getElements() {
		return elements;
	}
	
	//uj elem eltarolasa			PETI
	public void setElement(Element e) {
		elements.add(e);
	}
	
	//getter: neighbours
	public List<Cell> getNeighbours() {		
		return neighbours;
	}
	
	//uj szomszed eltarolasa
	public void setNeighbour(Cell c) {
		neighbours.add(c);
	}
	
	//getter: field
	public Field getField() {
		return field;
	}
	
	//setter: field
	public void setField(Field f){
		field = f;
	}
}
