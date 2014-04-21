package nabukodonozor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		Object[] params = {};
		Skeleton.entry(this, "initialize()", params);
		
		allEnemies = 100;
		enemiesWereIn = 0;
		died = 0;
		mana = 50;			
				
		/*FileReader fr = null;	
		BufferedReader br = null;
		
		try {
			
			fr = new FileReader("map/map.txt");
			br = new BufferedReader(fr);
			
			String firstLine = br.readLine();WWW
			String[] parts = firstLine.split(" ");
			int cols = Integer.valueOf(parts[0]);
			int rows = Integer.valueOf(parts[1]);
			
			System.out.println(cols + " " + rows);
			
			
			
		} catch (FileNotFoundException e) {	
			
			e.printStackTrace();						
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}*/
				
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
		timer.setField(this);
		
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
	
	public void addEnemy() {
		Object[] params = {};
		Skeleton.entry(this, "addEnemy()", params);
		Enemy e = new Elf();
		Skeleton.objects.put(e, "e:Enemy");
		timer.addActive(e);
		for (Cell entry : entries) {
			Skeleton.objects.put(entry, "entry:Cell");
			entry.addElement(e);
		}
		Skeleton.exit("void");
	}
	
}
