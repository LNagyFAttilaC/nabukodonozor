package nabukodonozor;

public class HumanDamageStone extends StoneToTower {
	public static int default_price = 350;

	//konstruktor
	public HumanDamageStone() {
		value = 10;
		price = default_price;
	}
	
	//interakcio BasicTower-rel
	public void act(BasicTower b) {
		return;
	}
	
	//tunde-specifikus kovel lovedek fejlesztese
	public void improveBullet(Bullet b, Human d) {
		b.increaseDamage(value);
	}
}
