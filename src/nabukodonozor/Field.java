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
		Skeleton.entry("f", "Field", "initialize", new String[] {});
		
		allEnemies = 100;
		enemiesWereIn = 0;
		died = 0;
		mana = 50;	
		
		Skeleton.entry("f", "Field", "initialize", new String[] {});
		
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
	}
	
	public void gameOver() {
		Skeleton.entry("f", "Field", "gameOver", new String[] {});
	}
	
	public void win() {
		Skeleton.entry("f", "Field", "win", new String[] {});
	}
	
}
