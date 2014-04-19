package nabukodonozor;

public class BasicTower extends Tower {
	//konstruktor
	public BasicTower(){
		super();
		radius		= 1;
		frequency	= 5;
		damage		= 10;
		price		= 80;
	}
	
	//celpont kivalasztasa: Kire lojon a torony a targets-bol?
	protected Enemy selectTarget() {
		return targets.get(0);
	}
	
	//segedmetodus
	protected void act_bridge(StoneToTower s) {
		s.act(this);
	}
}