package nabukodonozor;

import java.util.ArrayList;

public class BasicTrap extends Trap {
	//konstruktor
	public BasicTrap() {
		Object[] params = {};
		Skeleton.entry(this, "BasicTrap()", params);
		
		stones = new ArrayList<StoneToTrap>();
		
		Skeleton.exit("void");
	}
	
	//seg�dmet�dus
	protected void act_bridge(StoneToTrap s) {
		s.act(this);
	}
}
