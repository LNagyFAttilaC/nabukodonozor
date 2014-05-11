package grafikus;
import nabukodonozor.*;

public class Controller {
	public enum ControllerState { basic, stone_clicked, tower_clicked, trap_clicked };
	
	private static ControllerState state = Controller.ControllerState.basic;
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
