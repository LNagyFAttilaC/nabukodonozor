package grafikus;

import nabukodonozor.BasicTrap;
import nabukodonozor.Program;

public class BasicTrapView extends TrapView{
	//konstruktor
	public BasicTrapView(BasicTrap basictrap) {
		trap = basictrap;
	}
	
	public void notifyView(){
		// c�lcella meghat�roz�sa
		int c_x = x*40;
		int c_y = y*40;
		
		// k�p kirajzol�sa
		ImagePanel basictrap = new ImagePanel("pics/trap.jpg");
		basictrap.setSize(40, 40);
		basictrap.setLocation(c_x, c_y);
		Program.game.getPField().add(basictrap, 2);
		Program.game.updateMana();
	}
}
