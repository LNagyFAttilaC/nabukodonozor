package nabukodonozor;

public abstract class StoneToTower extends Stone implements InteractWithTower, SpeciesSpecificBullet {

	public abstract void act(BasicTower b);
	
	public boolean accept(Tower t){
<<<<<<< HEAD
		Object[] params = {t};
		Skeleton.entry(this, "accept(Tower t)", params);
=======
		
>>>>>>> 9cc4589c7fc565ac1c3407a097e50929029f76d1
		return true;
	}
	
	public boolean accept(Trap t){
<<<<<<< HEAD
		Object[] params = {t};
		Skeleton.entry(this, "accept(Trap t)", params);
=======
		
>>>>>>> 9cc4589c7fc565ac1c3407a097e50929029f76d1
		return false;
	}
	
	public void improveBullet(Bullet b, Elf e){
<<<<<<< HEAD
		Object[] params = {b, e};
		Skeleton.entry(this, "improveBullet(Bullet b, Elf e)", params);
	}
	
	public void improveBullet(Bullet b, Human h){
		Object[] params = {b, h};
		Skeleton.entry(this, "improveBullet(Bullet b, Human h)", params);
	}
	
	public void improveBullet(Bullet b, Dwarf d){
		Object[] params = {b, d};
		Skeleton.entry(this, "improveBullet(Bullet b, Dwarf d)", params);
=======
		
	}
	
	public void improveBullet(Bullet b, Human h){
		
	}
	
	public void improveBullet(Bullet b, Dwarf d){
		
>>>>>>> 9cc4589c7fc565ac1c3407a097e50929029f76d1
	}
	
	public void improveBullet(Bullet b, Hobbit h){
		Object[] params = {b, h};
		Skeleton.entry(this, "improveBullet(Bullet b, Hobbit h)", params);
<<<<<<< HEAD
=======
		
		Skeleton.exit("void");
	}
	
	public void improveBullet_bridge(StoneToTower s, Bullet b, Enemy e) {
		e.improveBullet_bridge(s, b);
>>>>>>> 9cc4589c7fc565ac1c3407a097e50929029f76d1
	}
}
