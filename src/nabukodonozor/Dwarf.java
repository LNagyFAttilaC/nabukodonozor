package nabukodonozor;

import java.util.ArrayList;

public class Dwarf extends Enemy {
	public Dwarf() {
		life	= 0;
		value	= 0;
		speed	= new ArrayList<Integer>();
		
		// kiiratas a standard outputra a statikus entry fv.-nyel
		Object[] params = {};
		Skeleton.entry(this, "Dwarf()", params);
	}
}
