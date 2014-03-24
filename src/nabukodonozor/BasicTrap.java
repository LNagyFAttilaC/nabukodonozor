package nabukodonozor;

import java.util.ArrayList;

public class BasicTrap extends Trap {
	//konstruktor
	public BasicTrap() {
		Object[] params = {};
		Skeleton.entry(null, "BasicTrap()", params);
		
		stones = new ArrayList<StoneToTrap>();
		
		Skeleton.exit("basictrap");
	}
	
	//segedmetodus
	protected void act_bridge(StoneToTrap s) {
		s.act(this);
	}
}
