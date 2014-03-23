package nabukodonozor;

public class HobbitDamageStone extends StoneToTower{
	public void act(BasicTower b){
		
	}
	
	public void improveBullet(Bullet b, Hobbit h){
		Object[] params = {b, h};
		Skeleton.entry(this, "improveBullet(Bullet b, Hobbit h)", params);
		
		b.increaseDamage(value);
		
		Skeleton.exit("void");
	}
}
