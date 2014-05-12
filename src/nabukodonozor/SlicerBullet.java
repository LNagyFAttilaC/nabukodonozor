package nabukodonozor;

import grafikus.SlicerBulletView;

public class SlicerBullet extends Bullet {
	//konstruktor
	public SlicerBullet(Tower from) {
		super();
		view = new SlicerBulletView(this);
		int[] cell_coords = from.getCell().getView().getCoords();
		view.setCoords(cell_coords[0], cell_coords[1]);
	}
	
	//interakcio az ellenseggel
	public void act(Enemy e) {
		e.split();
		
		drawable = true;
		view.notifyView();
		
		synchronized (this) {
			try {
				wait(10);
			} catch (InterruptedException e1) {			
				e1.printStackTrace();
			}
		}
		
		drawable = false;
		view.notifyView();
	}
}