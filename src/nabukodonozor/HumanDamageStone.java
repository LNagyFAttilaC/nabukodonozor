package nabukodonozor;

public class HumanDamageStone extends StoneToTower {
	//konstruktor
	public HumanDamageStone() {
		value = 10;
		price = 350;
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
