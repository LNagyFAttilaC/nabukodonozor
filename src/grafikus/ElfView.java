package grafikus;

import nabukodonozor.Elf;
import nabukodonozor.Program;

public class ElfView extends EnemyView{
	ImagePanel elf;

	public ElfView(Elf e) {
		z_index = ++static_z_index;
		enemy = e;
		elf = new ImagePanel("pics/elf.png");
		elf.setOpaque(false);
		elf.setSize(30, 30);
	}
	
	public void notifyView() {
		// célcella meghatározása
		int[] coords = enemy.getCell().getView().getCoords();
		
		int c_x = coords[1]*40+5;
		int c_y = coords[0]*40+5;

		// kép kirajzolása
		if (enemy.getLife() > 0) {
			elf.setLocation(c_x, c_y);
			Program.game.getPField().add(elf, z_index);
		}
		else {
			elf.setVisible(false);
			Program.game.getPField().remove(elf);
		}
	}
}
