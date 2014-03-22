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
	
	public void damage(Bullet b) {
		Object[] params = {b};
		Skeleton.entry(this, "damage(Bullet b)", params);
	}
	
	public boolean accept(Road r) {
		Object[] params = {r};
		Skeleton.entry(this, "accept(Road r)", params);
		
		List<Element> elements = r.getElements();
		
		r.setElement(this);
		
		Skeleton.exit("true");
		
		return true;
	}
	
	public boolean accept(Land l) {
		Object[] params = {l};
		Skeleton.entry(this, "accept(Land l)", params);
	}

	public boolean accept(Mountain m) {
		Object[] params = {m};
		Skeleton.entry(this, "accept(Mountain m)", params);
	}

	public boolean accept(Tower t) {
		Object[] params = {t};
		Skeleton.entry(this, "accept(Tower t)", params);
	}

	public boolean accept(Trap t) {
		Object[] params = {t};
		Skeleton.entry(this, "accept(Trap t)", params);
	}

	public boolean accept(Enemy e) {
		Object[] params = {e};
		Skeleton.entry(this, "accept(Enemy e)", params);
	}

	public boolean accept(Detector d) {
		Object[] params = {d};
		Skeleton.entry(this, "accept(Detector d)", params);
		
		Tower tower = d.getTower();
		tower.addTarget(this);
		
		Skeleton.exit("true");
		
		return true;
	}

	public void addSpeedItem(int s) {
		Object[] params = {s};
		Skeleton.entry(this, "addSpeedItem(int s)", params);
	}
	
	private Cell selectDestination() {
		Object[] params = {};
		Skeleton.entry(this, "selectDestination()", params);
		
		Skeleton.exit("r");
		
		return cell.getNeighbours().get(0);
	}

	public void tick() {
		Object[] params = {};		
		Skeleton.entry(this, "tick()", params);
		
		Cell r = selectDestination();
		Skeleton.objects.put(r, "r");
		
		r.addElement(this);
		cell.removeElement(this);
		
		Skeleton.exit("void");
	}
}
