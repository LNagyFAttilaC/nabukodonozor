package nabukodonozor;

public class FrequencyStone extends StoneToTower {
	public static int default_price = 700;

	//konstruktor
	public FrequencyStone() {
		value = 1;
		price = default_price;
	}
	
	//interakcio BasicTower-rel
	public void act(BasicTower b) {
		b.increaseFrequency(value);
	}
}