package grafikus;

import nabukodonozor.*;

public class FieldView {
	private Field field;
	
	public void notifyView(){
		for(Cell cell : field.getCells())
			cell.callView();
	}
	
}
