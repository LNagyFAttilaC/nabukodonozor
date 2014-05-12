package grafikus;

import nabukodonozor.Fog;
import nabukodonozor.Program;

public class FogView extends View{
	private Fog fog;
	ImagePanel  fogView;

	public FogView(Fog f) {
		fog		= f;
		fogView = new ImagePanel("pics/fog.png");
		fogView.setOpaque(false);
		fogView.setSize(40, 40);
	}
	
	public void notifyView(){
		// célcella meghatározása
		int c_x = x*40;
		int c_y = y*40;
		
		if (fog.getDrawable()) {
			fogView.setLocation(c_x, c_y);
			
			// kép kirajzolása
			fogView.setVisible(true);
			Program.game.getPField().add(fogView, 2);
		}
		else {
			fogView.setVisible(false);
			Program.game.getPField().remove(fogView);
		}
	}
}
