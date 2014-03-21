package nabukodonozor;

import java.util.Scanner;

public class Program {	
	public static void main(String[] args) {
		//a "lista"
		String[] sequences = 	{"Initialization", //1
								 "AllEnemyDies", //2
								 "EnemyEntersTheGame", //3
								 "EnemyStepOntoRoad", //4
								 "EnemyStepOntoTrap", //5
								 "EnemyGetsInRange", //6
								 "EnemyReachesMountain", //7
								 "TowerDamagesOrKillsEnemy", //8
								 "TowerOntoRoad", //9
								 "TowerOntoLand", //10
								 "TowerOntoTower", //11
								 "TowerOntoMountain", //12
								 "TrapOntoRoad", //13
								 "TrapOntoTrap", //14
								 "TrapOntoLand", //15
								 "TrapOntoMountain", //16
								 "StoneOntoTower", //17
								 "StoneOntoTrap"}; //18
		
		//a lista kiirasa
		for (int i=0; i<sequences.length; i++) {
			if (i+1<10) {
				System.out.print(" ");
			}
			
			System.out.println((i+1) + "\t" + sequences[i]);
		}
		
		System.out.println("\nA lefuttatni kívánt szekvencia diagram sorszáma: ");
		
		//valasz beolvasasa
		Scanner in	= new Scanner(System.in);
		int sd		= in.nextInt();
		in.close();
		
		//megfelelo fuggveny meghivasa
		switch (sd) {
		case  1:
			Skeleton.sd01();
		break;
		case  2:
			Skeleton.sd02();
		break;
		case  3:
			Skeleton.sd03();
		break;
		case  4:
			Skeleton.sd04();
		break;
		case  5:
			Skeleton.sd05();
		break;
		case  6:
			Skeleton.sd06();
		break;
		case  7:
			Skeleton.sd07();
		break;
		case  8:
			Skeleton.sd08();
		break;
		case  9:
			Skeleton.sd09();
		break;
		case 10:
			Skeleton.sd10();
		break;
		case 11:
			Skeleton.sd11();
		break;
		case 12:
			Skeleton.sd12();
		break;
		case 13:
			Skeleton.sd13();
		break;
		case 14:
			Skeleton.sd14();
		break;
		case 15:
			Skeleton.sd15();
		break;
		case 16:
			Skeleton.sd16();
		break;
		case 17:
			Skeleton.sd17();
		break;
		case 18:
			Skeleton.sd18();
		break;
		default:
			System.out.println("Érvénytelen bemenet!");
		break;
		}
	}
}
