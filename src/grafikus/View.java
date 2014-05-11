package grafikus;

import javax.swing.JPanel;

public abstract class View {
	protected int x;
	protected int y;
	
	public void setCoords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int[] getCoords(){
		int[] k = new int[2];
		k[0] = x;
		k[1] = y;
		return k;
	}
	
	public abstract void notifyView();
}
