package nabukodonozor;

public class DwarfDamageStone extends StoneToTower{

	public void act(BasicTower b){
		Skeleton.entry("s", "DwarfDamageStone", "act", new String[] {"b:BasicTower"});
	}
	
	public void improveBullet(Bullet b, Dwarf d){
		Skeleton.entry("s", "DwarfDamageStone", "improveBullet", new String[] {"b:Bullet", "d:Dwarf"});
	}

}
