package nabukodonozor;

public class HumanDamageStone extends StoneToTower{

	public void act(BasicTower b){
		Object[] params = {b};
		Skeleton.entry(this, "act(BasicTower)", params);
	}
	
	public void improveBullet(Bullet b, Human h){
		Object[] params = {b, h};
		Skeleton.entry(this, "improveBullet(Bullet b, Human h)", params);
	}

}
