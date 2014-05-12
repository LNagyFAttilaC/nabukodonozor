package grafikus;

import nabukodonozor.Human;
import nabukodonozor.Program;

public class HumanView extends EnemyView{
	ImagePanel human;

	public HumanView(Human h) {
		z_index = ++static_z_index;
		enemy = h;
		human = new ImagePanel("pics/human.png");
		human.setOpaque(false);
		human.setSize(30, 30);
	}
	
	public void notifyView() {
		// célcella meghatározása
		int[] coords = enemy.getCell().getView().getCoords();
		
		int c_x = coords[1]*40+5;
		int c_y = coords[0]*40+5;

		// kép kirajzolása
		if (enemy.getLife() > 0) {
			human.setLocation(c_x, c_y);
			Program.game.getPField().add(human, z_index);
		}
		else {
			human.setVisible(false);
			Program.game.getPField().remove(human);
		}
	}
}
