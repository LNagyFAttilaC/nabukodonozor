package nabukodonozor;

import grafikus.BasicBulletView;

public class BasicBullet extends Bullet {
	//konstruktor
	public BasicBullet(Tower from) {
		super();
		view = new BasicBulletView(this);
		
		int[] cell_coords = from.getCell().getView().getCoords();
		view.setCoords(cell_coords[0], cell_coords[1]);
	}
	
	//interakcio az ellenseggel
	public void act(Enemy e) {
		synchronized (this) {
			try {
				wait(10);
			} catch (InterruptedException e1) {			
				e1.printStackTrace();
			}
		}
		
		drawable = false;
		view.notifyView();
		
		int[] cell_coords = e.getCell().getView().getCoords();
		view.setCoords(cell_coords[0], cell_coords[1]);
		
		synchronized (this) {
			try {
				wait(30);
			} catch (InterruptedException e1) {			
				e1.printStackTrace();
			}
		}
		
		e.decreaseLife(damage);				
		
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
