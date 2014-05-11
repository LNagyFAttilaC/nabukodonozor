package grafikus;

import nabukodonozor.Program;

public class BasicTowerView extends TowerView{
	
	public void notifyView(){
		
		// célcella meghatározása
		int c_x = x*40;
		int c_y = y*40;
		
		// kép kirajzolása
		ImagePanel basictower = new ImagePanel("pics/tower.png");
		basictower.setSize(40, 40);
		basictower.setLocation(c_x, c_y);
		Program.game.getPField().add(basictower);
	}

}
