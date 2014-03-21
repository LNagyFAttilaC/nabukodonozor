package nabukodonozor;

public class Human extends Enemy{

	public Human(){
		life = 0;
		value = 0;
		speed = null;
		// kiiratas a standard outputra a statikus entry fv.-nyel
		String[] params = {};
		Skeleton.entry("h", "Human", "Human", params);
	}
	
}
