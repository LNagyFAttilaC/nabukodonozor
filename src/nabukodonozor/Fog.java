package nabukodonozor;

import java.util.Random;

import grafikus.FogView;

public class Fog implements Active{
	private int freqdec;
	private int counter;
	private Tower tower;
	protected FogView view;
	protected boolean drawable;
	
	//konstruktor
	public Fog(Tower t) {
		tower	= t;
		freqdec = 2;
		counter = 0;
		view 	= new FogView(this);
		int[] cell_coords	= t.getView().getCoords();
		view.setCoords(cell_coords[0], cell_coords[1]);
	}

	//teendok minden utemben
	public void tick() {
		act(tower);
	}
	
	//interakcio toronnyal
	public void act(Tower t){
		if (counter > 1) {
			counter--;
		}
		else if (counter == 1) {
			t.decreaseFrequency(freqdec);
			
			counter--;
			
			drawable = false;
			view.notifyView();
		}
		else if (counter == 0) {
			Random n = new Random();
			
			if (n.nextInt(100)==8) {
				t.increaseFrequency(freqdec);
				
				counter = n.nextInt(100) + 100;
				
				drawable = true;
				view.notifyView();
			}
		}
	}
	
	//setter: tower
	public void setTower(Tower t) {
		tower = t;
	}
	
	public boolean getDrawable() {
		return drawable;
	}
}
