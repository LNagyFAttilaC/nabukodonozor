package grafikus;

import java.util.Timer;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import nabukodonozor.*;

public class DwarfView extends EnemyView{

	public void notifyView(){
		// Cell from = enemy.getCell(); // az a cella, amelyiken az enemy áll
		Cell to = enemy.selectDestination(); // célcellát adja vissza
		
		// kezdo poziciok
		int from_x = x*40;
		int from_y = y*40;
		// celpoziciok
		int to_x = to.getView().x*40;
		int to_y = to.getView().x*40;
		
		try {
			BufferedImage pic = ImageIO.read(new File("pics/dwarf_p.jpg"));
			//Program.game.getPField().add(pic);
			
			while(from_x != to_x){
				try {
					Thread.sleep(40); // enemy.getSpeed
					if(from_x < to_x)
						from_x++;
					else if(from_x > to_x)
						from_x--;
					Program.game.getPField().repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			while(from_y != to_y){
				try {
					Thread.sleep(40); // enemy.getSpeed
					if(from_y < to_y)
						from_y++;
					else if(from_y > to_y)
						from_y--;
					Program.game.getPField().repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
