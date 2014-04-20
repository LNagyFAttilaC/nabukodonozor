package nabukodonozor;

import java.util.List;

public abstract class Enemy extends Element implements Active {
	protected int life; //elet
	protected int value; //ertek
	protected List<Integer> speed; //sebesseg
	
	//konstruktor
	public Enemy(){
		super.cell = new Road();
	}
	
	//interakcio torppel
	public void act(Dwarf d) {
		return;
	}
	
	//interakcio tundevel
	public void act(Elf e) {
		return;
	}
	
	//interakcio hobbittal
	public void act(Hobbit h) {
		return;
	}
	
	//interakcio emberrel
	public void act(Human h) {
		return;
	}
	
	//utra kerulhet-e
	public boolean accept(Road r) {
		//interakcio az uton levo elemekkel
		List<Element> elements = r.getElements();
		act_bridge(elements);
		
		//hozzaadas az uthoz
		r.setElement(this);
		
		return true;
	}
	
	//mezore kerulhet-e
	public boolean accept(Land l) {
		return false;
	}

	//hegyre kerulhet-e
	public boolean accept(Mountain m) {
		//Game Over!
		Field f = cell.getField();
		f.gameOver();
	
		return false;
	}

	//torony melle kerulhet-e
	public boolean accept(Tower t) {
		return false;
	}

	//csapda melle kerulhet-e
	public boolean accept(Trap t) {
		return true;
	}

	//ellenseg melle kerulhet-e
	public boolean accept(Enemy e) {
		return true;
	}

	//detektor melle kerulhet-e
	public boolean accept(Detector d) {
		//hozzaadas a toronyhoz celpontkent
		Tower tower = d.getTower();
		tower.addTarget(this);
		
		return true;
	}

	//teendok minden utemben
	public void tick() {
		//cel kivalasztasa
		Cell c = selectDestination();
		
		//hozzaadas a celhoz
		c.addElement(this);
		
		//torles a mostani cellarol
		cell.removeElement(this);
	}
	
	//sebzes
	public void damage(Bullet b) {
		//interakcio a lovedekkel
		b.act(this);
	}

	//uj sebesseg-elem
	public void addSpeedItem(int s) {
		if (s > 0) {
			speed.add(s);
		}
	}
	
	//cel kivalasztasa
	private Cell selectDestination() {
		return cell.getNeighbours().get(0);
	}
	
	//kettevagas
	protected abstract void split();
	
	//setter: life
	public void setLife(int l) {
		life = l;
	}
	
	//elet csokkentese
	public void decreaseLife(int d) {
		if (d > 0) {
			life -= d;
			
			//ha meghalt
			if (life<=0) {
				//manat kap Szaruman
				Field f = cell.getField();
				f.increaseMana(value);
				
				//torles az aktivok kozul
				Timer t = f.getTimer();
				t.removeActive(this);
	
				//torles a cellarol
				cell.removeElement(this);
			}
		}
	}
	
	//segedmetodus
	protected abstract void act_bridge(List<Element> elements);
	
	//segedmetodus
	protected abstract void improveBullet_bridge(StoneToTower s, Bullet b);
}
