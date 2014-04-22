package nabukodonozor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
	//CSAK A PROTOTIPUSBAN HASZNALATOS SEGEDVALTOZOK
	//A VELETLENSZERU MUKODES DETERMINISZTIKUSSA TETELERE
	public static int _PROTO_TOWER_BULLET = 0; //0 = sima lovedek; 1 = kettevago lovedek
	public static int _PROTO_ENEMY_DIRECTION = 0; //0 = fel; 1 = jobbra; 2 = le; 3 = balra
	
	public static final String[] commandNames = {"ADDTOCELL", "ADDTOFIELD", "ADDTOTOWER", "ADDTOTRAP", "SHOOTWITH",
													"STEPENEMY", "TICK", "DUMPMAP", "MANA", "DRAWMAP", "DUMPTEXT"};
	
	public static void main(String[] args) {
		System.out.println("Udvozoljuk a Prototipus programban!\n");
		
		String[]command = null;
		BufferedReader br = null;
		try {
			System.out.println("Adja meg, hogy melyik terkep-fajlt szeretne hasznalni!");
			System.out.println("Csak a fajl nevet adja meg, a kiterjeszteset ne!");
			System.out.println("A .txt fajlnak a map konyvtarban kell lennie!");
			br = new BufferedReader(new InputStreamReader(System.in));
			String mapname = br.readLine();
			Parser.setField(new Field(mapname));
			
			System.out.println("\nAdja meg, hogy konzolon vagy fajlban kivanja megadni a parancsokat!");
			System.out.println("Ha konzolon, irja be, hogy \"konzol\", ha fájlban, akkor a fajl nevet, kiterjesztes nelkul!");
			System.out.println("A .txt fajlnak a cmd konyvtarban kell lennie!");
			br = new BufferedReader(new InputStreamReader(System.in));
			String mode = br.readLine();
			
			if (mode.equals("konzol")) {
				br = new BufferedReader(new InputStreamReader(System.in));
				
				System.out.println("\nJohetnek a parancsok:");
			}
			else {
				br = new BufferedReader(new FileReader("cmd/" + mode + ".txt"));
				
				System.out.println();
			}
			
			while (true) {
				String line = br.readLine();
				
				if (line == null) {
					break;
				}
				
				command = line.split(" ");
				
				if (command[0].equals(commandNames[0])) { // ADDTOCELL
					if (command.length != 4) {
						System.out.println("Rosszul parameterezett parancs.");
					}
					else {
						Parser.ADDTOCELL(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
					}
				}
				else if (command[0].equals(commandNames[1])) { // ADDTOFIELD
					if (command.length != 4) {
						System.out.println("Rosszul parameterezett parancs.");
					}
					else {
						Parser.ADDTOFIELD(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
					}
				}
				else if (command[0].equals(commandNames[2])) { // ADDTOTOWER
					if (command.length != 4) {
						System.out.println("Rosszul parameterezett parancs.");
					}
					else {
						Parser.ADDTOTOWER(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
					}
				}
				else if (command[0].equals(commandNames[3])) { // ADDTOTRAP
					if (command.length != 4) {
						System.out.println("Rosszul parameterezett parancs.");
					}
					else {
						Parser.ADDTOTRAP(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
					}
					
				}
				else if (command[0].equals(commandNames[4])) { // SHOOTWITH
					if (command.length != 4) {
						System.out.println("Rosszul parameterezett parancs.");
					}
					else {
						Parser.SHOOTWITH(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
					}
				}
				else if (command[0].equals(commandNames[5])) { // STEPENEMY
					if (command.length != 2) {
						System.out.println("Rosszul parameterezett parancs.");
					}
					else {
						Parser.STEPENEMY(command[1]);
					}
				}
				else if (command[0].equals(commandNames[6])) { // TICK
					if (command.length != 2) {
						System.out.println("Rosszul parameterezett parancs.");
					}
					else {
						Parser.TICK(Integer.parseInt(command[1]));
					}
				}
				else if (command[0].equals(commandNames[7])) { // DUMPMAP
					if (command.length != 1) {
						System.out.println("Rosszul parameterezett parancs.");
					}
					else {
						Parser.DUMPMAP();
					}
				}
				else if (command[0].equals(commandNames[8])) { // MANA
					if (command.length != 1 && command.length != 2) {
						System.out.println("Rosszul parameterezett parancs.");
					}
					else {
						if (command.length == 1) {
							Parser.MANA();
						}
						else if (command.length == 2) {
							Parser.MANA(Integer.parseInt(command[1]));
						}
					}
				}
				else if (command[0].equals(commandNames[9])) { // DRAWMAP
					if (command.length != 1) {
						System.out.println("Rosszul parameterezett parancs.");
					}
					else {	
						Parser.DRAWMAP();
					}
				}
				else if (command[0].equals(commandNames[10])) { // DUMPTEXT
					if (command.length != 1) {
						System.out.println("Rosszul parameterezett parancs.");
					}
					else {	
						Parser.DUMPTEXT();
					}
				}
				else { // egyéb
					System.out.println("Nem ertelmezheto parancs.");
				}
			}
		}
		catch (IOException e) {
			System.out.println("\nA megadott fajl hibas vagy nem is letezik.");
		}
		finally {
			try {
				br.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
