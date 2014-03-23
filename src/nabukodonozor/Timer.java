package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public class Timer {
	private List<Active> actives;
	
	public Timer() {
		actives = new ArrayList<Active>();
	}
	
	public void tick() {
		Object[] params = {};
		Skeleton.entry(this, "tick()", params);
		
		actives.get(0).tick();
		
		Skeleton.exit("void");
	}
	
	public void addActive(Active a)	{
		Object[] params = {a};
		Skeleton.entry(this, "addActive(Active a)", params);
		
		actives.add(a);
		
		Skeleton.exit("void");
	}
	
	public void removeActive(Active a) {
		Object[] params = {a};
		Skeleton.entry(this, "removeActive(Active a)", params);
		
		actives.remove(a);
		
		Skeleton.exit("void");
	}
}
