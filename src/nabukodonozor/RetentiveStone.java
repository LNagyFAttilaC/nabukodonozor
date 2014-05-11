package nabukodonozor;

public class RetentiveStone extends StoneToTrap {
	public static int default_price = 180;

	//konstruktor
	public RetentiveStone(){
		value = 1;
		price = default_price;
	}
	
	//interakcio BasicTrap-pel
	public void act(BasicTrap b) {
		//eredeti lassitas
		int slow = b.getSlow();
		
		//uj lassitas beallitasa
		b.setSlow(slow+value);
	}
}
