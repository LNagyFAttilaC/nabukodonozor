package nabukodonozor;

public abstract class StoneToTrap extends Stone implements InteractWithTrap {
	
	@Override
	public boolean accept(Tower t) {
		Skeleton.entry("s", "StoneToTrap", "accept", new String[] {"t:Tower"});
		Skeleton.exit("false");
		return false;
	}
	
	@Override
	public boolean accept(Trap t) {
		Skeleton.entry("s", "StoneToTrap", "accept", new String[] {"t:Trap"});
		act(t);
		t.getCell().getField().decreaseMana(price);
		Skeleton.exit("true");
		return true;
	}
	
	public abstract void act(BasicTrap t);
	
}