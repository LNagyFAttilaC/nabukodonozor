package nabukodonozor;

import java.util.List;

public abstract class Trap extends Element {
	protected int price; //ár
	protected int slow; //lassítás mértéke
	protected List<StoneToTrap> stones; //kövek
	
	//utra kerulhet-e
	public boolean accept(Road r) {
		Object[] params = {r};
		Skeleton.entry(this, "accept(Road r)", params);
		
		List<Element> elements = r.getElements();
		
		//ha mar van ott csapda, akkor ki fog lepni
		for (Element e : elements){
			if (!(e.accept(this))){
				Skeleton.exit("false");
				
				return false;
			}
		}
		
		//hozzadas
		r.setElement(this);
		setCell(r);
		
		//varazsero csokkentese
		Field f = cell.getField();
		f.decreaseMana(price);
		
		Skeleton.exit("true");
		
		return true;
	}

	//mezore kerulhet-e
	public boolean accept(Land l) {
		Object[] params = {l};
		Skeleton.entry(this, "accept(Land l)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	//hegyre kerulhet-e
	public boolean accept(Mountain m) {
		Object[] params = {m};
		Skeleton.entry(this, "accept(Mountain m)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	//torony melle kerulhet-e
	public boolean accept(Tower t) {
		Object[] params = {t};
		Skeleton.entry(this, "accept(Tower t)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	//csapda melle kerulhet-e
	public boolean accept(Trap t) {
		Object[] params = {t};
		Skeleton.entry(this, "accept(Trap t)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	//ellenseg melle kerulhet-e
	public boolean accept(Enemy e) {
		Object[] params = {e};
		Skeleton.entry(this, "accept(Enemy e)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	//detektor melle kerulhet-e
	public boolean accept(Detector d) {
		Object[] params = {d};
		Skeleton.entry(this, "accept(Detector d)", params);
		
		Skeleton.exit("false");
		
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
	
	//ko eltarolasa
	public void setStone(StoneToTrap s) {
		Object[] params = {s};
		Skeleton.entry(this, "setStone(Stone s)", params);

		stones.add(s);
		
		Skeleton.exit("void");
	}

	//segedmetodus
	protected abstract void act_bridge(StoneToTrap s);
}
