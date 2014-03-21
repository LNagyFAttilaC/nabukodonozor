package nabukodonozor;

import java.util.ArrayList;

public class Hobbit extends Enemy {
	public Hobbit() {
		life	= 0;
		value	= 0;
		speed	= new ArrayList<Integer>();
		
		// kiiratas a standard outputra a statikus entry fv.-nyel
		String[] params = {};
		Skeleton.entry("h", "Hobbit", "Hobbit", params);
	}
}
