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
		if (enabled)
		{
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
		if (enabled)
		{
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
		System.out.println("sd02()");
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
		t.addActive(h);
		h.setCell(h_cell);
		h_cell.setNeighbour(r);
		
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
		System.out.println("sd05()");
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
		
		Skeleton.enabled = true;
		t.tick();
	}
	
	//EnemyReachesMountain
	public static void sd07() {
		System.out.println("sd07()");
	}
	
	//TowerDamagesOrKillsEnemy
	public static void sd08() {
		System.out.println("sd08()");
	}
	
	//TowerOntoRoad
	public static void sd09() {
		System.out.println("sd09()");
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
		System.out.println("sd12()");
	}
	
	//TrapOntoRoad
	public static void sd13() {
		System.out.println("sd13()");
	}
	
	//TrapOntoTrap
	public static void sd14() {
		System.out.println("sd14()");
	}
	
	//TrapOntoLand
	public static void sd15() {
		System.out.println("sd15()");
	}
	//TrapOntoMountain
	public static void sd16() {
		System.out.println("sd16()");
	}
	
	//StoneOntoTower
	public static void sd17() {
		System.out.println("sd17()");
	}
	//StoneOntoTrap
	public static void sd18() {
		System.out.println("sd18()");
	}
}
