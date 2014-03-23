package nabukodonozor;

public abstract class StoneToTower extends Stone implements InteractWithTower, SpeciesSpecificBullet {

	public abstract void act(BasicTower b);
	
	public boolean accept(Tower t){
		
		return true;
	}
	
	public boolean accept(Trap t){
		
		return false;
	}
	
	public void improveBullet(Bullet b, Elf e){
		
	}
	
	public void improveBullet(Bullet b, Human h){
		
	}
	
	public void improveBullet(Bullet b, Dwarf d){
		
	}
	
	public void improveBullet(Bullet b, Hobbit h){
		Object[] params = {b, h};
		Skeleton.entry(this, "improveBullet(Bullet b, Hobbit h)", params);
		
		Skeleton.exit("void");
	}
	
	public void improveBullet_bridge(StoneToTower s, Bullet b, Enemy e) {
		e.improveBullet_bridge(s, b);
	}
}
