package nabukodonozor;

public class RetentiveStone extends StoneToTrap {
	//konstruktor
	public RetentiveStone(){
		value = 1;
		price = 180;
	}
	
	//interakcio BasicTrap-pel			PETI
	public void act(BasicTrap b) {
		//eredeti lassitas
		int slow = b.getSlow();
		
		//uj lassitas beallitasa
		b.setSlow(slow+value);
	}
}
