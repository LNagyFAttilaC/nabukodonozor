package nabukodonozor;

import grafikus.HumanView;

import java.util.ArrayList;
import java.util.List;

public class Human extends Enemy {
	private HumanView humanView;
	
	//konstruktor
	public Human(Cell cell) {
		super();
		this.cell			= cell;
		view				= new HumanView(this);
		int[] cell_coords	= cell.getView().getCoords();
		view.setCoords(cell_coords[0], cell_coords[1]);
		life	= 100;
		value	= 50;
		speed.add(16);
		selectDestination();
	}
	
	//kettevagas
	protected void split() {
		//uj ellenseg
		Enemy e = new Human(cell);
		
		//cella beallitasa
		e.setCell(cell);
		
		//sajat elet tordelese
		life *= 0.8;
		
		//az uj ellenseg eletenek beallitasa
		e.setLife(life);
		
		//hozzaadas a cellahoz
		cell.addElement(e);
		
		//hozzadas az aktiv elemekhez
		Field f = cell.getField();			
		f.newEnemy();
		Timer timer = f.getTimer();			
		timer.addActive(e);
		
		view.notifyView();
		e.getView().notifyView();
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

	public boolean accept(Detector d) {
		d.act(this);
		
		return true;
	}
}
