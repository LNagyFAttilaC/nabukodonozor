package nabukodonozor;

import java.util.ArrayList;
import java.util.List;

public class Hobbit extends Enemy {
	public Hobbit() {
		life	= 0;
		value	= 0;
		speed	= new ArrayList<Integer>();
		
		Object[] params = {};
		Skeleton.entry(this, "Hobbit()", params);
		
		Skeleton.exit("void");
	}
	
	protected void act_bridge(List<Element> elements) {
		for (Element e : elements) {
			e.act(this);
		}
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
