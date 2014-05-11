package grafikus;
import nabukodonozor.*;

public class FogView extends View{
	private Fog fog;
	
	public void notifyView(){
		// kép kirajzolása
		ImagePanel land = new ImagePanel("pics/fog.jpg");
		land.setSize(40, 40);
		//land.setLocation(c_x, c_y);
		Program.game.getPField().add(land);
	}
	
}
