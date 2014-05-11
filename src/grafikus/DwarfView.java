package grafikus;

import nabukodonozor.Dwarf;
import nabukodonozor.Program;

public class DwarfView extends EnemyView {
	ImagePanel dwarf;

	public DwarfView(Dwarf d) {
		enemy = d;
		dwarf = new ImagePanel("pics/dwarf.png");
		dwarf.setOpaque(false);
		dwarf.setSize(30, 30);
	}
	
	public void notifyView() {
		// célcella meghatározása
		int[] coords = enemy.getCell().getView().getCoords();
		
		int c_x = coords[1]*40;
		int c_y = coords[0]*40;
		
		switch (enemy.getDirection()) {
			case 0:
				c_y -= 5;
			break;
			case 1:
				c_x += 5;
			break;
			case 2:
				c_y += 5;
			break;
			case 3:
				c_x -= 5;
			break;
		}

		// kép kirajzolása
		dwarf.setLocation(c_x, c_y);
		Program.game.getPField().add(dwarf, 3);
	}
}
