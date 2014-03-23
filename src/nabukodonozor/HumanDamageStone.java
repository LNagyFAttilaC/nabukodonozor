package nabukodonozor;

public class HumanDamageStone extends StoneToTower {
	//interakcio BasicTower-rel
	public void act(BasicTower b) {
		Object[] params = {b};
		Skeleton.entry(this, "act(BasicTower b)", params);
		
		Skeleton.exit("void");
	}
	
	//ember-specifikus kovel lovedek fejlesztese
	public void improveBullet(Bullet b, Human h) {
		Object[] params = {b, h};
		Skeleton.entry(this, "improveBullet(Bullet b, Human h)", params);
		
		b.increaseDamage(value);
		
		Skeleton.exit("void");
	}
}
