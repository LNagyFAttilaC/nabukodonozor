package nabukodonozor;

public class BasicTrap extends Trap {
	private int slow;
	
	public BasicTrap() {
		// kiiratas a standard outputra a statikus entry fv.-nyel
		Object[] params = {};
		Skeleton.entry(this, "BasicTrap", params);
		
		Skeleton.exit("void");
	}
	
}
