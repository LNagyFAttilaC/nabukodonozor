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
		drawable = false;
		view.notifyView();
		int[] cell_coords = e.getCell().getView().getCoords();
		view.setCoords(cell_coords[0], cell_coords[1]);
		e.decreaseLife(damage);
		drawable = true;
		view.notifyView();
		drawable = false;
		view.notifyView();
	}
}
