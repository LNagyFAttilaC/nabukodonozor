package nabukodonozor;

import java.io.FileWriter;

public class Parser {
	/*
	 * ADDTOCELL type x y
	 * ADDTOFIELD type
	 * ADDTOTOWER type x y
	 * ADDTOTRAP type x y
	 * SHOOTWITH type x y
	 * STEPENEMY dir
	 * TICK n
	 */
	
	private static Field field;
	public static Tower[][] towers;
	public static Trap[][] traps;
	public static Enemy[][] enemies;
	
	// valid ertekek definialasa
	private static final String[] enemyNames = {"Dwarf","Elf","Hobbit","Human"};
	private static final String[] elementNames = {"BasicTower","BasicTrap"};
	private static final String[] TwrStoneNames = {"DamageStone","DwarfDamageStone","ElfDamageStone",
										"FrequencyStone","HobbitDamageStone","HumanDamageStone","RadiusStone"};
	private static final String   TrpStoneName = "RetentiveStone";
	private static final String[] bulletNames = {"BasicBullet","SlicerBullet"};
	private static final String[] directions = {"up","down","left","right"};
	
	public static void setField(Field F) {
		field = F;
	}
	
	public static void drawField() {
		for (int i=0; i<field.cellArray[0].length; i++) {
			for (int j=0; j<field.cellArray.length; j++) {
				if (enemies[j][i] != null) {
					System.out.print("E");
				}
				else if (towers[j][i] != null) {
					System.out.print("T");
				}
				else if (traps[j][i] != null) {
					System.out.print("C");
				}
				else if (field.cellArray[j][i].getClass() == Road.class) {
					System.out.print("~");
				}
				else if (field.cellArray[j][i].getClass() == Land.class) {
					System.out.print("•");
				}
				else if (field.cellArray[j][i].getClass() == Mountain.class) {
					System.out.print("@");
				}
			}
			
			System.out.println();
		}
	}

	public static void ADDTOCELL(String type, int x, int y) {
		//benne van-e a megfelelo tombben
		boolean validParam = false;
		for (int i=0; i<elementNames.length; ++i) {
			if (elementNames[i].equals(type)) {
				validParam = true;
			}	
		}
		
		if (validParam != true || x<0 || y<0) {
			System.out.println("Nem teheto oda.");
			
			return;
		}
		else {
			if (type.equals(elementNames[0])) { // BasicTower
				if (field.getMana() >= 80) {
					Tower bt = new BasicTower();
					field.cellArray[x-1][y-1].addElement(bt);
					
					if (field.cellArray[x-1][y-1].getClass() == Land.class && towers[x-1][y-1] == null) {
						towers[x-1][y-1] = bt;
						
						System.out.format("Torony a %d %d cellan.%n", x, y);
					}
					else {
						System.out.println("Nem teheto oda.");
					}
				}
				else {
					System.out.println("Nincs eleg mana.");
				}
			}
			else if (type.equals(elementNames[1])) { // BasicTrap
				if (field.getMana() >= 50) {
					Trap bt = new BasicTrap();
					field.cellArray[x-1][y-1].addElement(bt);
					
					if (field.cellArray[x-1][y-1].getClass() == Road.class && traps[x-1][y-1] == null) {
						traps[x-1][y-1] = bt;
						
						System.out.format("Akadaly a %d %d cellan.%n", x, y);
					}
					else {
						System.out.println("Nem teheto oda.");
					}
				}
				else {
					System.out.println("Nincs eleg mana.");
				}
			}
		}
	}

	public static void ADDTOFIELD(String type, int x, int y){
		//benne van-e a megfelelo tombben
		boolean validParam = false;
		for (int i=0; i<enemyNames.length; ++i) {
			if (enemyNames[i].equals(type)) {
				validParam = true;
			}
		}
		
		if (validParam != true || x<0 || y<0) {
			System.out.println("Nem teheto oda.");
			
			return;
		}
		else {
			if (type.equals(enemyNames[0])) { // Dwarf
				Dwarf d = new Dwarf();
				d.setCell(field.cellArray[x-1][y-1]);
				field.cellArray[x-1][y-1].addElement(d);
				field.getTimer().addActive(d);
				enemies[x-1][y-1] = d;
				
				System.out.format("Torp hozzaadasa a %d %d cellahoz.%n", x, y);
			}
			else if (type.equals(enemyNames[1])) { // Elf
				Elf e = new Elf();
				e.setCell(field.cellArray[x-1][y-1]);
				field.cellArray[x-1][y-1].addElement(e);
				field.getTimer().addActive(e);
				enemies[x-1][y-1] = e;
				
				System.out.format("Tunde hozzaadasa a %d %d cellahoz.%n", x, y);
			}
			else if (type.equals(enemyNames[2])) { // Hobbit
				Hobbit h = new Hobbit();
				h.setCell(field.cellArray[x-1][y-1]);
				field.cellArray[x-1][y-1].addElement(h);
				field.getTimer().addActive(h);
				enemies[x-1][y-1] = h;
				
				System.out.format("Hobbit hozzaadasa a %d %d cellahoz.%n", x, y);
			}
			else if (type.equals(enemyNames[3])) { // Human
				Human h = new Human();
				h.setCell(field.cellArray[x-1][y-1]);
				field.cellArray[x-1][y-1].addElement(h);
				field.getTimer().addActive(h);
				enemies[x-1][y-1] = h;
				
				System.out.format("Ember hozzaadasa a %d %d cellahoz.%n", x, y);
			}
		}
	}

	public static void ADDTOTOWER(String type, int x, int y) {
		//benne van-e a megfelelo tombben
		boolean validParam = false;

		for (int i=0; i<TwrStoneNames.length; i++) {
			if (TwrStoneNames[i].equals(type)) {
				validParam = true;
			}	
		}
		
		if (validParam != true || x<0 || y<0) {
			System.out.println("Nem teheto toronyra.");
			return;
		}
		else {
			if (type.equals(TwrStoneNames[0])) { // DamageStone
				if (field.getMana() >= 650) {
					StoneToTower ds = new DamageStone();
					towers[x-1][y-1].addStone(ds);
					
					System.out.format("Ko hozzaadva a %d %d cellan levo toronyhoz.%n", x, y);
				}
				else {
					System.out.println("Nincs eleg mana.");
				}
			}
			else if (type.equals(TwrStoneNames[1])) { // DwarfDamageStone
				if (field.getMana() >= 325) {
					StoneToTower dds = new DwarfDamageStone();
					towers[x-1][y-1].addStone(dds);
					
					System.out.format("Ko hozzaadva a %d %d cellan levo toronyhoz.%n", x, y);
				}
				else {
					System.out.println("Nincs eleg mana.");
				}
			}
			else if (type.equals(TwrStoneNames[2])) { // ElfDamageStone
				if (field.getMana() >= 300) {
					StoneToTower eds = new ElfDamageStone();
					towers[x-1][y-1].addStone(eds);
					
					System.out.format("Ko hozzaadva a %d %d cellan levo toronyhoz.%n", x, y);
				}
				else {
					System.out.println("Nincs eleg mana.");
				}
			}
			else if (type.equals(TwrStoneNames[3])) { // FrequencyStone
				if (field.getMana() >= 220) {
					StoneToTower fs = new FrequencyStone();
					towers[x-1][y-1].addStone(fs);
					
					System.out.format("Ko hozzaadva a %d %d cellan levo toronyhoz.%n", x, y);
				}
				else {
					System.out.println("Nincs eleg mana.");
				}
			}
			else if (type.equals(TwrStoneNames[4])) { // HobbitDamageStone
				if (field.getMana() >= 275) {
					StoneToTower hds = new HobbitDamageStone();
					towers[x-1][y-1].addStone(hds);
					
					System.out.format("Ko hozzaadva a %d %d cellan levo toronyhoz.%n", x, y);
				}
				else {
					System.out.println("Nincs eleg mana.");
				}
			}
			else if (type.equals(TwrStoneNames[5])) { // HumanDamageStone
				if (field.getMana() >= 350) {
					StoneToTower hds = new HumanDamageStone();
					towers[x-1][y-1].addStone(hds);
					
					System.out.format("Ko hozzaadva a %d %d cellan levo toronyhoz.%n", x, y);
				}
				else {
					System.out.println("Nincs eleg mana.");
				}
			}
			else if (type.equals(TwrStoneNames[6])) { // RadiusStone
				if (field.getMana() >= 410) {
					StoneToTower rs = new RadiusStone();
					towers[x-1][y-1].addStone(rs);
					
					System.out.format("Ko hozzaadva a %d %d cellan levo toronyhoz.%n", x, y);
				}
				else {
					System.out.println("Nincs eleg mana.");
				}
			}
		}
	}

	public static void ADDTOTRAP(String type, int x, int y) {
		//benne van-e a megfelelo tombben
		if (!type.equals(TrpStoneName) || x<0 || y<0) {
			System.out.println("Nem teheto akadalyra.");
		}
		else { // RetentiveStone
			if (field.getMana() >= 180) {
				StoneToTrap rs = new RetentiveStone();
				traps[x-1][y-1].addStone(rs);
				
				System.out.format("Ko hozzaadva a %d %d cellan levo akadalyhoz.%n", x, y);
			}
			else {
				System.out.println("Nincs eleg mana.");
			}
		}
	}

	public static void SHOOTWITH(String type, int x, int y){
		//benne van-e a megfelelo tombben
		boolean validParam = false;
		for (int i=0; i<bulletNames.length; i++) {
			if (bulletNames[i].equals(type)) {
				validParam = true;
			}	
		}
		
		if (validParam != true || x<0 || y<0) {
			System.out.println("Nincs ilyen lovedek.");
			
			return;
		}
		else {
			if (type.equals(bulletNames[0])) { // BasicBullet
				Program._PROTO_TOWER_BULLET = 0;
			}
			else if (type.equals(bulletNames[1])) { // SlicerBullet
				Program._PROTO_TOWER_BULLET = 1;
			}
			
			System.out.format("Lovedek beallitva a %d %d cellan levo toronynal.%n", x, y);
		}
	}

	public static void STEPENEMY(String dir) {
		//benne van-e a megfelelo tombben
		boolean validParam = false;
		for (int i=0; i<directions.length; ++i) {
			if (directions[i].equals(dir)) {
				validParam = true;
			}	
		}
		
		if (validParam != true) {
			System.out.println("Ismeretlen irany.");
			
			return;
		}
		else {
			if (dir.equals(directions[0])) { // UP
				Program._PROTO_ENEMY_DIRECTION = 0;
			}
			else if (dir.equals(directions[1])) { // DOWN
				Program._PROTO_ENEMY_DIRECTION = 2;
			}
			else if (dir.equals(directions[2])) { // LEFT
				Program._PROTO_ENEMY_DIRECTION = 3;
			}
			else if (dir.equals(directions[3])) { // RIGHT
				Program._PROTO_ENEMY_DIRECTION = 1;
			}
			
			System.out.println("Irany beallitva.");
		}
	}

	public static void TICK(int n) {
		if (n < 1) {
			System.out.println("Ervenytelen parameter.");
		}
		else {
			for (int i=0; i<n; i++) {
				field.getTimer().tick();
			}
			
			for (int i=0; i<enemies[0].length; i++) {
				for (int j=0; j<enemies.length; j++) {
					if (enemies[j][i] != null) {
						switch (Program._PROTO_ENEMY_DIRECTION) {
						case 0:
							if (i-1 >= 0) {
								enemies[j][i-1] = enemies[j][i];
								enemies[j][i]	= null;
							}
						break;
						case 1:
							if (j+1 < enemies[0].length) {
								enemies[j+1][i] = enemies[j][i];
								enemies[j][i]	= null;
							}
						break;
						case 2:
							if (i+1 < enemies.length) {
								enemies[j][i+1] = enemies[j][i];
								enemies[j][i]	= null;
							}
						break;
						case 3:
							if (j-1 >= 0) {
								enemies[j-1][i] = enemies[j][i];
								enemies[j][i]	= null;
							}
						break;
						}
					}
				}
				
				System.out.println();
			}
		}
	}
	
	public static void DUMPMAP() {
		try {
			FileWriter fw = new FileWriter("map_out.txt");
			
			for (int i=0; i<field.cellArray[0].length; i++) {
				for (int j=0; j<field.cellArray.length; j++) {
					if (enemies[j][i] != null) {
						fw.write("E");
					}
					else if (towers[j][i] != null) {
						fw.write("T");
					}
					else if (traps[j][i] != null) {
						fw.write("C");
					}
					else if (field.cellArray[j][i].getClass() == Road.class) {
						fw.write("~");
					}
					else if (field.cellArray[j][i].getClass() == Land.class) {
						fw.write("•");
					}
					else if (field.cellArray[j][i].getClass() == Mountain.class) {
						fw.write("@");
					}
				}
				
				fw.write("\r\n");
			}
			
			fw.close();
			
			System.out.println("A mentes a map_out.txt fajlba megtortent.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void MANA() {
		System.out.format("Mana %d.%n", field.getMana());
	}
	
	public static void MANA(int m) {
		field.setMana(m);
		MANA();
	}
}
