package grafikus;

import nabukodonozor.Dwarf;
import nabukodonozor.Program;

public class DwarfView extends EnemyView {
	ImagePanel dwarf;

	public DwarfView(Dwarf d) {
		z_index = ++static_z_index;
		enemy = d;
		dwarf = new ImagePanel("pics/dwarf.png");
		dwarf.setOpaque(false);
		dwarf.setSize(30, 30);
	}
	
	public void notifyView() {
		// célcella meghatározása
		int[] coords = enemy.getCell().getView().getCoords();
		
		int c_x = coords[1]*40+5;
		int c_y = coords[0]*40+5;

		// kép kirajzolása
		if (enemy.getLife() > 0) {
			dwarf.setLocation(c_x, c_y);
			Program.game.getPField().add(dwarf, z_index);
		}
		else {
			dwarf.setVisible(false);
			Program.game.getPField().remove(dwarf);
		}
	}
}
