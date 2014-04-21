package nabukodonozor;

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
	// valid ertekek definialasa
	private static final String[] enemyNames = {"Dwarf","Elf","Hobbit","Human"};
	private static final String[] elementNames = {"BasicTower","BasicTrap"};
	private static final String[] TwrStoneNames = {"DamageStone","DwarfDamageStone","ElfDamageStone",
										"FrequencyStone","HobbitDamageStone","HumanDamageStone","RadiusStone"};
	private static final String   fogName = "Fog";
	private static final String   TrpStoneName = "RetentiveStone";
	private static final String[] bulletNames = {"BasicBullet","SlicerBullet"};
	private static final String[] directions = {"up","down","left","right"};
	
	public static void setField(Field F){
		field = F;
	}
	
	public static void drawField(){
		for(int i=0; i<field.cellArray.length; ++i){
			for(int j=0; j<field.cellArray[0].length; ++j){
				if(field.cellArray[i][j].getClass() == Road.class)
					System.out.print("U");
				else if(field.cellArray[i][j].getClass() == Land.class)
					System.out.print("X");
			}
			System.out.println();
		}
	}

	public static void ADDTOCELL(String type, int x, int y){
		// megvizsgalom, hogy benne van-e a megfelelo tombben
		boolean validParam = false;
		for(int i=0; i<elementNames.length; ++i){
			if(elementNames[i].equals(type)){
				validParam = true;
			}	
		}
		if(validParam != true || x<0 || y<0){
			System.out.println("Nem teheto cellara.");
			return;
		}
		else{
			if(type.equals(elementNames[0])){ // BasicTower
				Tower bt = new BasicTower();
				field.cellArray[y-1][x-1].addElement(bt);
				System.out.format("Torony a %d %d cellan.%n", x, y);
			}
			else if(type.equals(elementNames[1])){ // BasicTrap
				Trap bt = new BasicTrap();
				field.cellArray[y-1][x-1].addElement(bt);
				System.out.format("Akadaly a %d %d cellan.%n", x, y);
			}
		}
	}

	public static void ADDTOFIELD(String type, int x, int y){
		// megvizsgalom, hogy benne van-e a megfelelo tombben
		boolean validParam = false;
		for(int i=0; i<enemyNames.length; ++i){
			if(enemyNames[i].equals(type)){
				validParam = true;
			}
		}
		if(validParam != true || x<0 || y<0){
			System.out.println("Nem teheto palyara.");
			return;
		}
		else{
			if(type.equals(enemyNames[0])){ // Dwarf
				Dwarf d = new Dwarf();
				field.cellArray[y-1][x-1].addElement(d);
				//System.out.format("Torp hozzaadasa a %d %d cellahoz%n", x, y);
			}
			else if(type.equals(enemyNames[1])){ // Elf
				Elf e = new Elf();
				field.cellArray[y-1][x-1].addElement(e);
				//System.out.format("Tunde hozzaadasa a %d %d cellahoz%n", x, y);
			}
			else if(type.equals(enemyNames[2])){ // Hobbit
				Hobbit h = new Hobbit();
				field.cellArray[y-1][x-1].addElement(h);
				//System.out.format("Hobbit hozzaadasa a %d %d cellahoz%n", x, y);
			}
			else if(type.equals(enemyNames[3])){ // Human
				Human h = new Human();
				field.cellArray[y-1][x-1].addElement(h);
				//System.out.format("Ember hozzaadasa a %d %d cellahoz%n", x, y);
			}
			System.out.format("Ellenseg hozzaadva a %d %d cellahoz.%n", x, y);
		}
	}

	public static void ADDTOTOWER(String type, int x, int y){
		// megvizsgalom, hogy benne van-e a megfelelo tombben
		boolean validParam = false;
		if(!type.equals(fogName)){
			for(int i=0; i<TwrStoneNames.length; ++i){
				if(TwrStoneNames[i].equals(type)){
					validParam = true;
				}	
			}
		}
		else{
			validParam = true;
		}
		if(validParam != true || x<0 || y<0){
			System.out.println("Nem teheto toronyra.");
			return;
		}
		else{
			if(type.equals(TwrStoneNames[0])){ // DamageStone
				StoneToTower ds = new DamageStone();
			}
			else if(type.equals(TwrStoneNames[1])){ // DwarfDamageStone
				StoneToTower dds = new DwarfDamageStone();
			}
			else if(type.equals(TwrStoneNames[2])){ // ElfDamageStone
				StoneToTower eds = new ElfDamageStone();
			}
			else if(type.equals(TwrStoneNames[3])){ // FrequencyStone
				StoneToTower fs = new FrequencyStone();
			}
			else if(type.equals(TwrStoneNames[4])){ // HobbitDamageStone
				StoneToTower hds = new HobbitDamageStone();
			}
			else if(type.equals(TwrStoneNames[5])){ // HumanDamageStone
				StoneToTower hds = new HumanDamageStone();
			}
			else if(type.equals(TwrStoneNames[6])){ // RadiusStone
				StoneToTower rs = new RadiusStone();
			}
			else if(type.equals(fogName)){ // Fog
				Fog f = new Fog();
			}
			System.out.format("Ko hozzaadva a %d %d cellan levo toronyhoz.%n", x, y);
		}
	}

	public static void ADDTOTRAP(String type, int x, int y){
		// megvizsgalom, hogy benne van-e a megfelelo tombben
		boolean validParam = false;
		
		if(!type.equals(TrpStoneName) || x<0 || y<0){
			System.out.println("Nem teheto akadalyra.");
			return;
		}
		else{ // RetentiveStone
			StoneToTrap rs = new RetentiveStone();
			System.out.format("Ko hozzaadva a %d %d cellan levo akadalyhoz.%n", x, y);
		}
	}

	public static void SHOOTWITH(String type, int x, int y){
		// megvizsgalom, hogy benne van-e a megfelelo tombben
		boolean validParam = false;
		for(int i=0; i<bulletNames.length; ++i){
			if(bulletNames[i].equals(type)){
				validParam = true;
			}	
		}
		if(validParam != true || x<0 || y<0){
			System.out.println("Nincs ilyen lovedek.");
			return;
		}
		else{
			if(type.equals(bulletNames[0])){ // BasicBullet
				Program._PROTO_TOWER_BULLET = 0;
			}
			else if(type.equals(bulletNames[1])){ // SlicerBullet
				Program._PROTO_TOWER_BULLET = 1;
			}
			System.out.format("Lovedek beallitva a %d %d cellan levo toronynal.%n", x, y);
		}
	}

	public static void STEPENEMY(String dir){
		// megvizsgalom, hogy benne van-e a megfelelo tombben
		boolean validParam = false;
		for(int i=0; i<directions.length; ++i){
			if(directions[i].equals(dir)){
				validParam = true;
			}	
		}
		if(validParam != true){
			System.out.println("Nem lephetsz oda.");
			return;
		}
		else{
			if(dir.equals(directions[0])){ // UP
				Program._PROTO_ENEMY_DIRECTION = 0;
			}
			else if(dir.equals(directions[1])){ // DOWN
				Program._PROTO_ENEMY_DIRECTION = 2;
			}
			else if(dir.equals(directions[2])){ // LEFT
				Program._PROTO_ENEMY_DIRECTION = 3;
			}
			else if(dir.equals(directions[3])){ // RIGHT
				Program._PROTO_ENEMY_DIRECTION = 1;
			}
		}
	}

	public static void TICK(int n){
		if(n<1){
			System.out.println("Ervenytelen parameter.");
			return;
		}
		else{
			for (int i=0; i<n; i++) {
				field.getTimer().tick();
			}
		}
	}
	
	public static void DUMPMAP(){
		
	}
	
	public static void MANA() {
		System.out.format("Mana %d.", field.getMana());
	}
}
