package nabukodonozor;

public abstract class StoneToTrap extends Stone implements InteractWithTrap {
	//toronyra kerulhet-e
	public boolean accept(Tower t) {
		return false;
	}
	
	//csapdara kerulhet-e
	public boolean accept(Trap t) {
		//hatas kifejtese
		t.act_bridge(this);
		
		//hozzaadas
		t.setStone(this);
		
		//mana csokkentese
		Cell c 	= t.getCell();
		Field f = c.getField();
		f.decreaseMana(price);
		
		return true;
	}
	
	//interakcio BasicTrap-pel
	public abstract void act(BasicTrap t);
}