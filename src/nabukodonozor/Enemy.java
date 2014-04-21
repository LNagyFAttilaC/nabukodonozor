package nabukodonozor;

import java.util.List;

public abstract class Enemy extends Element implements Active {
	protected int life; //elet
	protected int value; //ertek
	protected List<Integer> speed; //sebesseg
	
	//konstruktor
	public Enemy(){
		super.cell = new Road();
	}
	
	//interakcio torppel
	public void act(Dwarf d) {
		Object[] params = {d};
		Skeleton.entry(this, "act(Dwarf d)", params);
		
		Skeleton.exit("void");
	}
	
	//interakcio tundevel
	public void act(Elf e) {
		Object[] params = {e};
		Skeleton.entry(this, "act(Elf e)", params);
		
		Skeleton.exit("void");
	}
	
	//interakcio hobbittal
	public void act(Hobbit h) {
		Object[] params = {h};
		Skeleton.entry(this, "act(Hobbit h)", params);
		
		Skeleton.exit("void");
	}
	
	//interakcio emberrel
	public void act(Human h) {
		Object[] params = {h};
		Skeleton.entry(this, "act(Human h)", params);
		
		Skeleton.exit("void");
	}
	
	//utra kerulhet-e
	public boolean accept(Road r) {
		Object[] params = {r};
		Skeleton.entry(this, "accept(Road r)", params);
		
		//interakcio az uton levo elemekkel
		List<Element> elements = r.getElements();
		act_bridge(elements);
		
		//hozzaadas az uthoz
		r.setElement(this);
		
		Skeleton.exit("true");
		
		return true;
	}
	
	//mezore kerulhet-e
	public boolean accept(Land l) {
		Object[] params = {l};
		Skeleton.entry(this, "accept(Land l)", params);
		
		Skeleton.exit("false");
		
		return false;
	}

	//hegyre kerulhet-e
	public boolean accept(Mountain m) {
		Object[] params = {m};
		Skeleton.entry(this, "accept(Mountain m)", params);
		
		//Game Over!
		Field f = cell.getField();
		f.gameOver();
		
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
		
		Skeleton.exit("true");
		
		return true;
	}

	//ellenseg melle kerulhet-e
	public boolean accept(Enemy e) {
		Object[] params = {e};
		Skeleton.entry(this, "accept(Enemy e)", params);
		
		Skeleton.exit("true");
		return true;
	}

	//detektor melle kerulhet-e
	public boolean accept(Detector d) {
		Object[] params = {d};
		Skeleton.entry(this, "accept(Detector d)", params);
		
		//hozzaadas a toronyhoz celpontkent
		Tower tower = d.getTower();
		tower.addTarget(this);
		
		Skeleton.exit("true");
		
		return true;
	}

	//teendok minden utemben
	public void tick() {
		Object[] params = {};		
		Skeleton.entry(this, "tick()", params);
		
		//cel kivalasztasa
		Cell c = selectDestination();
		Skeleton.objects.put(c, "c");
		
		//hozzaadas a celhoz
		c.addElement(this);
		
		//torles a mostani cellarol
		cell.removeElement(this);
		
		Skeleton.exit("void");
	}
	
	//sebzes
	public void damage(Bullet b) {
		Object[] params = {b};
		Skeleton.entry(this, "damage(Bullet b)", params);
		
		//interakcio a lovedekkel
		b.act(this);
		
		Skeleton.exit("void");
	}

	//uj sebesseg-elem
	public void addSpeedItem(int s) {
		Integer S = new Integer(s);
		Object[] params = {S};
		Skeleton.entry(this, "addSpeedItem(int s)", params);
		
		speed.add(s);
		
		Skeleton.exit("void");
	}
	
	//cel kivalasztasa
	private Cell selectDestination() {
		Object[] params = {};
		Skeleton.entry(this, "selectDestination()", params);
		
		Skeleton.exit("c");
		
		return cell.getNeighbours().get(0);
	}
	
	//elet csokkentese
	public void decreaseLife(int d) {
		Integer D = new Integer(d);
		Object[] params = {D};
		Skeleton.entry(this, "decreaseLife(int d)", params);
		
		life -= d;
		
		//ha meghalt
		if (life<=0) {
			//manat kap Szaruman
			Field f = cell.getField();
			f.increaseMana(value);
			
			//torles az aktivok kozul
			Timer t = f.getTimer();
			t.removeActive(this);

			//torles a cellarol
			cell.removeElement(this);
		}
		
		Skeleton.exit("void");
	}
	
	//segedmetodus
	protected abstract void act_bridge(List<Element> elements);
	
	//segedmetodus
	protected abstract void improveBullet_bridge(StoneToTower s, Bullet b);
}
