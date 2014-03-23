package nabukodonozor;

import java.util.ArrayList;

public class BasicTrap extends Trap {
	private int slow;
	
	public BasicTrap() {
		Object[] params = {};
		Skeleton.entry(this, "BasicTrap()", params);
		
		stones = new ArrayList<StoneToTrap>();
		
		Skeleton.exit("void");
	}
	
	protected void act_bridge(StoneToTrap s) {
		s.act(this);
	}
}
