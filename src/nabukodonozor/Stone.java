package nabukodonozor;

public abstract class Stone implements Incompatibility {
	protected int price = 0; //ar
	protected int value = 0; //ertek
	
	//ellensegre kerulhet-e
	public boolean accept(Enemy e){
		Object[] params = {e};
		Skeleton.entry(this, "accept(Enemy e)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	//detektorra kerulhet-e
	public boolean accept(Detector d){
		Object[] params = {d};
		Skeleton.entry(this, "accept(Detector e)", params);
		
		Skeleton.exit("false");
		
		return false;
	}
	
	//toronyra kerulhet-e
	public abstract boolean accept(Tower t);
	
	//csapdara kerulhet-e
	public abstract boolean accept(Trap t);
}
