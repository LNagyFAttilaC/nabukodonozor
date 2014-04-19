package nabukodonozor;

public class RetentiveStone extends StoneToTrap {
	//interakcio BasicTrap-pel			PETI
	public void act(BasicTrap b) {
		int slow = b.getSlow();
		b.setSlow(slow+value);
	}
}
