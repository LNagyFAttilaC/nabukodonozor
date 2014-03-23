package nabukodonozor;

public abstract class StoneToTrap extends Stone implements InteractWithTrap {
	
	@Override
	public boolean accept(Tower t) {
		Object[] params = {t};
		Skeleton.entry(this, "accept(Tower t)", params);
		Skeleton.exit("false");
		return false;
	}
	
	@Override
	public boolean accept(Trap t) {
		Object[] params = {t};
		Skeleton.entry(this, "accept(Trap t)", params);
		
		t.act_bridge(this);
		t.setStone(this);
		t.getCell().getField().decreaseMana(price);
		
		Skeleton.exit("true");
		return true;
	}
	
	public abstract void act(BasicTrap t);
	
}