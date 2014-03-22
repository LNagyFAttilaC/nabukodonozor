package nabukodonozor;

public class BasicTrap extends Trap {
	private int slow;
	
	public BasicTrap() {
		Object[] params = {};
		Skeleton.entry("b", "BasicTrap", "BasicTrap", params);
		Skeleton.entry(this, "BasicTrap()", params);
		
		Skeleton.exit("void");
	}
}
