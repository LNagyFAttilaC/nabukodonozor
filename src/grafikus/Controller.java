package grafikus;

import java.util.TimerTask;

import nabukodonozor.BasicTower;
import nabukodonozor.BasicTrap;
import nabukodonozor.Cell;
import nabukodonozor.Program;

public class Controller {
	public enum ControllerState { 	BASIC, DAMAGESTONE_CLICKED, RADIUSSTONE_CLICKED, ELFDAMAGESTONE_CLICKED, HUMANDAMAGESTONE_CLICKED, 
									FREQUENCYSTONE_CLICKED, HOBBITDAMAGESTONE_CLICKED, DWARFDAMAGESTONE_CLICKED, 
									RETENTIVESTONE_CLICKED, TOWER_CLICKED, TRAP_CLICKED, CELL_CLICKED};
	
	private static ControllerState state = Controller.ControllerState.BASIC;
	private static java.util.Timer ticker;
	private static nabukodonozor.Timer timer;
	private static CellController[][] cells;
	
	public static void initTimer() {
		timer = new nabukodonozor.Timer();
		Program.game.getField().setTimer(timer);
		
		ticker = new java.util.Timer();
		ticker.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				timer.tick();
			}
		}, 0, 5);
	}
	
	public static void createCellArray(int rows, int cols) {
		cells = new CellController[rows][cols];
	}
	
	public static void click(int x, int y) {
		int c_x = x/40;
		int c_y = y/40;
		
		CellController cell = cells[c_y][c_x];
		
		switch (Controller.state) {
		case TOWER_CLICKED:
			if (Program.game.getField().getMana() >= BasicTower.default_price) {
				BasicTower basictower = new BasicTower();
				basictower.getView().setCoords(c_y, c_x);
				
				if (cell.getCell().addElement(basictower)) {
					cell.setTower(basictower);
				}
			}
			break;
		case TRAP_CLICKED:
			if (Program.game.getField().getMana() >= BasicTrap.default_price) {
				BasicTrap basictrap = new BasicTrap();
				basictrap.getView().setCoords(c_y, c_x);
				
				if (cell.getCell().addElement(basictrap)) {
					cell.setTrap(basictrap);
				}
			}
		break;
		}
		
		Controller.state = ControllerState.BASIC;
	}
	
	public static CellController getCell(int y, int x) {
		return cells[y][x];
	}
	
	public static void setState(Controller.ControllerState state) {
		Controller.state = state;
	}
	
	public static void setCell(Cell cell, int y, int x) {
		CellController cc = new CellController();
		cc.setCell(cell);
		cells[y][x] = cc;
	}
}
