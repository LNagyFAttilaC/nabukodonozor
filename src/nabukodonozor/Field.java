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
		allEnemies = 1;
		enemiesWereIn = 0;
		died = 0;
		mana = 50;			
				
		FileReader fr = null;	
		BufferedReader br = null;
		
		try {
			
			fr = new FileReader("map/test_map.txt");
			br = new BufferedReader(fr);
			
			String firstLine = br.readLine();
			String[] parts = firstLine.split(" ");
			
			int cols = Integer.valueOf(parts[0]);
			int rows = Integer.valueOf(parts[1]);
			
			Cell[][] cellArray = new Cell[rows][cols];
			
			for (int y=0; y < rows; y++) {
				
				String line = br.readLine();
								
				for (int x=0; x < cols; x++) {					
					Cell cell = null;
					switch (line.charAt(x)) {
						case 'U':
							cell = new Road();						
							break ;
						case 'X':
							cell = new Land();
							boolean entry = (y == 0) || (y == rows-1) || (x == 0) || (x == cols-1);
							if (entry)
								entries.add(cell);						
							break;
						case 'M':
							cell = new Mountain();					
							break;
					}					
					cellArray[y][x] = cell;					
				}	
				
			}
			
			for (int y=0; y < rows; y++) {
				for (int x=0; x < cols; x++) {
					
					if (y == 0) {
						if (x == 0) {
							// Bal felso sarok
							cellArray[y][x].neighbours.add(null);
							cellArray[y][x].neighbours.add(cellArray[y][x+1]);
							cellArray[y][x].neighbours.add(cellArray[y+1][x]);
							cellArray[y][x].neighbours.add(null);
						} else if (x == cols-1) {
							// Jobb felso sarok
							cellArray[y][x].neighbours.add(null);
							cellArray[y][x].neighbours.add(null);
							cellArray[y][x].neighbours.add(cellArray[y+1][x]);
							cellArray[y][x].neighbours.add(cellArray[y][x-1]);														
						} else {
							// Felso sor belseje
							cellArray[y][x].neighbours.add(null);
							cellArray[y][x].neighbours.add(cellArray[y][x+1]);
							cellArray[y][x].neighbours.add(cellArray[y+1][x]);
							cellArray[y][x].neighbours.add(cellArray[y][x-1]);
						}
					} else if (y == rows-1) {
						if (x == 0) {
							// Bal also sarok
							cellArray[y][x].neighbours.add(cellArray[y-1][x]);
							cellArray[y][x].neighbours.add(cellArray[y][x+1]);
							cellArray[y][x].neighbours.add(null);												
							cellArray[y][x].neighbours.add(null);
						} else if (x == cols-1) {
							// Jobb also sarok
							cellArray[y][x].neighbours.add(cellArray[y-1][x]);							
							cellArray[y][x].neighbours.add(null);												
							cellArray[y][x].neighbours.add(null);
							cellArray[y][x].neighbours.add(cellArray[y][x-1]);
						} else {
							// Also sor belseje
							cellArray[y][x].neighbours.add(cellArray[y-1][x]);							
							cellArray[y][x].neighbours.add(cellArray[y][x+1]);												
							cellArray[y][x].neighbours.add(null);
							cellArray[y][x].neighbours.add(cellArray[y][x-1]);
						}
					} else {
						if (x == 0) {
							// Bal szelso oszlop belseje
							cellArray[y][x].neighbours.add(cellArray[y-1][x]);							
							cellArray[y][x].neighbours.add(cellArray[y][x+1]);												
							cellArray[y][x].neighbours.add(cellArray[y+1][x]);
							cellArray[y][x].neighbours.add(null);							
						} else if (x == cols-1) {
							// Jobb szelso oszlop belseje
							cellArray[y][x].neighbours.add(cellArray[y-1][x]);							
							cellArray[y][x].neighbours.add(null);
							cellArray[y][x].neighbours.add(cellArray[y+1][x]);
							cellArray[y][x].neighbours.add(cellArray[y][x-1]);																										
						} else {
							// Belso (kozepso) terulet
							cellArray[y][x].neighbours.add(cellArray[y-1][x]);							
							cellArray[y][x].neighbours.add(cellArray[y][x+1]);
							cellArray[y][x].neighbours.add(cellArray[y+1][x]);
							cellArray[y][x].neighbours.add(cellArray[y][x-1]);
						}
					}
														
				}
			}		
								
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
			
		}					
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
		
		timer.setField(this);
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
