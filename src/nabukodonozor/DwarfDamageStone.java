package nabukodonozor;

public class DwarfDamageStone extends StoneToTower {
	//interakcio BasicTower-rel
	public void act(BasicTower b) {
		Object[] params = {b};
		Skeleton.entry(this, "act(BasicTower b)", params);
		
		Skeleton.exit("void");
	}
	
	//torp-specifikus kovel lovedek fejlesztese
	public void improveBullet(Bullet b, Dwarf d) {
		Object[] params = {b, d};
		Skeleton.entry(this, "improveBullet(Bullet b, Dwarf d)", params);
		
		b.increaseDamage(value);
		
		Skeleton.exit("void");
	}
}
