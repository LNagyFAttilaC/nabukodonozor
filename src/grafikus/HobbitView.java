package grafikus;

import nabukodonozor.Hobbit;
import nabukodonozor.Program;

public class HobbitView extends EnemyView{
	ImagePanel hobbit;

	public HobbitView(Hobbit h) {
		z_index = ++static_z_index;
		enemy = h;
		hobbit = new ImagePanel("pics/hobbit.png");
		hobbit.setOpaque(false);
		hobbit.setSize(30, 30);
	}
	
	public void notifyView() {
		// c�lcella meghat�roz�sa
		int[] coords = enemy.getCell().getView().getCoords();
		
		int c_x = coords[1]*40+5;
		int c_y = coords[0]*40+5;

		// k�p kirajzol�sa
		if (enemy.getLife() > 0) {
			hobbit.setLocation(c_x, c_y);
			Program.game.getPField().add(hobbit, z_index);
		}
		else {
			hobbit.setVisible(false);
			Program.game.getPField().remove(hobbit);
		}
	}
}
