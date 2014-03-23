package nabukodonozor;

import java.util.List;

public class Trap extends Element{

	private int price = 0;
	private List<StoneToTrap> stones;
	
	public boolean accept(Road r){
		Object[] params = {r};
		Skeleton.entry(this, "accept(Road r)", params);
		
		List<Element> elements = r.getElements();
		
		for (Element e : elements) {
			e.accept(this);
		}
		
		r.setElement(this);
		setCell(r);
		Field f = cell.getField();
		f.decreaseMana(price);
		
		Skeleton.exit("true");
		
		return true;
	}
	
	public boolean accept(Land l){
		Skeleton.entry("t", "Trap", "accept", new String[] {"l:Land"});
		return false;
	}
	
	public boolean accept(Mountain m){
		Skeleton.entry("t", "Trap", "accept", new String[] {"m:Mountain"});
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
		Skeleton.entry("t", "Trap", "act", new String[] {"e:Elf"});
	}
	
	public void act(Human h){
		Skeleton.entry("t", "Trap", "act", new String[] {"h:Human"});
	}
	
	public void act(Dwarf d){
		Skeleton.entry("t", "Trap", "act", new String[] {"d:Dwarf"});
	}
	
	public void act(Hobbit h){
		Skeleton.entry("t", "Trap", "act", new String[] {"h:Hobbit"});
	}
	
	public void addStone(Stone s){
		Skeleton.entry("t", "Trap", "addStone", new String[] {"s:Stone"});
	}
}
