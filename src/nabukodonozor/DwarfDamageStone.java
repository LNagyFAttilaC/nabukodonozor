package nabukodonozor;

public class DwarfDamageStone extends StoneToTower {
	public static int default_price = 325;

	//konstruktor
	public DwarfDamageStone() {
		value = 10;
		price = default_price;
	}
	
	//interakcio BasicTower-rel
	public void act(BasicTower b) {
		return;
	}
	
	//torp-specifikus kovel lovedek fejlesztese
	public void improveBullet(Bullet b, Dwarf d) {
		b.increaseDamage(value);
	}
}
