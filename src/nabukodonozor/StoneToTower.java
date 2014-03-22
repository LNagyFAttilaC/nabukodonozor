package nabukodonozor;

public abstract class StoneToTower extends Stone implements InteractWithTower{

	public abstract void act(BasicTower b);
	
	public boolean accept(Tower t){
		Skeleton.entry("s", "StoneToTower", "accept", new String[] {"t:Tower"});
		return true;
	}
	
	public boolean accept(Trap t){
		Skeleton.entry("s", "StoneToTower", "accept", new String[] {"t:Trap"});
		return false;
	}
}
