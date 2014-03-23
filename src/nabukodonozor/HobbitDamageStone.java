package nabukodonozor;

public class HobbitDamageStone extends StoneToTower {
	//interakcio BasicTower-rel
	public void act(BasicTower b) {
		Object[] params = {b};
		Skeleton.entry(this, "act(BasicTower b)", params);
		
		Skeleton.exit("void");
	}
	
	//hobbit-specifikus kovel lovedek fejlesztese
	public void improveBullet(Bullet b, Hobbit h) {
		Object[] params = {b, h};
		Skeleton.entry(this, "improveBullet(Bullet b, Hobbit h)", params);
		
		b.increaseDamage(value);
		
		Skeleton.exit("void");
	}
}
