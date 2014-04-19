package nabukodonozor;

public class BasicBullet extends Bullet {
	//interakcio az ellenseggel
	public void act(Enemy e) {
		e.decreaseLife(damage);
	}
}
