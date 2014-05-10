package nabukodonozor;

import grafikus.*;

import java.util.ArrayList;
import java.util.List;

public class Elf extends Enemy {
	private ElfView elfView;
	
	//konstruktor
	public Elf() {
		life	= 50;
		value	= 25;
		speed	= new ArrayList<Integer>(8);
	}
	
	//kettevagas
	protected void split() {
		//uj ellenseg
		Enemy e = new Elf();
		
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
		
		elfView.notifyView();
		// az újszülöttnek nem kellene notifyView()-t hívni? -> publikusnak kellene lennie

		//Parser.printText("Ellenseg kettevagodott.");
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
