package nabukodonozor;

public class HobbitDamageStone extends StoneToTower {
	//konstruktor
	public HobbitDamageStone() {
		value = 10;
		price = 275;
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
