package nabukodonozor;

import grafikus.*;

import java.util.ArrayList;
import java.util.List;

public class Human extends Enemy {
	private HumanView humanView;
	
	//konstruktor
	public Human() {
		life	= 100;
		value	= 50;
		speed	= new ArrayList<Integer>(16);
	}
	
	//kettevagas
	protected void split() {
		//uj ellenseg
		Enemy e = new Human();
		
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
		
		humanView.notifyView();
		// az újszülöttnek nem kellene notifyView()-t hívni? -> publikusnak kellene lennie

		Parser.printText("Ellenseg kettevagodott.");
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
