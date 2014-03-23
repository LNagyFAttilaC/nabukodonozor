package nabukodonozor;

import java.util.List;

public abstract class Detector extends Element implements Active {
	protected Tower tower;
	
	public boolean accept(Road r) {
		return true;
	}
	
	public boolean accept(Land l) {
		return false;
	}
	
	public boolean accept(Mountain m) {
		return false;
	}
	
	public boolean accept(Tower t) {
		return false;
	}
	
	public boolean accept(Trap t) {
		return true;
	}
	
	public boolean accept(Enemy e) {
		return true;
	}
	
	public boolean accept(Detector d) {
		return true;
	}
	
	public void act(Elf e) {
		
	}
	
	public void act(Human h) {
		
	}
	
	public void act(Dwarf d) {
		
	}
	
	public void act(Hobbit h) {
		
	}
	
	public void tick(){
		Object[] params = {};
		Skeleton.entry(this, "tick()", params);
		
		List<Element> elements = cell.getElements();
		elements.get(0).accept(this);
		
		Skeleton.exit("void");
	}
	
	public Tower getTower(){
		Object[] params = {};
		Skeleton.entry(this, "getTower()", params);
		
		Skeleton.exit("tower");
		
		return tower;
	}
	
	public void setTower(Tower t){
		Object[] params = {t};
		Skeleton.entry(this, "setTower(Tower t)", params);
		
		tower = t;
		
		Skeleton.exit("void");
	}
	
}
