package grafikus;
import nabukodonozor.*;

public class FogView extends View{
	private Fog fog;
	
	public void notifyView(){
		// c�lcella meghat�roz�sa
		int c_x = x*40;
		int c_y = y*40;
		
		// k�p kirajzol�sa
		ImagePanel fog = new ImagePanel("pics/fog.jpg");
		fog.setSize(40, 40);
		fog.setLocation(c_x, c_y);
		Program.game.getPField().add(fog);
	}
	
}
