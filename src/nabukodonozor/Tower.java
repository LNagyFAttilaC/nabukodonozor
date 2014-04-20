package nabukodonozor;

import java.util.List;
import java.util.ArrayList;

public abstract class Tower extends Element implements Active {
	protected List<StoneToTower> stones; //kovek
	protected List<Enemy> targets; //celpontok
	protected int radius; //hatosugar
	protected int frequency; //lovesi gyakorisag
	protected int damage; //sebzes
	protected int price; //ar
	
	//konstruktor
	public Tower() {
		stones		= new ArrayList<StoneToTower>();
		targets		= new ArrayList<Enemy>();
	}
	
	//utra kerulhet-e
	public boolean accept(Road r) {
		return false;
	}
	
	//mezore kerulhet-e
	public boolean accept(Land l) {
		//van-e ott torony
		for (Element e : l.getElements()) {
			boolean result = e.accept(this);
			
			if (!result) {
				return false;
			}
		}

		Field f = l.getField();
		Timer timer = f.getTimer();
		
		//detektorok lehelyezese
		for (Cell c : l.getNeighbours()) {		
			Detector d = new BasicDetector(this);
			c.addElement(d);

			//hozzaadas az aktiv elemekhez
			timer.addActive(d);
		}
		
		//hozzaadas az aktiv elemekhez
		timer.addActive(this);
		
		//hozzaadas a mezohoz
		l.setElement(this);
		
		//mana csokkentese
		f.decreaseMana(price);
		
		return true;		
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
		return false;
	}
	
	//ellenseg melle kerulhet-e
	public boolean accept(Enemy e) {
		return false;
	}
	
	//detektor melle kerulhet-e
	public boolean accept(Detector d) {
		return false;
	}
	
	//interakcio tundevel
	public void act(Elf e) {
		return;
	}
	
	//interakcio emberrel
	public void act(Human h) {
		return;
	}
	
	//interakcio torppel
	public void act(Dwarf d) {
		return;
	}
	
	//interakcio hobbittal
	public void act(Hobbit h) {
		return;
	}
	
	//teendok minden utemben
	public void tick() {
		//celpont kivalasztasa
		Enemy h 	= selectTarget();
		
		Bullet bu;
		if (Program._PROTO_TOWER_BULLET == 0) {
			//alap lovedek letrehozasa
			bu	= new BasicBullet();
			bu.increaseDamage(damage);
	
			//lovedek fejlesztese kovekkel
			for (StoneToTower s : stones) {
				s.improveBullet_bridge(s, bu, h);
			}
		}
		else {
			//kettevago lovedek letrehozasa
			bu	= new SlicerBullet();
		}
		
		//ellenseg sebzese
		h.damage(bu);
	}
	
	//ko hozzaadasa
	public void addStone(StoneToTower s) {
		s.accept(this);
	}
	
	//ko eltarolasa
	public void setStone(StoneToTower s) {
		stones.add(s);
	}
	
	//celpont hozzaadasa
	public void addTarget(Enemy e) {
		targets.add(e);
	}
	
	//celpont kivalasztasa
	protected abstract Enemy selectTarget();

	//segedmetodus
	protected abstract void act_bridge(StoneToTower s);
}
