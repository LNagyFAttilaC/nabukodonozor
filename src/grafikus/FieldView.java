package grafikus;

import nabukodonozor.*;

public class FieldView {
	private Field field;
	
	public FieldView(Field field) {
		this.field = field;
	}
	
	public void notifyView(){
		for(Cell cell : field.getCells()) {
			cell.callView();
		}
	}
	
}
