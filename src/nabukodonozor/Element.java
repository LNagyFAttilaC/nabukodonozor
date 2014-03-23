package nabukodonozor;

public abstract class Element implements Acceptable, Incompatibility, InteractWithEnemy {
	protected Cell cell;
	
	public void setCell(Cell c) {
		cell = c;
	}
}
