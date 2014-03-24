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
			if (objectName!=null) {
				System.out.print(objects.get(objectName) + ".");
			}
			
			System.out.print(methodName);
			
			System.out.print("(");
			
			//parameterek kiirasa
			for (int i=0; i<methodParamsID.length; i++) {
				if (objects.containsKey(methodParamsID[i])) {
					System.out.print(objects.get(methodParamsID[i]));
				
					if (i<methodParamsID.length-1) {
						System.out.print(", ");
					}
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
		Field f = new Field();
		
		Skeleton.objects.put(f, "f:Field");
		
		System.out.println("Initialization:");
		System.out.println("A cells.add() �s entries.add() met�dusok a bels� implement�ci�hoz tartoznak, ez�rt nem jelennek itt meg.");
		Skeleton.enabled = true;
		f.initialize();
	}
	
	//AllEnemyDies
	public static void sd02() {
		Skeleton.enabled = false;
		Timer timer = new Timer();
		Field field = new Field();
	    
		Skeleton.objects.put(timer, "timer:Timer");
		Skeleton.objects.put(field, "f:Field");
		
		System.out.println("AllEnemyDies:");
		Skeleton.enabled = true;
		if(field.getDied() == field.getAllEnemies())
	    	field.win();
	}
	
	//EnemyEntersTheGame
	public static void sd03() {
		Skeleton.enabled = false;
		
		Timer t = new Timer();
		Field f = new Field();					
				
		f.initialize();
		f.setTimer(t);	
		
		Skeleton.objects.put(t, "t:Timer");
		Skeleton.objects.put(f, "f:Field");			
		
		System.out.println("EnemyEntersTheGame:");
		Skeleton.enabled = true;
		f.addEnemy();
	}
	
	//EnemyStepOntoRoad
	public static void sd04() {
		Skeleton.enabled = false;
		
		Timer timer	= new Timer();
		Human h 	= new Human();
		Road r 		= new Road();
		Road h_cell = new Road();
				
		h_cell.setNeighbour(r);
		h.setCell(h_cell);
		timer.addActive(h);
		
		Skeleton.objects.put(timer, "timer:Timer");
		Skeleton.objects.put(h, "h:Human");
		Skeleton.objects.put(r, "r:Road");
		Skeleton.objects.put(h_cell, "h.cell:Road");
		
		System.out.println("EnemyStepOntoRoad:");
		System.out.println("A cell�n nincs egy Element se, a Hobbit �res cell�ra l�p. Ez�rt a 8-as, 9-es h�v�s nem jelenik meg.");
		Skeleton.enabled = true;
		timer.tick();
	}
	
	//EnemyStepOntoTrap
	public static void sd05() {
		Skeleton.enabled = false;
		
		Timer timer	= new Timer();
		Human h 	= new Human();
		Road r 		= new Road();
		BasicTrap b	= new BasicTrap();
		Road h_cell = new Road();
				
		r.addElement(b);
		h_cell.setNeighbour(r);
		h.setCell(h_cell);
		timer.addActive(h);
		
		Skeleton.objects.put(timer, "timer:Timer");
		Skeleton.objects.put(h, "h:Human");
		Skeleton.objects.put(r, "r:Road");
		Skeleton.objects.put(b, "b:BasicTrap");
		Skeleton.objects.put(h_cell, "h.cell:Road");
		
		System.out.println("EnemyStepOntoTrap:");
		Skeleton.enabled = true;
		timer.tick();
	}
	
	//EnemyGetsInRange
	public static void sd06() {
		Skeleton.enabled = false;
		
		Timer timer        = new Timer();
		BasicDetector d    = new BasicDetector();
		Road d_cell        = new Road();
		Hobbit h           = new Hobbit();
		BasicTower d_tower = new BasicTower();
				
		timer.addActive(d);
		d_cell.addElement(h);
		d.setCell(d_cell);
		d.setTower(d_tower);
		
		Skeleton.objects.put(timer, "timer:Timer");
		Skeleton.objects.put(d, "d:BasicDetector");
		Skeleton.objects.put(d_cell, "d.cell:Road");
		Skeleton.objects.put(h, "h:Hobbit");
		Skeleton.objects.put(d_tower, "d.tower:BasicTower");
		
		System.out.println("EnemyGetsInRange:");
		Skeleton.enabled = true;
		timer.tick();
	}
	
	//EnemyReachesMountain
	public static void sd07() {
		Skeleton.enabled = false;
		
		Timer timer	= new Timer();
		Enemy h		= new Hobbit();
		Mountain m	= new Mountain();
		Road h_cell = new Road();
		Field f     = new Field();		
		
		timer.addActive(h);
		h_cell.addElement(h);
		h_cell.setNeighbour(m);
		h.setCell(h_cell);
		
		Skeleton.objects.put(timer, "t:Timer");
		Skeleton.objects.put(h, "h:Hobbit");
		Skeleton.objects.put(m, "m:Mountain");
		Skeleton.objects.put(h_cell, "h.cell:Road");
		Skeleton.objects.put(f, "f:Field");
		
		System.out.println("EnemyReachesMountain:");
		Skeleton.enabled = true;
		timer.tick();
	}
	
	//TowerDamagesOrKillsEnemy
	public static void sd08() {
		Skeleton.enabled = false;
		
		Timer timer					= new Timer();
		BasicTower bt				= new BasicTower();
		HobbitDamageStone hs		= new HobbitDamageStone();
		Hobbit h					= new Hobbit();
		Road h_cell					= new Road();
		Field field					= new Field();
		
		Skeleton.enabled = false;
		timer.addActive(bt);
		field.setTimer(timer);
		h_cell.setField(field);
		h.setCell(h_cell);
		h_cell.addElement(h);
		bt.addStone(hs);
		bt.addTarget(h);
		
		Skeleton.objects.put(timer, "timer:Timer");
		Skeleton.objects.put(bt, "bt:BasicTower");
		Skeleton.objects.put(hs, "hs:HobbitDamageStone");
		Skeleton.objects.put(h, "h:Hobbit");
		Skeleton.objects.put(h_cell, "h_cell:Road");
		Skeleton.objects.put(field, "field:Field");
		
		System.out.println("TowerDamagesOrKillsEnemy:");
		Skeleton.enabled = true;
		timer.tick();
	}
	
	//TowerOntoRoad
	public static void sd09() {
		Skeleton.enabled = false;
		
		Road r 			= new Road();
		BasicTower b	= new BasicTower();		
				
		Skeleton.objects.put(r, "r:Road");
		Skeleton.objects.put(b, "b:BasicTower");
		
		System.out.println("TowerOntoRoad:");
		Skeleton.enabled = true;
		r.addElement(b);
	}
	
	//TowerOntoLand
	public static void sd10() {
		Skeleton.enabled = false;
		
		Land l			= new Land();
		BasicTower t	= new BasicTower();
		BasicTower t1	= new BasicTower();
		Field f			= new Field();
		Land ln			= new Land();
		Road rn			= new Road();
		Timer timer		= new Timer();	
		
		l.setField(f);
		ln.setField(f);
		rn.setField(f);
		l.setNeighbour(ln);
		l.setNeighbour(rn);
		f.setTimer(timer);
		
		Skeleton.objects.put(l, "l:Land");
		Skeleton.objects.put(t, "t:BasicTower");
		Skeleton.objects.put(t1, "t1:BasicTower");
		Skeleton.objects.put(f, "f:Field");
		Skeleton.objects.put(timer, "timer:Timer");
		
		System.out.println("TowerOntoLand:");
		Skeleton.enabled = true;
		l.addElement(t);	
	}
	
	//TowerOntoTower
	public static void sd11() {
		Skeleton.enabled = false;
		
		Timer timer		= new Timer();
		Field field		= new Field();
		Land l 			= new Land();
		BasicTower t1	= new BasicTower();	
		BasicTower t2	= new BasicTower();
		
		field.setTimer(timer);
		l.setField(field);
		l.addElement(t1);
				
		Skeleton.objects.put(l, "l:Land");
		Skeleton.objects.put(t1, "t1:BasicTower");
		Skeleton.objects.put(t2, "t2:BasicTower");
		
		System.out.println("TowerOntoTower:");
		System.out.println("Az e:Element itt egy BasicTower (a szekvencia diagramon t1).");
		Skeleton.enabled = true;
		l.addElement(t2);
	}
	
	//TowerOntoMountain
	public static void sd12() {
		Skeleton.enabled = false;
		
		Mountain m		= new Mountain();
		BasicTower b	= new BasicTower();		
				
		Skeleton.objects.put(m, "m:Mountain");
		Skeleton.objects.put(b, "b:BasicTower");
		
		System.out.println("TowerOntoMountain:");
		Skeleton.enabled = true;
		m.addElement(b);
	}
	
	//TrapOntoRoad
	public static void sd13() {
		Skeleton.enabled = false;
		
		Cell r             = new Road();
		BasicTrap b        = new BasicTrap();
		Field b_cell_field = new Field();
				
		r.setField(b_cell_field);
		
		Skeleton.objects.put(r, "r:Road");
		Skeleton.objects.put(b, "b:BasicTrap");
		Skeleton.objects.put(b_cell_field, "b.cell.field:Field");
		
		System.out.println("TrapOntoRoad:");
		System.out.println("A cell�n nincs egy Element se, a Trap-et �res cell�ra rakjuk. Ez�rt a 5-as, 6-es h�v�s nem jelenik meg.");
		Skeleton.enabled = true;
		r.addElement(b);
	}
	
	//TrapOntoTrap
	public static void sd14() {
		Skeleton.enabled = false;
		
		Cell r       = new Road();
		BasicTrap t1 = new BasicTrap();
		BasicTrap t2 = new BasicTrap();		
		
		r.setElement(t1);
		
		Skeleton.objects.put(r, "r:Road");
		Skeleton.objects.put(t1, "t1:BasicTrap");
		Skeleton.objects.put(t2, "t2:BasicTrap");
		
		System.out.println("TrapOntoTrap:");
		Skeleton.enabled = true;
		r.addElement(t2);
	}
	
	//TrapOntoLand
	public static void sd15() {
		Skeleton.enabled = false;
		
		Land l      = new Land();
		BasicTrap b = new BasicTrap();		
				
		Skeleton.objects.put(l, "l:Land");
		Skeleton.objects.put(b, "b:BasicTrap");
		
		System.out.println("TrapOntoLand:");
		Skeleton.enabled = true;
		l.addElement(b);
	}
	
	//TrapOntoMountain
	public static void sd16() {
		Skeleton.enabled = false;
		
		Mountain m  = new Mountain();
		BasicTrap b = new BasicTrap();			
		
		Skeleton.objects.put(m, "m:Mountain");
		Skeleton.objects.put(b, "b:BasicTrap");
		
		System.out.println("TrapOntoMountain:");
		Skeleton.enabled = true;
		m.addElement(b);
	}
	
	//StoneOntoTower
	public static void sd17() {
		Skeleton.enabled = false;
		
		Field field			= new Field();
		BasicTower b		= new BasicTower();
		HumanDamageStone h	= new HumanDamageStone();
		Land l				= new Land();
		
		l.setElement(b);
		l.setField(field);
		b.setCell(l);
		
		Skeleton.objects.put(field, "f:Field");
		Skeleton.objects.put(b, "b:BasicTower");
		Skeleton.objects.put(h, "h:HumanDamageStone");
		Skeleton.objects.put(l, "b.cell:Land");
		
		System.out.println("StoneOntoTower:");
		Skeleton.enabled = true;
		b.addStone(h);
	}
	
	//StoneOntoTrap
	public static void sd18() {
		Skeleton.enabled = false;
		
		BasicTrap b			= new BasicTrap();
		Road r				= new Road();
		RetentiveStone s	= new RetentiveStone();
		Field b_cell_field	= new Field();
		
		r.setElement(b);
		r.setField(b_cell_field);
		b.setCell(r);
		
		Skeleton.objects.put(b, "b:BasicTrap");
		Skeleton.objects.put(r, "r:Road");
		Skeleton.objects.put(s, "s:RetentiveStone");
		Skeleton.objects.put(b_cell_field, "b.cell.field:Field");
		
		System.out.println("StoneOntoTrap:");
		Skeleton.enabled = true;
		b.addStone(s);
	}
}
