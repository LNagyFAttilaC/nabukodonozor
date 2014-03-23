package nabukodonozor;

import java.util.List;

public abstract class Enemy extends Element implements Active {
	protected int life;
	protected int value;
	protected List<Integer> speed;
	
	public Enemy(){
		super.cell = new Road();
	}
	
	public void act(Dwarf d) {
		Object[] params = {d};
		Skeleton.entry(this, "act(Dwarf d)", params);
	}
	
	public void act(Elf e) {
		Object[] params = {e};
		Skeleton.entry(this, "act(Elf e)", params);
	}
	
	public void act(Hobbit h) {
		Object[] params = {h};
		Skeleton.entry(this, "act(Hobbit h)", params);
	}
	
	public void act(Human h) {
		Object[] params = {h};
		Skeleton.entry(this, "act(Human h)", params);
	}
	
	public boolean accept(Road r) {
		Object[] params = {r};
		Skeleton.entry(this, "accept(Road r)", params);
		
		List<Element> elements = r.getElements();
		act_bridge(elements);
		
		r.setElement(this);
		
		Skeleton.exit("true");
		
		return true;
	}
	
	public boolean accept(Land l) {
		Object[] params = {l};
		Skeleton.entry(this, "accept(Land l)", params);
		
		Skeleton.exit("false");
		return false;
	}

	public boolean accept(Mountain m) {
		Object[] params = {m};
		Skeleton.entry(this, "accept(Mountain m)", params);
		
		Field f = cell.getField();
		f.gameOver();
		
		Skeleton.exit("false");
		
		return false;
	}

	public boolean accept(Tower t) {
		Object[] params = {t};
		Skeleton.entry(this, "accept(Tower t)", params);
		
		Skeleton.exit("false");
		return false;
	}

	public boolean accept(Trap t) {
		Object[] params = {t};
		Skeleton.entry(this, "accept(Trap t)", params);
		
		this.cell.removeElement(this);
		Road place = (Road)t.cell;
		place.addElement(this);
		this.accept(place);
		
		Human h = new Human();
		t.act(h);
		h.addSpeedItem(t.slow);
		
		Skeleton.exit("true");
		return true;
	}

	public boolean accept(Enemy e) {
		Object[] params = {e};
		Skeleton.entry(this, "accept(Enemy e)", params);
		
		e.cell.addElement(this);
		this.cell.removeElement(this);
		
		Skeleton.exit("true");
		return true;
	}

	public boolean accept(Detector d) {
		Object[] params = {d};
		Skeleton.entry(this, "accept(Detector d)", params);
		
		Tower tower = d.getTower();
		tower.addTarget(this);
		
		Skeleton.exit("true");
		
		return true;
	}

	public void tick() {
		Object[] params = {};		
		Skeleton.entry(this, "tick()", params);
		
		Cell c = selectDestination();
		Skeleton.objects.put(c, "c");
		
		c.addElement(this);
		cell.removeElement(this);
		
		Skeleton.exit("void");
	}
	
	public void damage(Bullet b) {
		Object[] params = {b};
		Skeleton.entry(this, "damage(Bullet b)", params);
		
		b.act(this);
		
		Skeleton.exit("void");
	}

	public void addSpeedItem(int s) {
		Integer S = new Integer(s);
		Object[] params = {S};
		Skeleton.entry(this, "addSpeedItem(int s)", params);
		
		speed.add(s);
		
		Skeleton.exit("void");
	}
	
	private Cell selectDestination() {
		Object[] params = {};
		Skeleton.entry(this, "selectDestination()", params);
		
		Skeleton.exit("c");
		
		return cell.getNeighbours().get(0);
	}
	
	public void decreaseLife(int d) {
		Integer D = new Integer(d);
		Object[] params = {D};
		Skeleton.entry(this, "decreaseLife(int d)", params);
		
		life -= d;
		
		if (life<=0) {
			Field f = cell.getField();
			f.increaseMana(value);
			
			Timer t = f.getTimer();
			t.removeActive(this);

			cell.removeElement(this);
		}
		
		Skeleton.exit("void");
	}
	
	protected abstract void act_bridge(List<Element> elements);
	protected abstract void improveBullet_bridge(StoneToTower s, Bullet b);
}
