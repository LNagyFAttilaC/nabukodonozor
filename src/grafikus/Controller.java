package grafikus;
import nabukodonozor.*;

public class Controller {
	public enum ControllerState { basic, stone_clicked, tower_clicked, trap_clicked };
	
	private ControllerState state;
	private Timer timer;
	private static CellController[][] cells;
	
	public void click(int x, int y) {
		
	}
}
