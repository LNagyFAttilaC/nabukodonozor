package grafikus;

import nabukodonozor.Program;
import nabukodonozor.SlicerBullet;

public class SlicerBulletView extends BulletView{

	ImagePanel slicerBulletImage;
	
	//konstruktor
	public SlicerBulletView(SlicerBullet slicerBullet) {
		bullet = slicerBullet;
		slicerBulletImage = new ImagePanel("pics/bullet2.png");		
		slicerBulletImage.setOpaque(false);
		slicerBulletImage.setSize(20, 20);
	}	

	public void notifyView() {
		// celcella meghatarozasa - betesszuk a cella kozepere
		int c_x = x*40 + 10;
		int c_y = y*40 + 10;
				
		slicerBulletImage.setLocation(c_x, c_y);
		
		// kep kirajzolasa				
		if (bullet.getDrawable())
			Program.game.getPField().add(slicerBulletImage, 2);
		else
			Program.game.getPField().remove(slicerBulletImage);		
	}
	
}
