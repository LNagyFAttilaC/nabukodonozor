package nabukodonozor;

public class Dwarf extends Enemy{

	public Dwarf(){
		life = 0;
		value = 0;
		speed = null;
		// kiiratas a standard outputra a statikus entry fv.-nyel
		String[] params = {};
		Skeleton.entry("d", "Dwarf", "Dwarf", params);
	}
	
}
