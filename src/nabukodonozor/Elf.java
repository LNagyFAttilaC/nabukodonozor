package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public class Elf extends Enemy {
	//konstruktor
	public Elf() {
		Object[] params = {};
		Skeleton.entry(null, "Elf()", params);
		
		life	= 0;
		value	= 0;
		speed	= new ArrayList<Integer>();
		
		Skeleton.exit("elf");
	}
	
	//segedmetodus
	protected void act_bridge(List<Element> elements) {
		for (Element e : elements) {
			e.act(this);
		}
	}
	
	//segedmetodus
	protected void improveBullet_bridge(StoneToTower s, Bullet b) {
		s.improveBullet(b, this);
	}
}
