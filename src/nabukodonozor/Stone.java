package nabukodonozor;

public abstract class Stone implements Incompatibility{

	protected int price = 0;
	protected int value = 0;
	
	public boolean accept(Enemy e){
		Skeleton.entry("s", "Stone", "accept", new String[] {"e:Enemy"});
		return false;//????
	}
	
	public boolean accept(Detector d){
		Skeleton.entry("s", "Stone", "accept", new String[]{"d:Detector"});
		return false;
	}
	
	public abstract boolean accept(Tower t);
	public abstract boolean accept(Trap t);
}
