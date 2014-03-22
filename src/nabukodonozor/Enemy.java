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
		String[] params = {"d: Dwarf"};
		Skeleton.entry("e", "Enemy", "act", params);
	}
	
	public void act(Elf e) {
		String[] params = {"e: Elf"};
		Skeleton.entry("e", "Enemy", "act", params);
	}
	
	public void act(Hobbit h) {
		String[] params = {"h: Hobbit"};
		Skeleton.entry("e", "Enemy", "act", params);
	}
	
	public void act(Human h) {
		String[] params = {"h: Human"};
		Skeleton.entry("e", "Enemy", "act", params);
	}
	
	public void damage(Bullet b) {
		String[] params = {"b: Bullet"};
		Skeleton.entry("e", "Enemy", "damage", params);
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
		String[] params = {"l: Land"};
		Skeleton.entry("e", "Enemy", "accept", params);
	}

	public boolean accept(Mountain m) {
		String[] params = {"m: Mountain"};
		Skeleton.entry("e", "Enemy", "accept", params);
	}

	public boolean accept(Tower t) {
		String[] params = {"t: Tower"};
		Skeleton.entry("e", "Enemy", "accept", params);
	}

	public boolean accept(Trap t) {
		String[] params = {"t: Trap"};
		Skeleton.entry("e", "Enemy", "accept", params);
	}

	public boolean accept(Enemy e) {
		String[] params = {"e: Enemy"};
		Skeleton.entry("e", "Enemy", "accept", params);
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
		String[] params = {"s: int"};
		Skeleton.entry("e", "Enemy", "addSpeedItem", params);
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
