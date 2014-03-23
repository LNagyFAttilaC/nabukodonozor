package nabukodonozor;

public class BasicTrap extends Trap {
	private int slow;
	
	public BasicTrap() {
		Object[] params = {};
		Skeleton.entry(this, "BasicTrap()", params);
		
		Skeleton.exit("void");
	}
	
	protected void act_bridge(StoneToTrap s) {
		s.act(this);
	}
}
