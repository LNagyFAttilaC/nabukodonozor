package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public class Field {
	
	private Timer timer; //idozito
	private int allEnemies; //a jatekban szereplo ellensogek szama
	private int enemiesWereIn; //a jatekban mar reszt vett ellensegek szama
	private List<Cell> cells; //cellak
	private List<Cell> entries; //bejaratok
	private int died; //az elpusztult ellensegek szama
	private int mana; //Szaruman varazsereje
	
	public Field() {
		cells = new ArrayList<Cell>();
		entries = new ArrayList<Cell>();
	}
	
	//inicializalas
	public void initialize() {		
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
	}
	
	//jatek vege, vereseg
	public void gameOver() {

	}
	
	//jatek vege, gyozelem
	public void win() {

	}
	
	//varazsero novelese
	public void increaseMana(int value) {
		mana += value;
	}
	
	//varazsero csokkentese				PETI (csak toroltem belole)
	public void decreaseMana(int value) {
		mana -= value;
	}
	
	//getter: timer
	public Timer getTimer() {
		return timer;
	}
	
	//setter: timer
	public void setTimer(Timer t) {
		timer = t;
	}
	
	//getter: allEnemies
	public int getAllEnemies(){
		return allEnemies;
	}
	
	//getter: died
	public int getDied(){
		return died;
	}
	
	//ellenseg beleptetese
	public void addEnemy() {
		Enemy e = new Elf();
		timer.addActive(e);
		
		for (Cell entry : entries) {
			entry.addElement(e);
		}
	}
}
