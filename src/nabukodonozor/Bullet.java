package nabukodonozor;

public abstract class Bullet {
	protected int damage; //sebzes
	
	//konstruktor
	public Bullet() {
		damage = 0;
	}
	
	//sebzes novelese
	public void increaseDamage(int d) {
		if (d > 0) {
			damage += d;
		}
	}
	
	//interakcio az ellenseggel
	public abstract void act(Enemy e);
}
