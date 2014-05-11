package nabukodonozor;

import grafikus.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Field {
	private Timer timer; //idozito
	private int allEnemies; //a jatekban szereplo ellensegek szama
	private List<Cell> cells; //cellak
	private List<Cell> entries; //bejaratok
	private int died; //az elpusztult ellensegek szama
	private int mana; //Szaruman varazsereje
	private FieldView fieldView;// referencia a megjelenitojere
	
	public Field(String mapName) throws IOException {
		cells = new ArrayList<Cell>();
		entries = new ArrayList<Cell>();
		timer = new Timer();
		timer.setField(this);
		fieldView = new FieldView(this);
		
		initialize(mapName);
	}
	
	//inicializalas
	public void initialize(String mapName) throws IOException {				
		allEnemies = 1; //ez majd random lesz!!!
		died = 0;
		mana = 100;
				
		FileReader fr = null;	
		BufferedReader br = null;
		
		try {
			fr = new FileReader("map/" + mapName + ".txt");
			br = new BufferedReader(fr);
			
			String firstLine = br.readLine();
			String[] parts = firstLine.split(" ");
			
			int cols = Integer.valueOf(parts[0]);
			int rows = Integer.valueOf(parts[1]);
			
			Controller.createCellArray(rows, cols);
			
			for (int y=0; y < rows; y++) {
				String line = br.readLine();
								
				for (int x=0; x < cols; x++) {					
					Cell cell = null;
					switch (line.charAt(x)) {
						case '~':
							cell = new Road();						
							break ;
						case '•':
							cell = new Land();
							boolean entry = (y == 0) || (y == rows-1) || (x == 0) || (x == cols-1);
							if (entry)
								entries.add(cell);					
							break;
						case '@':
							cell = new Mountain();					
							break;
					}
					
					cell.setField(this);
					cells.add(cell);
					Controller.setCell(cell, y, x);
					cell.getView().setCoords(x, y);
				}
			}
			
			/*for (int y=0; y < rows; y++) {
				for (int x=0; x < cols; x++) {
					
					if (y == 0) {
						if (x == 0) {
							// Bal felso sarok
							cellArray[x][y].setNeighbour(null);
							cellArray[x][y].setNeighbour(cellArray[x+1][y]);
							cellArray[x][y].setNeighbour(cellArray[x][y+1]);
							cellArray[x][y].setNeighbour(null);
						} else if (x == cols-1) {
							// Jobb felso sarok
							cellArray[x][y].setNeighbour(null);
							cellArray[x][y].setNeighbour(null);
							cellArray[x][y].setNeighbour(cellArray[x][y+1]);
							cellArray[x][y].setNeighbour(cellArray[x-1][y]);														
						} else {
							// Felso sor belseje
							cellArray[x][y].setNeighbour(null);
							cellArray[x][y].setNeighbour(cellArray[x+1][y]);
							cellArray[x][y].setNeighbour(cellArray[x][y+1]);
							cellArray[x][y].setNeighbour(cellArray[x-1][y]);
						}
					} else if (y == rows-1) {
						if (x == 0) {
							// Bal also sarok
							cellArray[x][y].setNeighbour(cellArray[x][y-1]);
							cellArray[x][y].setNeighbour(cellArray[x+1][y]);
							cellArray[x][y].setNeighbour(null);												
							cellArray[x][y].setNeighbour(null);
						} else if (x == cols-1) {
							// Jobb also sarok
							cellArray[x][y].setNeighbour(cellArray[x][y-1]);							
							cellArray[x][y].setNeighbour(null);												
							cellArray[x][y].setNeighbour(null);
							cellArray[x][y].setNeighbour(cellArray[x-1][y]);
						} else {
							// Also sor belseje
							cellArray[x][y].setNeighbour(cellArray[x][y-1]);							
							cellArray[x][y].setNeighbour(cellArray[x+1][y]);												
							cellArray[x][y].setNeighbour(null);
							cellArray[x][y].setNeighbour(cellArray[x-1][y]);
						}
					} else {
						if (x == 0) {
							// Bal szelso oszlop belseje
							cellArray[x][y].setNeighbour(cellArray[x][y-1]);							
							cellArray[x][y].setNeighbour(cellArray[x+1][y]);												
							cellArray[x][y].setNeighbour(cellArray[x][y+1]);
							cellArray[x][y].setNeighbour(null);							
						} else if (x == cols-1) {
							// Jobb szelso oszlop belseje
							cellArray[x][y].setNeighbour(cellArray[x][y-1]);							
							cellArray[x][y].setNeighbour(null);
							cellArray[x][y].setNeighbour(cellArray[x][y+1]);
							cellArray[x][y].setNeighbour(cellArray[x-1][y]);																										
						} else {
							// Belso (kozepso) terulet
							cellArray[x][y].setNeighbour(cellArray[x][y-1]);							
							cellArray[x][y].setNeighbour(cellArray[x+1][y]);
							cellArray[x][y].setNeighbour(cellArray[x][y+1]);
							cellArray[x][y].setNeighbour(cellArray[x-1][y]);
						}
					}
														
				}
			}*/
			fieldView.notifyView(); // cellák kirajzoló fv.-einek meghivasa
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
		//Parser.printText("Vereseg!");
	}
	
	//jatek vege, gyozelem
	public void win() {
		//Parser.printText("Gyozelem!");
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
		Enemy e = new Elf(); //ez majd random lesz!!!
		timer.addActive(e);
		
		for (Cell entry : entries) {
			entry.addElement(e);
		}
	}
	
	public List<Cell> getCells(){
		return cells;
	}
	
}
