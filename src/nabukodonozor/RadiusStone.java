package nabukodonozor;

public class RadiusStone extends StoneToTower {
	public static int default_price = 410;

	//konstruktor
	public RadiusStone() {
		value = 1;
		price = default_price;
	}
	
	//interakció BasicTower-rel
	public void act(BasicTower b) {
		b.increaseRadius(value);
	}
}