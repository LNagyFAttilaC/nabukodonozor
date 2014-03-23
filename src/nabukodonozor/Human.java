package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public class Human extends Enemy {
	public Human() {
		life	= 0;
		value	= 0;
		speed	= new ArrayList<Integer>();
		
		// kiiratas a standard outputra a statikus entry fv.-nyel
		Object[] params = {};
		Skeleton.entry(this, "Human()", params);
	}
	
	protected void act_bridge(List<Element> elements) {
		for (Element e : elements) {
			e.act(this);
		}
	}

	@Override
	protected void improveBullet_bridge(StoneToTower s, Bullet b) {
		
	}
}
