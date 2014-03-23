package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public class Hobbit extends Enemy {
	//konstruktor
	public Hobbit() {
		Object[] params = {};
		Skeleton.entry(null, "Hobbit()", params);
		
		life	= 0;
		value	= 0;
		speed	= new ArrayList<Integer>();
		
		Skeleton.exit("hobbit");
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
