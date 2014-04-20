package nabukodonozor;

public class FrequencyStone extends StoneToTower {
	public FrequencyStone(){
		value = 1;
		price = 220;
	}
	
	//interakcio BasicTower-rel
	public void act(BasicTower b) {
		b.frequency += value;
		return;
	}
}