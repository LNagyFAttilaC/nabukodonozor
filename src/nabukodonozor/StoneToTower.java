package nabukodonozor;

public abstract class StoneToTower extends Stone implements InteractWithTower, SpeciesSpecificBullet {
	//toronyra kerulhet-e
	public boolean accept(Tower t){
		Object[] params = {t};
		Skeleton.entry(this, "accept(Tower t)", params);
		
		//hozzaadas
		t.setStone(this);
				
		//varazsero csokkentese
		t.getCell().getField().decreaseMana(price);
		
		t.act_bridge(this);
		
		Skeleton.exit("true");

		return true;
	}
	
	//csapdara kerulhet-e
	public boolean accept(Trap t){
		Object[] params = {t};
		Skeleton.entry(this, "accept(Trap t)", params);
		
		Skeleton.exit("false");

		return false;
	}
	
	//lovedek fejlesztese tunde-specifikusan
	public void improveBullet(Bullet b, Elf e) {
		Object[] params = {b, e};
		Skeleton.entry(this, "improveBullet(Bullet b, Elf e)", params);
		
		Skeleton.exit("void");
	}
	
	//lovedek fejlesztese ember-specifikusan
	public void improveBullet(Bullet b, Human h) {
		Object[] params = {b, h};
		Skeleton.entry(this, "improveBullet(Bullet b, Human h)", params);
		
		Skeleton.exit("void");
	}
	
	//lovedek fejlesztese torp-specifikusan
	public void improveBullet(Bullet b, Dwarf d) {
		Object[] params = {b, d};
		Skeleton.entry(this, "improveBullet(Bullet b, Dwarf d)", params);
		
		Skeleton.exit("void");
	}
	
	//lovedek fejlesztese hobbit-specifikusan
	public void improveBullet(Bullet b, Hobbit h) {
		Object[] params = {b, h};
		Skeleton.entry(this, "improveBullet(Bullet b, Hobbit h)", params);
		
		Skeleton.exit("void");
	}
	
	//segedmetodus
	public void improveBullet_bridge(StoneToTower s, Bullet b, Enemy e) {
		e.improveBullet_bridge(s, b);
	}
	
	//interakcio BasicTower-rel
	public abstract void act(BasicTower b);
}
