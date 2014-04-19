package nabukodonozor;

import java.util.List;

public abstract class Trap extends Element {
	protected int price; //�r
	protected int slow; //lass�t�s m�rt�ke
	protected List<StoneToTrap> stones; //k�vek
	
	//utra kerulhet-e
	public boolean accept(Road r) {
		List<Element> elements = r.getElements();
		
		//ha mar van ott csapda, akkor ki fog lepni
		for (Element e : elements){
			if (!(e.accept(this))){
				return false;
			}
		}
		
		//hozzadas
		r.setElement(this);
		setCell(r);
		
		//varazsero csokkentese
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
		return false;
	}
	
	//detektor melle kerulhet-e		PETI
	public boolean accept(Detector d) {
		return false;
	}
	
	//interakcio tundevel
	public void act(Elf e) {
		Object[] params = {e};
		Skeleton.entry(this, "act(Elf h)", params);
		
		e.addSpeedItem(slow);
		
		Skeleton.exit("void");
	}
	
	//interakcio emberrel
	public void act(Human h) {
		Object[] params = {h};
		Skeleton.entry(this, "act(Human h)", params);
		
		h.addSpeedItem(slow);
		
		Skeleton.exit("void");
	}
	
	//interakcio torppel
	public void act(Dwarf d) {
		Object[] params = {d};
		Skeleton.entry(this, "act(Dwarf h)", params);
		
		d.addSpeedItem(slow);
		
		Skeleton.exit("void");
	}
	
	//interakcio hobbittal
	public void act(Hobbit h) {
		Object[] params = {h};
		Skeleton.entry(this, "act(Hobbit h)", params);
		
		h.addSpeedItem(slow);
		
		Skeleton.exit("void");
	}
	
	//ko hozzaadasa
	public void addStone(Stone s) {
		Object[] params = {s};
		Skeleton.entry(this, "addStone(Stone s)", params);
		
		s.accept(this);
		
		Skeleton.exit("void");
	}
	
	//ko eltarolasa
	public void setStone(StoneToTrap s) {
		Object[] params = {s};
		Skeleton.entry(this, "setStone(StoneToTrap s)", params);

		stones.add(s);
		
		Skeleton.exit("void");
	}
	
	//getter: slow
	public int getSlow() {
		Object[] params = {};
		Skeleton.entry(this, "getSlow()", params);
		
		Skeleton.exit("slow");
		
		return slow;
	}
	
	//setter: slow
	public void setSlow(int s) {
		Object[] params = {s};
		Skeleton.entry(this, "setSlow(int s)", params);
		
		slow = s;
		
		Skeleton.exit("void");
	}

	//segedmetodus
	protected abstract void act_bridge(StoneToTrap s);
}
