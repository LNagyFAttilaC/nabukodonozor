package nabukodonozor;
import grafikus.*;

import java.util.ArrayList;
import java.util.List;

public class Hobbit extends Enemy {
	private HobbitView hobbitView;
	
	//konstruktor
	public Hobbit() {
		life	= 25;
		value	= 15;
		speed	= new ArrayList<Integer>(12);
	}
	
	//kettevagas
	protected void split() {
		//uj ellenseg
		Enemy e = new Hobbit();
		
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
		
		hobbitView.notifyView();
		// az �jsz�l�ttnek nem kellene notifyView()-t h�vni? -> publikusnak kellene lennie

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
