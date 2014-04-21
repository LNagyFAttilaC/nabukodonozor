package nabukodonozor;

public class SlicerBullet extends Bullet {
	//interakcio az ellenseggel
	public void act(Enemy e) {
		e.split();
	}
}