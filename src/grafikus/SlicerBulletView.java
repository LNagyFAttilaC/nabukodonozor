package grafikus;

import nabukodonozor.Program;
import nabukodonozor.SlicerBullet;

public class SlicerBulletView extends BulletView{

	//konstruktor
	public SlicerBulletView(SlicerBullet slicerBullet) {
		bullet = slicerBullet;
	}	

	public void notifyView() {
		// celcella meghatarozasa - betesszuk a cella kozepere
		int c_x = x*40 + 10;
		int c_y = y*40 + 10;
				
		// kep kirajzolasa
		ImagePanel basicBullet = new ImagePanel("pics/bullet2.png");
		basicBullet.setSize(20, 20);
		basicBullet.setLocation(c_x, c_y);
		Program.game.getPField().add(basicBullet, 3);		
	}
	
}
