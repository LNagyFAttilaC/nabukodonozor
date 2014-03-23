package nabukodonozor;

public abstract class StoneToTrap extends Stone implements InteractWithTrap {
	//toronyra kerulhet-e
	public boolean accept(Tower t) {
		Object[] params = {t};
		Skeleton.entry(this, "accept(Tower t)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	//csapdara kerulhet-e
	public boolean accept(Trap t) {
		Object[] params = {t};
		Skeleton.entry(this, "accept(Trap t)", params);
		
		t.act_bridge(this);
		
		//hozzaadas
		t.setStone(this);
		
		//varazsero csokkentese
		t.getCell().getField().decreaseMana(price);
		
		Skeleton.exit("true");
		
		return true;
	}
	
	//interakcio BasicTrap-pel
	public abstract void act(BasicTrap t);
}