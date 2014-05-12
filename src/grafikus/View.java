package grafikus;

public abstract class View {
	protected int y;
	protected int x;
	
	public void setCoords(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	public int[] getCoords(){
		int[] k = new int[2];
		k[0] = y;
		k[1] = x;
		
		return k;
	}
	
	public abstract void notifyView();
}
