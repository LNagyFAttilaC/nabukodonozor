package nabukodonozor;

public interface SpeciesSpecificBullet {
	//lovedek fejlesztese tunde-specifikusan
	public void improveBullet(Bullet b, Elf e);
	
	//lovedek fejlesztese ember-specifikusan
	public void improveBullet(Bullet b, Human h);
	
	//lovedek fejlesztese torp-specifikusan
	public void improveBullet(Bullet b, Dwarf d);
	
	//lovedek fejlesztese hobbit-specifikusan
	public void improveBullet(Bullet b, Hobbit h);
}