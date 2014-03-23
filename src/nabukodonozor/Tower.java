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
		Object[] params = {};
		Skeleton.entry(null, "Tower()", params);
		
		stones	= new ArrayList<StoneToTower>();
		targets	= new ArrayList<Enemy>();
		
		Skeleton.exit("tower");
	}
	
	//utra kerulhet-e
	public boolean accept(Road r) {
		Object[] params = {r};
		Skeleton.entry(this, "accept(Road r)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	//mezore kerulhet-e
	public boolean accept(Land l) {
		Object[] params = {l};
		Skeleton.entry(this, "accept(Land l)", params);
		
		for (Element e : l.getElements()) {
			Skeleton.objects.put(e, "e:Element");
			boolean result = e.accept(this);
			if (!result) {
				Skeleton.exit("false");
				return false;
			}
		}
		
		for (Cell c : l.getNeighbours()) {		
			Skeleton.objects.put(c, "c:Cell");
			BasicDetector d = new BasicDetector();
			Skeleton.objects.put(d, "d:BasicDetector");
			c.addElement(d);
			Field f = c.getField();			
			Timer timer = f.getTimer();			
			timer.addActive(d);
		}
		
		Skeleton.exit("true");
		
		return true;		
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
		
		Skeleton.exit("false");
		
		return false;
	}
	
	//ellenseg melle kerulhet-e
	public boolean accept(Enemy e) {
		Object[] params = {e};
		Skeleton.entry(this, "accept(Enemy e)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	//detektor melle kerulhet-e
	public boolean accept(Detector d) {
		Object[] params = {d};
		Skeleton.entry(this, "accept(Detector d)", params);
		
		Skeleton.exit("false");
		
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
		Object[] params = {};
		Skeleton.entry(this, "tick()", params);
		
		//celpont kivalasztasa
		Enemy h 	= selectTarget();
		
		//alap lovedek letrehozasa
		Bullet bu	= new Bullet();
		Skeleton.objects.put(bu, "bu:Bullet");
		bu.increaseDamage(damage);

		//lovedek fejlesztese kovekkel
		for (StoneToTower s : stones) {
			s.improveBullet_bridge(s, bu, h);
		}
		
		//ellenseg sebzese
		h.damage(bu);

		Skeleton.exit("void");
	}
	
	//ko hozzaadasa
	public void addStone(StoneToTower s) {
		Object[] params = {s};
		Skeleton.entry(this, "addStone(StoneToTower s)", params);
		
		stones.add(s);
		
		Skeleton.exit("void");
	}
	
	//celpont hozzaadasa
	public void addTarget(Enemy e) {
		Object[] params = {e};
		Skeleton.entry(this, "addTarget(Enemy e)", params);
		
		targets.add(e);
		
		Skeleton.exit("void");
	}
	
	//celpont kivalasztasa
	protected abstract Enemy selectTarget();
}
