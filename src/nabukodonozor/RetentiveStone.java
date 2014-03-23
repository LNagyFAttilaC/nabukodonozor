package nabukodonozor;

public class RetentiveStone extends StoneToTrap {
	//interakcio BasicTrap-pel
	public void act(BasicTrap b) {
		Object[] params = {b};
		Skeleton.entry(this, "act(BasicTrap b)", params);
		
		int slow = b.getSlow();
		b.setSlow(slow+value);
		
		Skeleton.exit("void");
	}
}
