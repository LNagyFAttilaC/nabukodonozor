package nabukodonozor;

import grafikus.TrapView;

import java.util.ArrayList;
import java.util.List;

public abstract class Trap extends Element {
	protected int price; //ár
	protected int slow; //lassítás mértéke
	protected List<StoneToTrap> stones; //kövek
	protected TrapView view; //megjelenito
	
	//konstruktor
	public Trap() {
		stones  = new ArrayList<StoneToTrap>();
	}
	
	//utra kerulhet-e
	public boolean accept(Road r) {
		List<Element> elements = r.getElements();
		
		//ha mar van ott csapda, akkor ki fog lepni
		for (Element e : elements) {
			if (!(e.accept(this))) {
				return false;
			}
		}
		
		//cella beallitasa
		setCell(r);
		
		//hozzadas
		r.setElement(this);
		
		//mana csokkentese
		Field f = cell.getField();
		f.decreaseMana(price);
		
		view.notifyView();
		
		return true;
	}

	//mezore kerulhet-e
	public boolean accept(Land l) {
		return false;
	}
	
	//hegyre kerulhet-e
	public boolean accept(Mountain m) {
		return false;
	}
	
	//torony melle kerulhet-e
	public boolean accept(Tower t) {
		return false;
	}
	
	//csapda melle kerulhet-e
	public boolean accept(Trap t) {
		return false;
	}
	
	//ellenseg melle kerulhet-e
	public boolean accept(Enemy e) {
		return true;
	}
	
	//detektor melle kerulhet-e
	public boolean accept(Detector d) {
		return true;
	}
	
	//interakcio tundevel
	public void act(Elf e) {
		e.addSpeedItem(slow);
	}
	
	//interakcio emberrel
	public void act(Human h) {
		h.addSpeedItem(slow);
	}
	
	//interakcio torppel
	public void act(Dwarf d) {
		d.addSpeedItem(slow);
	}
	
	//interakcio hobbittal
	public void act(Hobbit h) {
		h.addSpeedItem(slow);
	}
	
	//ko hozzaadasa
	public void addStone(Stone s) {
		s.accept(this);
	}
	
	//ko eltarolasa
	public void setStone(StoneToTrap s) {
		stones.add(s);
	}
	
	//getter: slow
	public int getSlow() {
		return slow;
	}
	
	//setter: slow
	public void setSlow(int s) {
		slow = s;
	}

	public TrapView getView(){
		return view;
	}

	//segedmetodus
	protected abstract void act_bridge(StoneToTrap s);
}
