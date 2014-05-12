package grafikus;

import nabukodonozor.BasicBullet;
import nabukodonozor.Program;

public class BasicBulletView extends BulletView {
	
	ImagePanel basicBulletImage;
	
	//konstruktor
	public BasicBulletView(BasicBullet basicBullet) {
		bullet = basicBullet;
		basicBulletImage = new ImagePanel("pics/bullet1.png");		
		basicBulletImage.setOpaque(false);
		basicBulletImage.setSize(20, 20);
	}

	public void notifyView() {
		// celcella meghatarozasa - betesszuk a cella kozepere
		int c_x = x*40 + 10;
		int c_y = y*40 + 10;
		
		basicBulletImage.setLocation(c_x, c_y);
				
		// kep kirajzolasa		
		if (bullet.getDrawable())
			Program.game.getPField().add(basicBulletImage, 2);
		else
			Program.game.getPField().remove(basicBulletImage);		
	}

}
