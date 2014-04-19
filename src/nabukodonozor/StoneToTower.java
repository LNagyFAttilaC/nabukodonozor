package nabukodonozor;

public abstract class StoneToTower extends Stone implements InteractWithTower, SpeciesSpecificBullet {
	//toronyra kerulhet-e
	public boolean accept(Tower t){
		//hozzaadas
		t.setStone(this);
				
		//varazsero csokkentese
		t.getCell().getField().decreaseMana(price);
		
		t.act_bridge(this);

		return true;
	}
	
	//csapdara kerulhet-e
	public boolean accept(Trap t){
		return false;
	}
	
	//lovedek fejlesztese tunde-specifikusan
	public void improveBullet(Bullet b, Elf e) {
		return;
	}
	
	//lovedek fejlesztese ember-specifikusan
	public void improveBullet(Bullet b, Human h) {
		return;
	}
	
	//lovedek fejlesztese torp-specifikusan
	public void improveBullet(Bullet b, Dwarf d) {
		return;
	}
	
	//lovedek fejlesztese hobbit-specifikusan
	public void improveBullet(Bullet b, Hobbit h) {
		return;
	}
	
	//segedmetodus
	public void improveBullet_bridge(StoneToTower s, Bullet b, Enemy e) {
		e.improveBullet_bridge(s, b);
	}
	
	//interakcio BasicTower-rel
	public abstract void act(BasicTower b);
}
