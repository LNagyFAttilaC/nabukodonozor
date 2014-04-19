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
		
		//detektorok lehelyezese
		for (Cell c : l.getNeighbours()) {		
			BasicDetector d = new BasicDetector();
			c.addElement(d);
			
			Field f = c.getField();			
			Timer timer = f.getTimer();			
			timer.addActive(d);
		}
		
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
