package nabukodonozor;

public class ElfDamageStone extends StoneToTower {
	public static int default_price = 300;

	//konstruktor
	public ElfDamageStone() {
		value = 10;
		price = default_price;
	}
	
	//interakcio BasicTower-rel
	public void act(BasicTower b) {
		return;
	}
	
	//tunde-specifikus kovel lovedek fejlesztese
	public void improveBullet(Bullet b, Elf d) {
		b.increaseDamage(value);
	}
}
