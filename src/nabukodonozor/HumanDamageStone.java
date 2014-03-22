package nabukodonozor;

public class HumanDamageStone extends StoneToTower{

	public void act(BasicTower b){
		Skeleton.entry("s", "HumanDamageStone", "act", new String[] {"b:BasicTower"});
	}
	
	public void improveBullet(Bullet b, Human h){
		Skeleton.entry("s", "HumanDamageStone", "improveBullet", new String[] {"b:Bullet", "h:Human"});
	}

}
