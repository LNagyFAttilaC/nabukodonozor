package nabukodonozor;

import java.util.Scanner;

public class Program
{	
	public static void main(String[] args)
	{
		//a "lista"
		String[] sequences = 	{"Initialization",
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
		for (int i=0; i<sequences.length; i++)
		{
			if (i+1<10)
			{
				System.out.print(" ");
			}
			
			System.out.println((i+1) + "\t" + sequences[i]);
		}
		
		System.out.println("\nA lefuttatni kívánt szekvencia diagram sorszáma: ");
		
		//válasz beolvasása
		Scanner in	= new Scanner(System.in);
		int sd		= in.nextInt();
		in.close();
		
		//megfelelő függvény meghívása
		switch (sd)
		{
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
		default:
			System.out.println("Érvénytelen bemenet!");
		break;
		}
	}
}
