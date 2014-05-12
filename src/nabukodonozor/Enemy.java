package nabukodonozor;

import grafikus.EnemyView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Enemy extends Element implements Active {
	protected int life; //elet
	protected int value; //ertek
	protected List<Integer> speed; //sebesseg
	protected EnemyView view;
	private   int tick_counter;
	protected int direction;
	protected int camefrom;
	
	//konstruktor
	public Enemy(){
		speed 		 = new ArrayList<Integer>();
		tick_counter = 0;
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
		//sebesseg visszaallitasa
		for (int i = 1; i < speed.size(); i++) {
			speed.remove(i);
		}
		
		//interakcio az uton levo elemekkel
		List<Element> elements = r.getElements();
		act_bridge(elements);
		
		//hozzaadas az uthoz
		r.setElement(this);
		
		//cella beallitasa
		setCell(r);
		
		//kovetkezo cel kivalasztasa
		selectDestination();
		
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
		return true;
	}

	//teendok minden utemben
	public void tick() {
		tick_counter++;
		
		if (tick_counter == speed.get(speed.size()-1)*2) {
			//cel kivalasztasa
			Cell c = cell.getNeighbours().get(direction);
			
			//elozo cella beallitasa
			switch (direction) {
				case 0:
					camefrom = 2;
				break;
				case 1:
					camefrom = 3;
				break;
				case 2:
					camefrom = 0;
				break;
				case 3:
					camefrom = 1;
				break;
			}
			
			//hozzaadas a celhoz
			c.addElement(this);
			
			//torles a mostani cellarol
			cell.removeElement(this);

			tick_counter = 0;
		}

		view.notifyView();
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
	public void selectDestination() {
		List<Integer> roads		= new ArrayList<Integer>();
		
		List<Cell> neighbours	= cell.getNeighbours();
		for (int i = 0; i < neighbours.size(); i++) {
			Cell neighbour = neighbours.get(i);
			
			if (neighbour != null && i != camefrom) {
				if (neighbour.accept(this)) {
					roads.add(i);
				}
			}
		}
		
		if (roads.size() == 0) {
			direction = camefrom;
		}
		else {
			Random n  = new Random();
			direction = roads.get(n.nextInt(roads.size()));
		}
	}
	
	//kettevagas
	protected abstract void split();
	
	//getter: life
	public int getLife() {
		return life;
	}
	
	//setter: life
	public void setLife(int l) {
		life = l;
	}
	
	//elet csokkentese
	public void decreaseLife(int d) {
		if (life > 0)
		{
			if (d > 0) {
				life -= d;
			}
					
			//ha meghalt
			if (life <= 0) {
				//mana novelese
				Field f = cell.getField();
				f.increaseMana(value);
				f.increaseDied();
				
				//torles az aktivok kozul
				Timer t = f.getTimer();
				t.removeActive(this);
		
				//torles a cellarol
				cell.removeElement(this);
			}
		}
	}
	
	public int getDirection() {
		return direction;
	}
	
	//segedmetodus
	protected abstract void act_bridge(List<Element> elements);
	
	//segedmetodus
	protected abstract void improveBullet_bridge(StoneToTower s, Bullet b);
}
