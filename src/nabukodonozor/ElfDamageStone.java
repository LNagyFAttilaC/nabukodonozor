package nabukodonozor;

public class ElfDamageStone extends StoneToTower {
	//interakcio BasicTower-rel
	public void act(BasicTower b) {
		Object[] params = {b};
		Skeleton.entry(this, "act(BasicTower b)", params);
		
		Skeleton.exit("void");
	}
	
	//tunde-specifikus kovel lovedek fejlesztese
	public void improveBullet(Bullet b, Elf e) {
		Object[] params = {b, e};
		Skeleton.entry(this, "improveBullet(Bullet b, Elf e)", params);
		
		b.increaseDamage(value);
		
		Skeleton.exit("void");
	}
}
