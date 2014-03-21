package nabukodonozor;

public class Hobbit extends Enemy{

	public Hobbit(){
		life = 0;
		value = 0;
		speed = null;
		// kiiratas a standard outputra a statikus entry fv.-nyel
		String[] params = {};
		Skeleton.entry("h", "Hobbit", "Hobbit", params);
	}
	
}
