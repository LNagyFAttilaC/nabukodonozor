package nabukodonozor;

public class Bullet {
	private int damage;
	
	public Bullet() {
		Object[] params = {};
		Skeleton.entry(null, "Bullet()", params);
		
		damage = 0;
		
		Skeleton.exit("bu");
	}
	
	public void act(Enemy e) {
		
	}
	
	public void increaseDamage(int d) {
		Integer D = new Integer(d);
		Skeleton.objects.put(D, "bt.damage");
		Object[] params = {D};
		Skeleton.entry(this, "increaseDamage(int d)", params);
		
		damage += d;
		
		Skeleton.exit("void");
	}
}
