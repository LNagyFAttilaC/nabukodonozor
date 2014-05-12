package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public class Timer {
	private List<Active> actives; //aktiv elemek
	private Field field;
	
	//konstruktor
	public Timer() {
		actives = new ArrayList<Active>();
	}
	
	//teendok minden utemben
	public void tick() {
		for (int i=0; i<actives.size(); i++) {
			actives.get(i).tick();
		}
		
		System.out.println("meghalt: " + field.getDied() + " �sszes: " + field.getAllEnemies());
		
		if (field.getDied() == field.getAllEnemies()) {
			field.win();
		}
	}
	
	//aktiv elem hozzaadasa
	public void addActive(Active a)	{
		actives.add(a);
	}
	
	//aktiv elem eltavolitasa
	public void removeActive(Active a) {
		if (actives.contains(a)) {
			System.out.println("akt�v t�r�lve: " + a.getClass() + " �lete: " + ((Enemy)a).getLife());
			
			actives.remove(a);
		}
	}
	
	//getter: Field
	public Field getField() {
		return field;
	}
	
	//setter: Field
	public void setField(Field f) {
		field = f;
	}
}