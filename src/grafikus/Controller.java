package grafikus;
import nabukodonozor.*;

public class Controller {
	public enum ControllerState { 	BASIC, DAMAGESTONE_CLICKED, RADIUSSTONE_CLICKED, ELFDAMAGESTONE_CLICKED, HUMANDAMAGESTONE_CLICKED, 
									FREQUENCYSTONE_CLICKED, HOBBITDAMAGESTONE_CLICKED, DWARFDAMAGESTONE_CLICKED, 
									RETENTIVESTONE_CLICKED, TOWER_CLICKED, TRAP_CLICKED, CELL_CLICKED};
	
	private static ControllerState state = Controller.ControllerState.BASIC;
	private static Timer timer;
	private static CellController[][] cells;
	
	public static void createCellArray(int rows, int cols) {
		cells = new CellController[rows][cols];
	}
	
	public static void click(int x, int y) {
		int c_x = x/40;
		int c_y = y/40;
		
		CellController cell = cells[c_x][c_y];
		
		switch (Controller.state) {
			case TOWER_CLICKED:
				BasicTower basictower = new BasicTower();
				basictower.getView().setCoords(c_x, c_y);
				
				if (cell.getCell().addElement(basictower)) {
					cell.setTower(basictower);
				}
			break;
		}
	}
	
	public static CellController getCell(int x, int y) {
		return cells[x][y];
	}
	
	public static void setState(Controller.ControllerState state) {
		Controller.state = state;
	}
	
	public static void setCell(Cell cell, int x, int y) {
		CellController cc = new CellController();
		cc.setCell(cell);
		cells[y][x] = cc;
	}
}
