package grafikus;

import javax.swing.JPanel;

public abstract class View {
	protected int x;
	protected int y;
	
	public void setCoords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void notifyView();
}
