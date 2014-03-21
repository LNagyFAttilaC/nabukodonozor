package nabukodonozor;

import java.util.Scanner;

public class Program {	
	public static void main(String[] args)
	{
		//a "lista"
		String[] useCases = 	{"Initialization",
								 "AllEnemyDies",
								 "EnemyEntersTheGame",
								 "EnemyStepOntoRoad",
								 "EnemyStepOntoTrap",
								 "EnemyGetsInRange",
								 "EnemyReachesMountain",
								 "TowerDamagesOrKillsEnemy",
								 "TowerOntoRoad",
								 "TowerOntoLand",
								 "TowerOntoTower",
								 "TowerOntoMountain",
								 "TrapOntoRoad",
								 "TrapOntoTrap",
								 "TrapOntoLand",
								 "TrapOntoMountain",
								 "StoneOntoTower",
								 "StoneOntoTrap"};
		
		//a lista kiírása
		for (int i=0; i<useCases.length; i++)
		{
			if (i+1<10)
			{
				System.out.print(" ");
			}
			
			System.out.println((i+1) + "\t" + useCases[i]);
		}
		
		System.out.println("\nA lefuttatni kívánt use-case sorszáma: ");
		
		//válasz beolvasása
		Scanner in	= new Scanner(System.in);
		int uc		= in.nextInt();
		in.close();
		
		//megfelelő függvény meghívása
		switch (uc)
		{
		case  1:
			Skeleton.uc01();
		break;
		case  2:
			Skeleton.uc02();
		break;
		case  3:
			Skeleton.uc03();
		break;
		case  4:
			Skeleton.uc04();
		break;
		case  5:
			Skeleton.uc05();
		break;
		case  6:
			Skeleton.uc06();
		break;
		case  7:
			Skeleton.uc07();
		break;
		case  8:
			Skeleton.uc08();
		break;
		case  9:
			Skeleton.uc09();
		break;
		case 10:
			Skeleton.uc10();
		break;
		case 11:
			Skeleton.uc11();
		break;
		case 12:
			Skeleton.uc12();
		break;
		case 13:
			Skeleton.uc13();
		break;
		case 14:
			Skeleton.uc14();
		break;
		case 15:
			Skeleton.uc15();
		break;
		case 16:
			Skeleton.uc16();
		break;
		default:
			System.out.println("Érvénytelen bemenet!");
		break;
		}
	}
}
