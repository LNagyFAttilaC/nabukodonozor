package nabukodonozor;

import grafikus.BasicTowerView;

public class BasicTower extends Tower {
	public static int default_price = 80;
	
	//konstruktor
	public BasicTower(){
		super();
		view		= new BasicTowerView(this);
		radius		= 1;
		frequency	= 5;
		damage		= 10;
		price		= default_price;
	}
	
	//celpont kivalasztasa: Kire lojon a torony a targets-bol?
	protected Enemy selectTarget() {
		if (targets.size() != 0) {
			return targets.get(0);
		}
		else {
			return null;
		}
	}
	
	//segedmetodus
	protected void act_bridge(StoneToTower s) {
		s.act(this);
	}
}