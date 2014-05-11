package nabukodonozor;

import grafikus.FogView;

public class Fog implements Active{
	private int freqdec;
	private int counter;
	private Tower tower;
	protected FogView view;
	
	//konstruktor
	public Fog(){
		freqdec = 0;
		counter = 0;
		view = new FogView();
	}

	//teendok minden utemben
	public void tick() {
		
	}
	
	//interakcio toronnyal
	public void act(Tower t){
		
	}
	
	//setter: tower
	public void setTower(Tower t) {
		tower = t;
	}
}
