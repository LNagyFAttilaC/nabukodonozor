package nabukodonozor;

public class DamageStone extends StoneToTower {
	public DamageStone(){
		value = 10;
		price = 650;
	}
	
	//interakci� BasicTower-rel
	public void act(BasicTower b) {
		b.damage += value;
		return;
	}
}
