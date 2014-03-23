package nabukodonozor;

public interface Incompatibility {
	//torony melle kerulhet-e
	public boolean accept(Tower t);
	
	//csapda melle kerulhet-e
	public boolean accept(Trap t);
	
	//ellenseg melle kerulhet-e
	public boolean accept(Enemy e);
	
	//detektor melle kerulhet-e
	public boolean accept(Detector d);
}
