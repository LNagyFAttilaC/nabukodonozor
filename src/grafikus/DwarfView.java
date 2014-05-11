package grafikus;

import nabukodonozor.Program;

public class DwarfView extends EnemyView {
	public void notifyView(){
		// célcella meghatározása
		int c_x = x*40;
		int c_y = y*40;
		
		// kép kirajzolása
		ImagePanel dwarf = new ImagePanel("pics/dwarf.png");
		dwarf.setOpaque(false);
		dwarf.setSize(30, 30);
		dwarf.setLocation(c_x, c_y);
		Program.game.getPField().add(dwarf, 2);
	}
}
