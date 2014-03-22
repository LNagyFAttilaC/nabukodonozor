package nabukodonozor;

public interface SpeciesSpecificBullet {

	public void improveBullet(Bullet b, Elf e);
	public void improveBullet(Bullet b, Human h);
	public void improveBullet(Bullet b, Dwarf d);
	public void improveBullet(Bullet b, Hobbit h);
	
}
