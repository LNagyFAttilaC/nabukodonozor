package nabukodonozor;

import java.util.List;

public abstract class Trap extends Element{

	protected int price;
	protected int slow;
	protected List<StoneToTrap> stones;
	
	public boolean accept(Road r){
		Object[] params = {r};
		Skeleton.entry(this, "accept(Road r)", params);
		
		List<Element> elements = r.getElements();
		
		for (Element e : elements){
			if (!(e.accept(this))){
				Skeleton.exit("false");
				return false;
			}
		}
		
		r.setElement(this);
		setCell(r);
		
		Field f = cell.getField();
		f.decreaseMana(price);
		
		Skeleton.exit("true");
		
		return true;
	}

	public boolean accept(Land l){
		Object[] params = {l};
		Skeleton.entry(this, "accept(Land l)", params);
		
		Skeleton.exit("false");
		return false;
	}
	
	public boolean accept(Mountain m){
		Object[] params = {m};
		Skeleton.entry(this, "accept(Mountain m)", params);
		
		Skeleton.exit("false");
		return false;
	}
	
	public boolean accept(Tower t){
		Object[] params = {t};
		Skeleton.entry(this, "accept(Tower t)", params);
		return false;
	}
	
	public boolean accept(Trap t){
		Object[] params = {t};
		Skeleton.entry(this, "accept(Trap t)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	public boolean accept(Enemy e){
		Object[] params = {e};
		Skeleton.entry(this, "accept(Enemy e)", params);
		return false;
	}
	
	public boolean accept(Detector d){
		Object[] params = {d};
		Skeleton.entry(this, "accept(Detector d)", params);
		return false;
	}
	
	public void act(Elf e){
		Object[] params = {e};
		Skeleton.entry(this, "act(Elf h)", params);
		
		e.addSpeedItem(slow);
		
		Skeleton.exit("void");
	}
	
	public void act(Human h){
		Object[] params = {h};
		Skeleton.entry(this, "act(Human h)", params);
		
		h.addSpeedItem(slow);
		
		Skeleton.exit("void");
	}
	
	public void act(Dwarf d){
		Object[] params = {d};
		Skeleton.entry(this, "act(Dwarf h)", params);
		
		d.addSpeedItem(slow);
		
		Skeleton.exit("void");
	}
	
	public void act(Hobbit h){
		Object[] params = {h};
		Skeleton.entry(this, "act(Hobbit h)", params);
		
		h.addSpeedItem(slow);
		
		Skeleton.exit("void");
	}
	
	public void addStone(Stone s){
		Object[] params = {s};
		Skeleton.entry(this, "addStone(Stone s)", params);
		
		s.accept(this);
		
		Skeleton.exit("void");
	}
	
	public int getSlow(){
		Object[] params = {};
		Skeleton.entry(this, "getSlow()", params);
		
		Skeleton.exit("slow");
		return slow;
	}
	
	public void setSlow(int s){
		Object[] params = {s};
		Skeleton.entry(this, "setSlow(int s)", params);
		
		slow = s;
		
		Skeleton.exit("void");
		
	}
	
	public void setStone(StoneToTrap s){
		Object[] params = {s};
		Skeleton.entry(this, "setStone(Stone s)", params);

		stones.add(s);
		Skeleton.exit("void");
	}

	protected abstract void act_bridge(StoneToTrap s);
}
