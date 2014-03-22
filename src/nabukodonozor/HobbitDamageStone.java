package nabukodonozor;

public class HobbitDamageStone extends StoneToTower{

	public void act(BasicTower b){
		Skeleton.entry("s", "HobbitDamageStone", "act", new String[] {"b:BasicTower"});
	}
	
	public void improveBullet(Bullet b, Hobbit h){
		Skeleton.entry("s", "HobbitDamageStone", "improveBullet", new String[] {"b:Bullet", "h:Hobbit"});
	}

}
