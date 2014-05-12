package nabukodonozor;

import grafikus.DwarfView;

import java.util.List;

public class Dwarf extends Enemy {
	//konstruktor
	public Dwarf(Cell cell) {
		super();
		this.cell			= cell;
		view				= new DwarfView(this);
		int[] cell_coords	= cell.getView().getCoords();
		view.setCoords(cell_coords[0], cell_coords[1]);
		life				= 80;
		value				= 40;
		speed.add(32);
		selectDestination();
	}
	
	//kettevagas
	protected void split() {
		//uj ellenseg
		Enemy e = new Dwarf(cell);
		
		//cella beallitasa
		e.setCell(cell);
		
		//sajat elet tordelese
		life *= 0.8;
		life += 5;
		
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
