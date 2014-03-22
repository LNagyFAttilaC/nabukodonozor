package nabukodonozor;

import java.util.List;
import java.util.ArrayList;

public abstract class Tower extends Element implements Active {
	private List<StoneToTower> stones;
	private List<Enemy> targets;
	
	public Tower() {
		stones	= new ArrayList<StoneToTower>();
		targets	= new ArrayList<Enemy>();
	}
	
	public boolean accept(Road r) {
		Object[] params = {r};
		Skeleton.entry(this, "Tower", "accept(Road r)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	public boolean accept(Land l) {
		Object[] params = {l};
		Skeleton.entry(this, "Tower", "accept(Land l)", params);
		
		Skeleton.exit("true");
		
		return true;		
	}
	
	public boolean accept(Mountain m) {
		Object[] params = {m};
		Skeleton.entry(this, "Tower", "accept(Mountain m)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	public boolean accept(Tower t) {
		Object[] params = {t};
		Skeleton.entry(this, "Tower", "accept(Tower t)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	public boolean accept(Trap t) {
		Object[] params = {t};
		Skeleton.entry(this, "Tower", "accept(Trap t)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	public boolean accept(Enemy e) {
		Object[] params = {e};
		Skeleton.entry(this, "Tower", "accept(Enemy e)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	public boolean accept(Detector d) {
		Object[] params = {d};
		Skeleton.entry(this, "Tower", "accept(Detector d)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	public void act(Elf e) {
		
	}
	
	public void act(Human h) {
		
	}
	
	public void act(Dwarf d) {
		
	}
	
	public void act(Hobbit h) {
		
	}
	
	public void tick() {
		
	}
	
	public void addStone(Stone s) {
		
	}
	
	public void addTarget(Enemy e) {
		Object[] params = {e};
		Skeleton.entry(this, "addTarget(Enemy e)", params);
		
		targets.add(e);
		
		Skeleton.exit("void");
	}
	
	protected abstract Enemy selectTarget();
}
