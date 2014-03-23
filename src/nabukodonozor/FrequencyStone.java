package nabukodonozor;

public class FrequencyStone extends StoneToTower {
	//interakció BasicTower-rel
	public void act(BasicTower b) {
		Object[] params = {b};
		Skeleton.entry(this, "act(BasicTower b)", params);
		
		Skeleton.exit("void");
	}
}