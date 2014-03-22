package nabukodonozor;

public class ElfDamageStone extends StoneToTower{

	public void act(BasicTower b){
		Skeleton.entry("s", "ElfDamageStone", "act", new String[] {"b:BasicTower"});
	}
	
	public void improveBullet(Bullet b, Elf e){
		Skeleton.entry("s", "ElfDamageStone", "improveBullet", new String[] {"b:Bullet", "e:Elf"});
	}
}
