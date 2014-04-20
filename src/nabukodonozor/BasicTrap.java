package nabukodonozor;

public class BasicTrap extends Trap {
	//konstruktor
	public BasicTrap() {
		super();
		price	= 50;
		slow	= 2;
	}
	
	//segedmetodus
	protected void act_bridge(StoneToTrap s) {
		s.act(this);
	}
}
