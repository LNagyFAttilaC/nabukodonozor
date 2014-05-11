package nabukodonozor;

public class HobbitDamageStone extends StoneToTower {
	public static int default_price = 275;

	//konstruktor
	public HobbitDamageStone() {
		value = 10;
		price = default_price;
	}
	
	//interakcio BasicTower-rel
	public void act(BasicTower b) {
		return;
	}
	
	//hobbit-specifikus kovel lovedek fejlesztese
	public void improveBullet(Bullet b, Hobbit d) {
		b.increaseDamage(value);
	}
}
