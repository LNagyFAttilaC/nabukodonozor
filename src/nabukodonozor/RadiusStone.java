package nabukodonozor;

public class RadiusStone extends StoneToTower {
	//konstruktor
	public RadiusStone(){
		value = 1;
		price = 410;
	}
	
	//interakció BasicTower-rel
	public void act(BasicTower b) {
		b.radius += value;
		return;
	}
}