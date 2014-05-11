package grafikus;

import javax.swing.JPanel;

public abstract class View {
	protected int x;
	protected int y;
	
	public abstract void notifyView();
}
