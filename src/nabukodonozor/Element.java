package nabukodonozor;

public abstract class Element implements Acceptable, Incompatibility, InteractWithEnemy {
	protected Cell cell; //cella
	
	//setter: cell
	public void setCell(Cell c) {
		cell = c;
	}
	
	//getter: cell
	public Cell getCell() {
		return cell;
	}

	public void exit_act(Enemy enemy) {
		return;
	}
}
