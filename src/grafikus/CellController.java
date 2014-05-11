package grafikus;

import nabukodonozor.Cell;
import nabukodonozor.Tower;
import nabukodonozor.Trap;

public class CellController {
	private Cell cell;
	private Tower tower;
	private Trap trap;
	
	public void setCell(Cell cell) {
		this.cell = cell;
	}
	
	public Cell getCell() {
		return cell;
	}
	
	public void setTower(Tower tower) {
		this.tower = tower;
	}
	
	public Tower getTower() {
		return tower;
	}
}
