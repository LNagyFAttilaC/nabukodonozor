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
		damage		= 3;
		price		= default_price;
	}
	
	//celpont kivalasztasa: Kire lojon a torony a targets-bol?
	protected Enemy selectTarget() {
		if (targets.size() != 0) {
			Enemy target = null;
			for (int i = 0; i < targets.size() && target == null; i++) {
				target = targets.get(i);
				
				if (target.getLife() == 0) {
					target = null;
				}
			}
			
			return target;
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