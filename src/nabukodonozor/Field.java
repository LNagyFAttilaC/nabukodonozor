package nabukodonozor;

import grafikus.Controller;
import grafikus.FieldView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

public class Field {
	private Timer timer; //idozito
	private int allEnemies; //a jatekban szereplo ellensegek szama
	private int enemiesWereIn;
	private List<Cell> cells; //cellak
	private List<Cell> entries; //bejaratok
	private int died; //az elpusztult ellensegek szama
	private int mana; //Szaruman varazsereje
	private FieldView fieldView;// referencia a megjelenitojere
	
	public Field() {
		cells = new ArrayList<Cell>();
		entries = new ArrayList<Cell>();
		fieldView = new FieldView(this);
	}
	
	//inicializalas
	public void initialize(String mapName) throws IOException {				
		allEnemies = 1; //ez majd random lesz!!!
		enemiesWereIn = 0;
		died = 0;
		mana = 100;
				
		FileReader fr = null;	
		BufferedReader br = null;
		
		try {
			fr = new FileReader("map/" + mapName + ".txt");
			br = new BufferedReader(fr);
			
			String firstLine = br.readLine();
			String[] parts = firstLine.split(" ");
			
			int rows = Integer.valueOf(parts[0]);
			int cols = Integer.valueOf(parts[1]);
			Controller.createCellArray(rows, cols);
			
			for (int y=0; y < rows; y++) {
				String line = br.readLine();
								
				for (int x=0; x < cols; x++) {					
					Cell cell = null;
					
					switch (line.charAt(x)) {
						case '~':
							cell = new Road();						
							
							if ((y == 0) || (y == rows-1) || (x == 0) || (x == cols-1)) {
								entries.add(cell);
							}
						break ;
						case '•':
							cell = new Land();
						break;
						case '@':
							cell = new Mountain();					
						break;
					}
					
					cell.setField(this);
					cells.add(cell);
					Controller.setCell(cell, y, x);
					cell.getView().setCoords(y, x);
				}
			}
			
			for (int y=0; y < rows; y++) {
				for (int x=0; x < cols; x++) {
					if (y == 0) {
						if (x == 0) {
							// Bal felso sarok
							Controller.getCell(y, x).getCell().setNeighbour(null);
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y, x+1).getCell());
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y+1, y).getCell());
							Controller.getCell(y, x).getCell().setNeighbour(null);
						}
						else if (x == cols-1) {
							// Jobb felso sarok
							Controller.getCell(y, x).getCell().setNeighbour(null);
							Controller.getCell(y, x).getCell().setNeighbour(null);
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y+1, x).getCell());
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y, x-1).getCell());														
						}
						else {
							// Felso sor belseje
							Controller.getCell(y, x).getCell().setNeighbour(null);
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y, x+1).getCell());
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y+1, x).getCell());
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y, x-1).getCell());
						}
					}
					else if (y == rows-1) {
						if (x == 0) {
							// Bal also sarok
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y-1, x).getCell());
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y, x+1).getCell());
							Controller.getCell(y, x).getCell().setNeighbour(null);												
							Controller.getCell(y, x).getCell().setNeighbour(null);
						}
						else if (x == cols-1) {
							// Jobb also sarok
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y-1, x).getCell());							
							Controller.getCell(y, x).getCell().setNeighbour(null);												
							Controller.getCell(y, x).getCell().setNeighbour(null);
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y, x-1).getCell());
						}
						else {
							// Also sor belseje
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y-1, x).getCell());							
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y, x+1).getCell());												
							Controller.getCell(y, x).getCell().setNeighbour(null);
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y, x-1).getCell());
						}
					}
					else {
						if (x == 0) {
							// Bal szelso oszlop belseje
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y-1, x).getCell());							
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y, x+1).getCell());												
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y+1, x).getCell());
							Controller.getCell(y, x).getCell().setNeighbour(null);							
						}
						else if (x == cols-1) {
							// Jobb szelso oszlop belseje
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y-1, x).getCell());							
							Controller.getCell(y, x).getCell().setNeighbour(null);
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y+1, x).getCell());
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y, x-1).getCell());																										
						}
						else {
							// Belso (kozepso) terulet
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y-1, x).getCell());							
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y, x+1).getCell());
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y+1, x).getCell());
							Controller.getCell(y, x).getCell().setNeighbour(Controller.getCell(y, x-1).getCell());
						}
					}									
				}
			}
			
			fieldView.notifyView();
			
			java.util.Timer ticker = new java.util.Timer();
			ticker.scheduleAtFixedRate(new TimerTask() {
				public void run() {
					addEnemy();
				}
			}, 0, 1000);
		}
		finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}					
	}
	
	//jatek vege, vereseg
	public void gameOver() {
		System.out.println("VÉGE!");
	}
	
	//jatek vege, gyozelem
	public void win() {
		System.out.println("GYŐZELEM!");
	}
	
	//varazsero novelese
	public void increaseMana(int value) {
		if (value > 0 ) {
			mana += value;
		}
	}
	
	//varazsero csokkentese
	public void decreaseMana(int value) {
		if (value > 0) {
			mana -= value;
		}
	}
	
	//elpusztultak novelese
	public void increaseDied() {
		died++;
	}
	
	//getter: timer
	public Timer getTimer() {
		return timer;
	}
	
	//setter: timer
	public void setTimer(Timer t) {
		timer = t;
		
		timer.setField(this);
	}
	
	//getter: allEnemies
	public int getAllEnemies() {
		return allEnemies;
	}
	
	//getter: died
	public int getDied() {
		return died;
	}
	
	//getter: mana
	public int getMana() {
		return mana;
	}
	
	//setter: mana
	public void setMana(int m) {
		mana = m;
	}
	
	//ellenseg beleptetese
	public void addEnemy() {
		if (enemiesWereIn < allEnemies) {
			Random n   = new Random();
			Cell entry = entries.get(n.nextInt(entries.size()));
				
			Dwarf enemy = new Dwarf(entry);
			
			entry.addElement(enemy);
			
			timer.addActive(enemy);
			
			enemiesWereIn++;
		}
	}
	
	public List<Cell> getCells(){
		return cells;
	}
}
