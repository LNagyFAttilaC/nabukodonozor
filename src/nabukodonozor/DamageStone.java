package nabukodonozor;

public class DamageStone extends StoneToTower{
	//interakci� BasicTower-rel
	public void act(BasicTower b){
		Object[] params = {b};
		Skeleton.entry(this, "act(BasicTower b)", params);
		
		Skeleton.exit("void");
	}
}
