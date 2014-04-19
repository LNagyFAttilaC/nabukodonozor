package nabukodonozor;

public abstract class Stone implements Incompatibility {
	protected int price; //ar
	protected int value; //ertek
	
	//ellensegre kerulhet-e
	public boolean accept(Enemy e){
		return false;
	}
	
	//detektorra kerulhet-e
	public boolean accept(Detector d){
		return false;
	}
	
	//toronyra kerulhet-e
	public abstract boolean accept(Tower t);
	
	//csapdara kerulhet-e
	public abstract boolean accept(Trap t);
}
