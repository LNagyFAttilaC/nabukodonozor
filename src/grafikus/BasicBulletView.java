package grafikus;

import nabukodonozor.BasicBullet;
import nabukodonozor.Program;

public class BasicBulletView extends BulletView {
	
	//konstruktor
	public BasicBulletView(BasicBullet basicBullet) {
		bullet = basicBullet;
	}

	public void notifyView() {
		// celcella meghatarozasa - betesszuk a cella kozepere
		int c_x = x*40 + 10;
		int c_y = y*40 + 10;
				
		// kep kirajzolasa
		ImagePanel basicBullet = new ImagePanel("pics/bullet1.png");
		basicBullet.setSize(20, 20);
		basicBullet.setLocation(c_x, c_y);
		Program.game.getPField().add(basicBullet, 3);		
	}

}
