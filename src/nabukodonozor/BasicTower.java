package nabukodonozor;

public class BasicTower extends Tower {
	public BasicTower(){
		Object[] params = {};
		Skeleton.entry(this, "BasicTower()", params);
		Skeleton.exit("void");
	}
	
	protected Enemy selectTarget() {
		Object[] params = {};
		Skeleton.entry(this, "selectTarget()", params);
		
		Skeleton.exit("h");
		
		return targets.get(0);
	}
}