package nabukodonozor;

import grafikus.BasicTrapView;

public class BasicTrap extends Trap {
	public static int default_price = 50;

	//konstruktor
	public BasicTrap() {
		super();
		view	= new BasicTrapView(this);
		price	= default_price;
		slow	= 100;
	}
	
	//segedmetodus
	protected void act_bridge(StoneToTrap s) {
		s.act(this);
	}
}
