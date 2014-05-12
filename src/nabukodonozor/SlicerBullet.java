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
		drawable = false;
		view.notifyView();
		int[] cell_coords = e.getCell().getView().getCoords();
		view.setCoords(cell_coords[0], cell_coords[1]);
		e.split();
		drawable = true;
		view.notifyView();
		drawable = false;
		view.notifyView();
	}
}