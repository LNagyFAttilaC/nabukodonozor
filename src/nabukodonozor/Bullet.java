package nabukodonozor;

public class Bullet {
	private int damage; //sebz�s
	
	//konstruktor
	public Bullet() {
		Object[] params = {};
		Skeleton.entry(null, "Bullet()", params);
		
		damage = 0;
		
		Skeleton.exit("bu");
	}
	
	//interakci� az ellens�ggel
	public void act(Enemy e) {
		Object[] params = {e};
		Skeleton.entry(this, "act(Enemy e)", params);
		
		e.decreaseLife(damage);
		
		Skeleton.exit("void");
	}
	
	//sebz�s n�vel�se
	public void increaseDamage(int d) {
		Integer D = new Integer(d);
		Object[] params = {D};
		Skeleton.entry(this, "increaseDamage(int d)", params);
		
		damage += d;
		
		Skeleton.exit("void");
	}
}
