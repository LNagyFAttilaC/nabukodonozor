package nabukodonozor;

public class RetentiveStone extends StoneToTrap {
	//interakcio BasicTrap-pel			PETI
	public void act(BasicTrap b) {
		//eredeti lassitas
		int slow = b.getSlow();
		
		//uj lassitas beallitasa
		b.setSlow(slow+value);
	}
}
