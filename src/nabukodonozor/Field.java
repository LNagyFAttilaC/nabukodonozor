package nabukodonozor;

import java.util.List;

public class Field {
	private Timer timer; //idozíto
	private int allEnemies; //a jatekban szereplo ellensogek szama
	private int enemiesWereIn; //a jatekban mar reszt vett ellensegek szama
	private List<Cell> cells; //cellak
	private List<Cell> entries; //bejaratok
	private int died; //az elpusztult ellensegek szama
	private int mana; //Szaruman varazsereje
	
	//inicializálás
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
	
	//jatek vege, vereseg
	public void gameOver() {
		Object[] params = {};
		Skeleton.entry(this, "gameOver()", params);
		
		Skeleton.exit("void");
	}
	
	//jatek vege, gyozelem
	public void win() {
		Object[] params = {};
		Skeleton.entry(this, "win()", params);
		
		Skeleton.exit("void");
	}
	
	//varazsero novelese
	public void increaseMana(int value) {
		Integer Value = new Integer(value);
		Object[] params = {value};
		Skeleton.entry(this, "increaseMana(int value)", params);

		mana += value;
		
		Skeleton.exit("void");
	}
	
	//varazsero csokkentese
	public void decreaseMana(int value) {
		Integer Value = new Integer(value);
		Object[] params = {Value};
		Skeleton.entry(this, "decreaseMana(int value)", params);
		
		mana -= value;
		
		Skeleton.exit("void");
	}
	
	//getter: timer
	public Timer getTimer() {
		Object[] params = {};
		Skeleton.entry(this, "getTimer()", params);
		
		Skeleton.exit("timer");
		
		return timer;
	}
	
	//setter: timer
	public void setTimer(Timer t) {
		Object[] params = {t};
		Skeleton.entry(this, "setTimer(Timer t)", params);
		
		timer = t;
		
		Skeleton.exit("void");
	}
	
	//getter: allEnemies
	public int getAllEnemies(){
		Object[] params = {};
		Skeleton.entry(this, "getAllEnemies()", params);
		
		Skeleton.exit("void");
		
		return allEnemies;
	}
	
	//getter: died
	public int getDied(){
		Object[] params = {};
		Skeleton.entry(this, "getDied()", params);
		
		Skeleton.exit("void");
		
		return died;
	}
}
