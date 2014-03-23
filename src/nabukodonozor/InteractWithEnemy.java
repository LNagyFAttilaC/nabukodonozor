package nabukodonozor;

public interface InteractWithEnemy {
	//interakcio torppel
	public void act(Dwarf d);
	
	//interakcio tundevel
	public void act(Elf e);
	
	//interakcio hobbittal
	public void act(Hobbit h);
	
	//intarakcio emberrel
	public void act(Human h);
}
