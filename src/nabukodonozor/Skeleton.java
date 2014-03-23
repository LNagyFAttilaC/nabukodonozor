package nabukodonozor;

import java.util.HashMap;
import java.util.Map;

public class Skeleton {
	private static int tab = 0; //tabulatorok szama
	public  static Map<Object, String> objects = new HashMap<Object, String>();
	public  static boolean enabled;
	
	//objectName: az objektum
	//methodName: a meghivott metodus neve
	//methodParamsID: a meghivott metodus parameterei egy tombben
	public static void entry(Object objectName, String methodName, Object[] methodParamsID) {
		if (enabled) {
			//tabulator(ok) kiirasa
			for (int i=1; i<=Skeleton.tab; i++)	{
				System.out.print("\t");
			}
			
			//objektum:osztaly.metodus kiirasa
			System.out.print(objects.get(objectName) + "." + methodName);
			
			System.out.print("(");
			
			//parameterek kiirasa
			for (int i=0; i<methodParamsID.length; i++) {
				System.out.print(objects.get(methodParamsID[i]));
				
				if (i<methodParamsID.length-1) {
					System.out.print(", ");
				}
			}
			
			System.out.println(")");
			
			Skeleton.tab++;
		}
	}
	
	//returnValue: visszateresi ertek
	public static void exit(String returnValue) {
		if (enabled) {
			Skeleton.tab--;
			
			//tabulator(ok) kiirasa
			for (int i=1; i<=Skeleton.tab; i++)	{
				System.out.print("\t");
			}
			
			//visszateresi ertek kiirasa
			System.out.println("return " + returnValue);
		}
	}
	
	//Initialization
	public static void sd01() {
		System.out.println("sd01()");
	}
	
	//AllEnemyDies
	public static void sd02() {
		// szereplõk helyének lefoglalása
		Timer t = new Timer();
		Field f = new Field();
		// Skeleton engedélyezésének letiltása
	    Skeleton.enabled = false;
		// mûveletek levégzése
	    if(f.getDied() == f.getAllEnemies())
	    	f.win();
	    // itt lefoglalt objektumok közös tárba tétele
		Skeleton.objects.put(t, "t:Timer");
		Skeleton.objects.put(f, "f:Field");
		// Szekvenciával kapcsolatos kiírások
		System.out.println("AllEnemyDies:");
		System.out.println("Mind a két érték nulla, ezért gyõztünk.");
		// Skeleton engedélyezése
		Skeleton.enabled = true;
		// újabb ütem indítása
		t.tick();
	}
	
	//EnemyEntersTheGame
	public static void sd03() {
		System.out.println("sd03()");
	}
	
	//EnemyStepOntoRoad
	public static void sd04() {
		Timer t 	= new Timer();
		Human h 	= new Human();
		Road r 		= new Road();
		Road h_cell = new Road();
		
		Skeleton.enabled = false;
		h_cell.setNeighbour(r);
		h.setCell(h_cell);
		t.addActive(h);
		
		Skeleton.objects.put(t, "t:Timer");
		Skeleton.objects.put(h, "h:Human");
		Skeleton.objects.put(r, "r:Road");
		Skeleton.objects.put(h_cell, "h.cell:Road");
		
		System.out.println("EnemyStepOntoRoad:");
		System.out.println("A cellán nincs egy Element se, a Hobbit üres cellára lép. Ezért a 8-as, 9-es hívás nem jelenik meg.");
		Skeleton.enabled = true;
		t.tick();
	}
	
	//EnemyStepOntoTrap
	public static void sd05() {
		Timer t 	= new Timer();
		Human h 	= new Human();
		Road r 		= new Road();
		Trap b		= new BasicTrap();
		Road h_cell = new Road();
		
		Skeleton.enabled = false;
		r.addElement(b);
		h_cell.setNeighbour(r);
		h.setCell(h_cell);
		t.addActive(h);
		
		Skeleton.objects.put(t, "t:Timer");
		Skeleton.objects.put(h, "h:Human");
		Skeleton.objects.put(r, "r:Road");
		Skeleton.objects.put(b, "b:BasicTrap");
		Skeleton.objects.put(h_cell, "h.cell:Road");
		
		System.out.println("EnemyStepOntoTrap:");
		Skeleton.enabled = true;
		t.tick();
	}
	
	//EnemyGetsInRange
	public static void sd06() {
		Timer t            = new Timer();
		BasicDetector d    = new BasicDetector();
		Road d_cell        = new Road();
		Hobbit h           = new Hobbit();
		BasicTower d_tower = new BasicTower();
		
		Skeleton.enabled = false;
		t.addActive(d);
		d_cell.addElement(h);
		d.setCell(d_cell);
		d.setTower(d_tower);
		
		Skeleton.objects.put(t, "t:Timer");
		Skeleton.objects.put(d, "d:BasicDetector");
		Skeleton.objects.put(d_cell, "d.cell:Road");
		Skeleton.objects.put(h, "h:Hobbit");
		Skeleton.objects.put(d_tower, "d.tower:BasicTower");
		
		System.out.println("EnemyGetsInRange:");
		Skeleton.enabled = true;
		t.tick();
	}
	
	//EnemyReachesMountain
	public static void sd07() {
		Timer t     = new Timer();
		Enemy h    = new Hobbit();
		Cell m  = new Mountain();
		Cell h_cell = new Road();
		Field f     = new Field();
		
		Skeleton.enabled = false;
		t.addActive(h);
		h_cell.addElement(h);
		h_cell.setNeighbour(m);
		h.setCell(h_cell);
		
		Skeleton.objects.put(t, "t:Timer");
		Skeleton.objects.put(h, "h:Hobbit");
		Skeleton.objects.put(m, "m:Mountain");
		Skeleton.objects.put(h_cell, "h.cell:Road");
		Skeleton.objects.put(f, "f:Field");
		
		Skeleton.enabled = true;
		t.tick();
	}
	
	//TowerDamagesOrKillsEnemy
	public static void sd08() {
		Timer t						= new Timer();
		BasicTower bt				= new BasicTower();
		HobbitDamageStone hs		= new HobbitDamageStone();
		Hobbit h					= new Hobbit();
		Cell h_cell					= new Road();
		Field h_cell_field			= new Field();
		
		Skeleton.enabled = false;
		t.addActive(bt);
		h_cell_field.setTimer(t);
		h_cell.setField(h_cell_field);
		h.setCell(h_cell);
		h_cell.addElement(h);
		bt.addStone(hs);
		bt.addTarget(h);
		
		Skeleton.objects.put(t, "t:Timer");
		Skeleton.objects.put(bt, "bt:BasicTower");
		Skeleton.objects.put(hs, "hs:HobbitDamageStone");
		Skeleton.objects.put(h, "h:Hobbit");
		Skeleton.objects.put(h_cell, "h_cell:Road");
		Skeleton.objects.put(h_cell_field, "h_cell_field:Field");
		
		Skeleton.enabled = true;
		t.tick();
	}
	
	//TowerOntoRoad
	public static void sd09() {
		// szereplõk helyének lefoglalása
		Road r = new Road();
		Tower t = new BasicTower();
		// Skeleton engedélyezésének letiltása
	    Skeleton.enabled = false;
		// mûveletek levégzése
	    t.accept(r);
	    // itt lefoglalt objektumok közös tárba tétele
		Skeleton.objects.put(r, "r:Road");
		Skeleton.objects.put(t, "t:Tower");
		// Szekvenciával kapcsolatos kiírások
		System.out.println("TowerOntoRoad:");
		System.out.println("Torony útra helyezése nem lehetséges.");
		// Skeleton engedélyezése
		Skeleton.enabled = true;
	}
	
	//TowerOntoLand
	public static void sd10() {
		System.out.println("sd10()");
	}
	
	//TowerOntoTower
	public static void sd11() {
		System.out.println("sd11()");
	}
	
	//TowerOntoMountain
	public static void sd12() {
		Mountain m = new Mountain();
		BasicTower b = new BasicTower();
		
		Skeleton.enabled = false;
		
		Skeleton.objects.put(m, "m:Mountain");
		Skeleton.objects.put(b, "b:BasicTower");
		
		Skeleton.enabled = true;
		m.addElement(b);
	}
	
	//TrapOntoRoad
	public static void sd13() {
		Cell r             = new Road();
		BasicTrap b        = new BasicTrap();
		Field b_cell_field = new Field();
		
		Skeleton.enabled = false;
		r.setField(b_cell_field);
		
		Skeleton.objects.put(r, "r:Road");
		Skeleton.objects.put(b, "b:BasicTrap");
		Skeleton.objects.put(b_cell_field, "b.cell.field:Field");
		
		Skeleton.enabled = true;
		r.addElement(b);
	}
	
	//TrapOntoTrap
	public static void sd14() { //EZ MÉG NEM JÓ!!!!!
		Cell r       = new Road();
		BasicTrap t1 = new BasicTrap();
		BasicTrap t2 = new BasicTrap();
		
		Skeleton.enabled = false;
		r.setElement(t1);
		
		Skeleton.objects.put(r, "r:Road");
		Skeleton.objects.put(t1, "t1:BasicTrap");
		Skeleton.objects.put(t2, "t2:BasicTrap");
		
		Skeleton.enabled = true;
		r.addElement(t2);
	}
	
	//TrapOntoLand
	public static void sd15() {
		Land l      = new Land();
		BasicTrap b = new BasicTrap();
		
		Skeleton.enabled = false;
		
		Skeleton.objects.put(l, "l:Land");
		Skeleton.objects.put(b, "b:BasicTrap");
		
		Skeleton.enabled = true;
		l.addElement(b);
	}
	//TrapOntoMountain
	public static void sd16() {
		System.out.println("sd16()");
	}
	
	//StoneOntoTower
	public static void sd17() {
		// szereplõk helyének lefoglalása
		BasicTower b = new BasicTower();
		HumanDamageStone h = new HumanDamageStone();
		Field f = new Field();
		// skeleton tiltása
		Skeleton.enabled = false;
		// mûveletek levégzése
		f.decreaseMana(h.price);
		h.act(b);
		// itt létrehozott objektumok közös tárba tétele
		Skeleton.objects.put(b, "b:BasicTower");
		Skeleton.objects.put(h, "h:HumanDamageStone");
		Skeleton.objects.put(f, "f:Field");
		// szekvenciával kapcsolatos kiírások
		System.out.println("StoneOntoTower:");
		// skeleton engedélyezése
		Skeleton.enabled = true;
		// kõ hozzáadása a toronyhoz
		b.setStone(h);
	}
	//StoneOntoTrap
	public static void sd18() {
		System.out.println("sd18()");
	}
}
