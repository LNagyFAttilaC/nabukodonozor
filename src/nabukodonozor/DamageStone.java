package nabukodonozor;

public class DamageStone extends StoneToTower {
	public static int default_price = 650;

	//konstruktor
	public DamageStone() {
		value = 10;
		price = default_price;
	}
	
	//interakcio BasicTower-rel
	public void act(BasicTower b) {
		b.increaseDamage(value);
	}
}