package nabukodonozor;

public abstract class Stone implements Incompatibility{

	protected int price = 0;
	protected int value = 0;
	
	public boolean accept(Enemy e){
		Object[] params = {e};
		Skeleton.entry(this, "accept(Enemy e)", params);
		return false;//????
	}
	
	public boolean accept(Detector d){
		Object[] params = {d};
		Skeleton.entry(this, "accept(Detector d)", params);
		return false;
	}
	
	public abstract boolean accept(Tower t);
	public abstract boolean accept(Trap t);
}
