package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public class Dwarf extends Enemy {
	public Dwarf() {
		life	= 0;
		value	= 0;
		speed	= new ArrayList<Integer>();
		
		Object[] params = {};
		Skeleton.entry(this, "Dwarf()", params);
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
