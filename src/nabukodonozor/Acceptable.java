package nabukodonozor;

public interface Acceptable {
	//utra kerulhet-e
	public boolean accept(Road r);
	
	//mezore kerulhet-e
	public boolean accept(Land l);
	
	//hegyre kerulhet-e
	public boolean accept(Mountain m);
}