package nabukodonozor;

import java.util.List;

public abstract class Trap extends Element {
	protected int price; //ár
	protected int slow; //lassítás mértéke
	protected List<StoneToTrap> stones; //kövek
	
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
		
		return true;
	}

	//mezore kerulhet-e				PETI
	public boolean accept(Land l) {
		return false;
	}
	
	//hegyre kerulhet-e				PETI
	public boolean accept(Mountain m) {
		return false;
	}
	
	//torony melle kerulhet-e		PETI
	public boolean accept(Tower t) {
		return false;
	}
	
	//csapda melle kerulhet-e		PETI
	public boolean accept(Trap t) {
		return false;
	}
	
	//ellenseg melle kerulhet-e		PETI
	public boolean accept(Enemy e) {
		return true;
	}
	
	//detektor melle kerulhet-e		PETI
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

	//segedmetodus
	protected abstract void act_bridge(StoneToTrap s);
}
