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
		cells[x][y] = cc;
	}
}
