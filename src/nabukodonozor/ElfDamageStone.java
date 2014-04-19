package nabukodonozor;

public class ElfDamageStone extends StoneToTower {
	//konstruktor
	public ElfDamageStone() {
		value = 10;
		price = 300;
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
