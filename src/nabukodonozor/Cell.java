package nabukodonozor;

import grafikus.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Cell implements Incompatibility {
	protected Field field; //palya
	protected List<Cell> neighbours; //szomszed cellak
	protected List<Element> elements; //tartalmazott elemek
	protected CellView view; //megjelenito
	
	//konstruktor
	public Cell() {	
		neighbours	= new ArrayList<Cell>();
		elements	= new ArrayList<Element>();	
	}

	//elem hozzaadasa
	public abstract boolean addElement(Element e);
	
	//elem eltavolitasa
	public void removeElement(Element e) {
		if (elements.contains(e)) {
			elements.remove(e);
		}
	}
	
	//getter: elements
	public List<Element> getElements() {
		return elements;
	}
	
	//uj elem eltarolasa
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

	public CellView getView(){
		return view;
	}
	
	public abstract void callView();
}
