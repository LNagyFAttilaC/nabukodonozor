package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public class Timer {
	private List<Active> actives; //aktiv elemek
	
	//konstruktor
	public Timer() {
		actives = new ArrayList<Active>();
	}
	
	//teendok minden utemben
	public void tick() {
		actives.get(0).tick();
	}
	
	//aktiv elem hozzaadasa
	public void addActive(Active a)	{
		actives.add(a);
	}
	
	//aktiv elem eltavolitasa
	public void removeActive(Active a) {
		actives.remove(a);
	}
}
