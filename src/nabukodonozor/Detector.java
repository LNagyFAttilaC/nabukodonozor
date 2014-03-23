package nabukodonozor;

import java.util.List;

public abstract class Detector extends Element implements Active {
	
	protected Tower tower; //torony
	
	//utra kerulhet-e
	public boolean accept(Road r) {
		Object[] params = {r};
		Skeleton.entry(this, "accept(Road r)", params);
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
		Skeleton.exit("true");
		return true;
	}
	
	//ellenseg melle kerulhet-e
	public boolean accept(Enemy e) {
		Object[] params = {e};
		Skeleton.entry(this, "accept(Enemy e)", params);
		Skeleton.exit("true");
		return true;
	}
	
	//detektor melle kerulhet-e
	public boolean accept(Detector d) {
		Object[] params = {d};
		Skeleton.entry(this, "accept(Detector d)", params);
		Skeleton.exit("true");
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
