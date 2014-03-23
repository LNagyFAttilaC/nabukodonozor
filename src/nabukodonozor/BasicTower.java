package nabukodonozor;

public class BasicTower extends Tower {
	//konstruktor
	public BasicTower(){
		Object[] params = {};
		Skeleton.entry(this, "BasicTower()", params);
		
		Skeleton.exit("void");
	}
	
	//celpont kivalasztasa: Kire lojon a torony a targets-bol?
	protected Enemy selectTarget() {
		Object[] params = {};
		Skeleton.entry(this, "selectTarget()", params);
		
		Skeleton.exit("h");
		
		return targets.get(0);
	}
}