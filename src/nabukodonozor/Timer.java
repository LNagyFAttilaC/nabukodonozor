package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public class Timer {
	private List<Active> actives; //aktiv elemek
	
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
}
