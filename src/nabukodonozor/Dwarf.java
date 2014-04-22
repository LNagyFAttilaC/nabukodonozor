package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public class Dwarf extends Enemy {
	//konstruktor
	public Dwarf() {
		life	= 80;
		value	= 40;
		speed	= new ArrayList<Integer>(32);
	}
	
	//kettevagas
	protected void split() {
		//uj ellenseg
		Enemy e = new Dwarf();
		
		//cella beallitasa
		e.setCell(cell);
		
		//sajat elet tordelese
		life *= 0.4;
		
		//az uj ellenseg eletenek beallitasa
		e.setLife(life);
		
		//hozzaadas a cellahoz
		cell.addElement(e);
		
		//hozzadas az aktiv elemekhez
		Field f = cell.getField();			
		Timer timer = f.getTimer();			
		timer.addActive(e);

		System.out.println("Ellenseg kettevagodott.");
	}
	
	//segedmetodus
	protected void act_bridge(List<Element> elements) {
		for (Element e : elements) {
			e.act(this);
		}
	}
	
	//segedmetodus
	protected void improveBullet_bridge(StoneToTower s, Bullet b) {
		s.improveBullet(b, this);
	}
}
