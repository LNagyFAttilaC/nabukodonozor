package nabukodonozor;

import java.util.List;

public abstract class Detector extends Element implements Active {
	protected Tower tower; //torony
	
	//a tornyot egybol csatolo konstruktor
	public Detector(Tower t) {
		tower = t;
	}
	
	//utra kerulhet-e
	public boolean accept(Road r) {
		//hozzaadas a mezohoz
		r.setElement(this);
		
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
		//hozzaadas a toronyhoz celpontkent
		tower.addTarget(e);
	}
	
	//interakcio emberrel
	public void act(Human h) {
		//hozzaadas a toronyhoz celpontkent
		tower.addTarget(h);
	}
	
	//interakcio torppel
	public void act(Dwarf d) {
		//hozzaadas a toronyhoz celpontkent
		tower.addTarget(d);
	}
	
	//interakcio hobbittal
	public void act(Hobbit h) {
		//hozzaadas a toronyhoz celpontkent
		tower.addTarget(h);
	}
	
	//teendok minden utemben
	public void tick(){
		List<Element> elements = cell.getElements();
		
		for (Element e : elements) {
			e.accept(this);
		}
	}
	
	//getter: tower
	public Tower getTower(){
		return tower;
	}
	
	//setter: tower
	public void setTower(Tower t){
		tower = t;
	}
}
