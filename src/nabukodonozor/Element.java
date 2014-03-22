package nabukodonozor;

public abstract class Element implements Acceptable, Incompatibility, InteractWithEnemy {
	protected Cell cell;
	
	public void act(Enemy e) {
		System.out.println("BLAAAAA");
	}
	
	public void setCell(Cell c) {
		cell = c;
	}
}
