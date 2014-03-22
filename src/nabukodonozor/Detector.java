package nabukodonozor;

import java.util.List;

public abstract class Detector extends Element implements Active {
	protected Tower tower;
	
	public boolean accept(Road r) {
		
	}
	
	public boolean accept(Land l) {
		
	}
	
	public boolean accept(Mountain m) {
		
	}
	
	public boolean accept(Tower t) {
		
	}
	
	public boolean accept(Trap t) {
		
	}
	
	public boolean accept(Enemy e) {
		
	}
	
	public boolean accept(Detector d) {
		
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
