package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public class Elf extends Enemy {
	public Elf() {
		life	= 0;
		value	= 0;
		speed	= new ArrayList<Integer>();
		
		Object[] params = {};
		Skeleton.entry(this, "Elf()", params);
	}
	
	protected void act_bridge(List<Element> elements) {
		for (Element e : elements) {
			e.act(this);
		}
	}

	protected void improveBullet_bridge(StoneToTower s, Bullet b) {
		
	}

	public void act(Dwarf d) {
		
	}

	public void act(Elf e) {
		
	}

	public void act(Hobbit h) {
		
	}

	public void act(Human h) {
		
	}
}
