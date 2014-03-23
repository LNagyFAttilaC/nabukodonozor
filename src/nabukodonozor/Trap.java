package nabukodonozor;

import java.util.List;

public class Trap extends Element{

	protected int price;
	protected int slow;
	protected List<StoneToTrap> stones;
	
	public boolean accept(Road r){
		Object[] params = {r};
		Skeleton.entry(this, "accept(Road r)", params);
		
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
		Skeleton.entry("t", "Trap", "accept", new String[] {"t:Tower"});
		return false;
	}
	
	public boolean accept(Trap t){
		Skeleton.entry("t", "Trap", "accept", new String[] {"t:Trap"});
		return false;
	}
	
	public boolean accept(Enemy e){
		Skeleton.entry("t", "Trap", "accept", new String[] {"e:Enemy"});
		return false;
	}
	
	public boolean accept(Detector d){
		Skeleton.entry("t", "Trap", "accept", new String[] {"d:Detector"});
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
		Skeleton.entry("t", "Trap", "addStone", new String[] {"s:Stone"});
	}
}
