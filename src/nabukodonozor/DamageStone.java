package nabukodonozor;

public class DamageStone extends StoneToTower {
	//konstruktor
	public DamageStone() {
		value = 10;
		price = 650;
	}
	
	//interakcio BasicTower-rel
	public void act(BasicTower b) {
		b.increaseDamage(value);
	}
}