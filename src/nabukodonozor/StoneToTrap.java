package nabukodonozor;

public abstract class StoneToTrap extends Stone implements InteractWithTrap {
	//toronyra kerulhet-e			PETI
	public boolean accept(Tower t) {
		return false;
	}
	
	//csapdara kerulhet-e			PETI
	public boolean accept(Trap t) {
		//hozzaadas
		t.setStone(this);
		
		//varazsero csokkentese
		t.getCell().getField().decreaseMana(price);
		
		t.act_bridge(this); //???
		
		return true;
	}
	
	//interakcio BasicTrap-pel
	public abstract void act(BasicTrap t);
}