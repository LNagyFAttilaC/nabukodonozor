package nabukodonozor;

public class DwarfDamageStone extends StoneToTower{

	public void act(BasicTower b){
		Object[] params = {b};
		Skeleton.entry(this, "act(BasicTower b)", params);
	}
	
	public void improveBullet(Bullet b, Dwarf d){
		Object[] params = {b, d};
		Skeleton.entry(this, "improveBullet(Bullet b, Dwarf d)", params);
	}

}
