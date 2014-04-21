package nabukodonozor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Program {	
	private static final String[] commandNames = {"ADDTOCELL","ADDTOFIELD","ADDTOTOWER","ADDTOTRAP","SHOOTWITH",
													"STEPENEMY","TICK","DUMPMAP","MANA"};
	
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
		
		System.out.println("Udvozoljuk a Skeleton programban!\n");
		
		//a lista kiirasa
		for (int i=0; i<sequences.length; i++) {
			if (i+1<10) {
				System.out.print(" ");
			}
			
			System.out.println((i+1) + "\t" + sequences[i]);
		}
		
		System.out.println("\nA lefuttatni kivant szekvencia diagram sorszama: ");
		
		//valasz beolvasasa
		/*Scanner in	= new Scanner(System.in);
		int sd		= in.nextInt();
		in.close();*/
		int sd = 0;
		
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
			System.out.println("Ervenytelen bemenet!");
		break;
		}
		
		String[]command = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			while(true){
				String line = br.readLine();
				command = line.split(" ");
				
				if(command[0].equals(commandNames[0])){ // ADDTOCELL
					if(command.length != 4){
						System.out.println("Rosszul parameterezett parancs.");
					}
					else{
						Parser.ADDTOCELL(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
					}
				}
				else if(command[0].equals(commandNames[1])){ // ADDTOFIELD
					if(command.length != 4){
						System.out.println("Rosszul parameterezett parancs.");
					}
					else{
						Parser.ADDTOFIELD(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
					}
				}
				else if(command[0].equals(commandNames[2])){ // ADDTOTOWER
					if(command.length != 4){
						System.out.println("Rosszul parameterezett parancs.");
					}
					else{
						Parser.ADDTOTOWER(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
					}
				}
				else if(command[0].equals(commandNames[3])){ // ADDTOTRAP
					if(command.length != 4){
						System.out.println("Rosszul parameterezett parancs.");
					}
					else{
						Parser.ADDTOTRAP(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
					}
					
				}
				else if(command[0].equals(commandNames[4])){ // SHOOTWITH
					if(command.length != 4){
						System.out.println("Rosszul parameterezett parancs.");
					}
					else{
						Parser.SHOOTWITH(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
					}
				}
				else if(command[0].equals(commandNames[5])){ // STEPENEMY
					if(command.length != 2){
						System.out.println("Rosszul parameterezett parancs.");
					}
					else{
						Parser.STEPENEMY(command[1]);
					}
				}
				else if(command[0].equals(commandNames[6])){ // TICK
					if(command.length != 2){
						System.out.println("Rosszul parameterezett parancs.");
					}
					else{
						Parser.TICK(Integer.parseInt(command[1]));
					}
				}
				else if(command[0].equals(commandNames[7])){ // DUMPMAP
					if(command.length != 1){
						System.out.println("Rosszul parameterezett parancs.");
					}
					else{
						Parser.DUMPMAP();
					}
				}
				else if(command[0].equals(commandNames[8])){ // MANA
					if(command.length != 2){
						System.out.println("Rosszul parameterezett parancs.");
					}
					else{
						Parser.MANA(Integer.parseInt(command[1]));
					}
				}
				else{ // egyéb
					System.out.println("Nem ertelmezheto parancs.");
				}
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		catch(IllegalArgumentException iae){
			System.out.println("Kasztolasi hiba miatt a program leallt.");
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
