package nabukodonozor;

public abstract class StoneToTower extends Stone implements InteractWithTower{

	public abstract void act(BasicTower b);
	
	public boolean accept(Tower t){
		Skeleton.entry("s", "StoneToTower", "accept", new String[] {"t:Tower"});
		return true;
	}
	
	public boolean accept(Trap t){
		Skeleton.entry("s", "StoneToTower", "accept", new String[] {"t:Trap"});
		return false;
	}
	
	public void improveBullet(Bullet b, Elf e){
		Skeleton.entry("s", "StoneToTower", "improveBullet", new String[] {"b:Bullet", "e:Elf"});
	}
	
	public void improveBullet(Bullet b, Human h){
		Skeleton.entry("s", "StoneToTower", "improveBullet", new String[] {"b:Bullet", "h:Human"});
	}
	
	public void improveBullet(Bullet b, Dwarf d){
		Skeleton.entry("s", "StoneToTower", "improveBullet", new String[] {"b:Bullet", "d:Dwarf"});
	}
	
	public void improveBullet(Bullet b, Hobbit h){
		Skeleton.entry("s", "StoneToTower", "improveBullet", new String[] {"b:Bullet", "h:Hobbit"});
	}
}
