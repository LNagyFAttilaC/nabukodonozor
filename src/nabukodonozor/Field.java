package nabukodonozor;

import java.util.List;

public class Field {

	private Timer timer;
	private int allEnemies;
	private int enemiesWereIn;
	private List<Cell> cells;
	private List<Cell> entries;
	private int died;
	private int mana;
	
	public void initialize() {		
		Object[] params = {};
		Skeleton.entry(this, "initialize()", params);
		
		allEnemies = 100;
		enemiesWereIn = 0;
		died = 0;
		mana = 50;			
		
		for (int i=0; i < 5; i++) {
			Road r = new Road();
			cells.add(r);
			if (i == 1) {
				entries.add(r);
			}			
		}
		
		for (int i=0; i < 5; i++) {
			Land l = new Land();
			cells.add(l);
		}
		
		Mountain m = new Mountain();
		cells.add(m);
		
		Skeleton.exit("void");
	}
	
	public void gameOver() {
		Object[] params = {};
		Skeleton.entry(this, "gameOver()", params);
		Skeleton.exit("void");
	}
	
	public void win() {
		Object[] params = {};
		Skeleton.entry(this, "win()", params);
		Skeleton.exit("void");
	}
	
	public void increaseMana(int value) {
		mana += value;
	}
	
	public void decreaseMana(int value) {
		Integer Value = new Integer(value);
		Skeleton.objects.put(Value, "b.price");
		Object[] params = {value};
		Skeleton.entry(this, "decreaseMana(int value)", params);
		
		mana -= value;
		Skeleton.exit("void");
	}
	
}
