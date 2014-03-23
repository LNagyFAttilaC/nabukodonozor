package nabukodonozor;

import java.util.List;

public abstract class Detector extends Element implements Active {
	protected Tower tower; //torony
	
	//utra kerulhet-e
	public boolean accept(Road r) {
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
		return true;
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
		
	}
	
	//interakcio emberrel
	public void act(Human h) {
		
	}
	
	//interakcio torppel
	public void act(Dwarf d) {
		
	}
	
	//interakcio hobbittal
	public void act(Hobbit h) {
		
	}
	
	//teendok minden utemben
	public void tick(){
		Object[] params = {};
		Skeleton.entry(this, "tick()", params);
		
		List<Element> elements = cell.getElements();
		elements.get(0).accept(this);
		
		Skeleton.exit("void");
	}
	
	//getter: tower
	public Tower getTower(){
		Object[] params = {};
		Skeleton.entry(this, "getTower()", params);
		
		Skeleton.exit("tower");
		
		return tower;
	}
	
	//setter: tower
	public void setTower(Tower t){
		Object[] params = {t};
		Skeleton.entry(this, "setTower(Tower t)", params);
		
		tower = t;
		
		Skeleton.exit("void");
	}
	
}
