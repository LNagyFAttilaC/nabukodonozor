package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public class Timer {
	private List<Active> actives; //aktiv elemek
	private Field field;
	
	//konstruktor
	public Timer() {
		Object[] params = {};
		Skeleton.entry(null, "Timer()", params);

		actives = new ArrayList<Active>();
		
		Skeleton.exit("timer");
	}
	
	//teendok minden utemben
	public void tick() {
		actives.get(0).tick();
		if (field.getDied() == field.getAllEnemies())
			field.win();
	}
	
	//aktiv elem hozzaadasa
	public void addActive(Active a)	{
		Object[] params = {a};
		Skeleton.entry(this, "addActive(Active a)", params);
		
		actives.add(a);
		
		Skeleton.exit("void");
	}
	
	//aktiv elem eltavolitasa
	public void removeActive(Active a) {
		Object[] params = {a};
		Skeleton.entry(this, "removeActive(Active a)", params);
		
		actives.remove(a);
		
		Skeleton.exit("void");
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
