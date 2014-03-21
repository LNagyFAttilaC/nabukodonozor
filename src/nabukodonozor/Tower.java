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
		
	}
	
	public boolean accept(Land l) {
		
	}
	
	public boolean accept(Mountain m) {
		
	}
	
	public boolean accept(Tower t) {
		
	}
	
	public boolean accept(Trap t) {
		
	}
	
	public boolean accept(Enemy e) {
		
	}
	
	public boolean accept(Detector d) {
		
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
		
	}
	
	protected abstract Enemy selectTarget();
}
