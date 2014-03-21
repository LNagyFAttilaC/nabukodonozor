package nabukodonozor;

public class Elf extends Enemy{

	public Elf(){
		life = 0;
		value = 0;
		speed = null;
		// kiiratas a standard outputra a statikus entry fv.-nyel
		String[] params = {};
		Skeleton.entry("e","Elf","Elf", params);
	}
	
	
}
