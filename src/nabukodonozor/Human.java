package nabukodonozor;

import java.util.ArrayList;

public class Human extends Enemy {
	public Human() {
		life	= 0;
		value	= 0;
		speed	= new ArrayList<Integer>();
		
		// kiiratas a standard outputra a statikus entry fv.-nyel
		String[] params = {};
		Skeleton.entry("h", "Human", params);
	}
}
