package nabukodonozor;

public class DwarfDamageStone extends StoneToTower {
	//konstruktor
	public DwarfDamageStone() {
		value = 10;
		price = 325;
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
