package nabukodonozor;

import java.util.ArrayList;

public class BasicTrap extends Trap {
	//konstruktor
	public BasicTrap() {
		price	= 50;
		slow	= 2;
		stones  = new ArrayList<StoneToTrap>();
	}
	
	//segedmetodus
	protected void act_bridge(StoneToTrap s) {
		s.act(this);
	}
}
