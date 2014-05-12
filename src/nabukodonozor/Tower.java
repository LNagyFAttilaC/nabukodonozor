package nabukodonozor;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import grafikus.TowerView;

public abstract class Tower extends Element implements Active {
	protected List<StoneToTower> stones; //kovek
	protected List<Enemy> targets; //celpontok
	protected int radius; //hatosugar
	protected int frequency; //lovesi gyakorisag
	protected int damage; //sebzes
	protected int price; //ar
	protected TowerView view; //megjelenito
	private   int tick_counter;
	
	//konstruktor
	public Tower() {
		stones		 = new ArrayList<StoneToTower>();
		targets		 = new ArrayList<Enemy>();
		tick_counter = 0;
	}
	
	//Detekorok lehelyezese rekurzivan (a hivasnal mar ismerjuk a torony cellajat)
	private void setDetectors(Cell origin, int r) {
		
		if (r > radius) {
			return;
		}		
		
		for (int i=0; i < 4; i++) {							
			
			// aktualis indexu szomszed (0 - eszak, 1 - kelet, 2 - del, 3 - nyugat)
			Cell c = origin.getNeighbours().get(i);
			
			//Ha nincs szomszed az aktualis iranyban, akkor folytassuk a kovetkezo cellaval
			if (c == null) {
				continue;
			}
			
			Detector d = new BasicDetector(this);
			d.setCell(c);
			c.addElement(d);
					
			//hozzaadas az aktiv elemekhez		
			Timer timer = origin.getField().getTimer();
			timer.addActive(d);
			
			//rekurziv hivas
			setDetectors(this.cell, r+1);
			
			//atlosan is elhelyezunk egy detektort
			Cell c2 = null;
			
			switch (i) {
			case 0:
				// eszaki szomszed keleti szomszedja
				c2 = c.getNeighbours().get(1);				
			case 1:
				// keleti szomszed deli szomszedja
				c2 = c.getNeighbours().get(2);
			case 2:
				// deli szomszed nyugati szomszedja
				c2 = c.getNeighbours().get(3);
			case 3:
				// nyugati szomszed eszaki szomszedja
				c2 = c.getNeighbours().get(0);
			}
			
			if (c2 == null) {
				continue;
			}
			
			Detector d2 = new BasicDetector(this);
			d2.setCell(c2);
			c2.addElement(d2);
			//hozzaadas az aktiv elemekhez
			timer.addActive(d2);
			
			//rekurziv hivas
			setDetectors(this.cell, r+1);
		
		}
		
	}
	
	//utra kerulhet-e
	public boolean accept(Road r) {
		return false;
	}
	
	//mezore kerulhet-e
	public boolean accept(Land l) {
		//van-e ott torony
		for (Element e : l.getElements()) {
			boolean result = e.accept(this);
			
			if (!result) {
				return false;
			}
		}
		
		//cella beallitasa
		cell = l;

		Field f = l.getField();
		Timer timer = f.getTimer();
		
		//detektorok lehelyezese (cell == l)
		setDetectors(cell, 1);
		
		//hozzaadas az aktiv elemekhez
		timer.addActive(this);
		
		//hozzaadas a mezohoz
		l.setElement(this);
		
		//mana csokkentese
		f.decreaseMana(price);
		
		//kod beallitasa
		Fog fog = new Fog(this);
		timer.addActive(fog);
		
		view.notifyView();
		
		return true;		
	}
	
	//hegyre kerulhet-e
	public boolean accept(Mountain m) {
		return false;
	}
	
	//torony melle kerulhet-e
	public boolean accept(Tower t) {
		return false;
	}
	
	//csapda melle kerulhet-e
	public boolean accept(Trap t) {
		return false;
	}
	
	//ellenseg melle kerulhet-e
	public boolean accept(Enemy e) {
		return false;
	}
	
	//detektor melle kerulhet-e
	public boolean accept(Detector d) {
		return false;
	}
	
	//interakcio tundevel
	public void act(Elf e) {
		return;
	}
	
	//interakcio emberrel
	public void act(Human h) {
		return;
	}
	
	//interakcio torppel
	public void act(Dwarf d) {
		return;
	}
	
	//interakcio hobbittal
	public void act(Hobbit h) {
		return;
	}
	
	//teendok minden utemben
	public void tick() {
		tick_counter++;
		
		if (tick_counter == frequency) {
			//celpont kivalasztasa
			Enemy e = selectTarget();
	
			if (e != null) {
				Random n = new Random();
				
				Bullet bu;
				if (n.nextInt(40)!=6) {
					//alap lovedek letrehozasa
					bu	= new BasicBullet(this);
					bu.increaseDamage(damage);
			
					//lovedek fejlesztese kovekkel
					for (StoneToTower s : stones) {
						s.improveBullet_bridge(s, bu, e);
					}
				}
				else {
					//kettevago lovedek letrehozasa
					bu = new SlicerBullet(this);
				}
				
				bu.view.notifyView();
				
				//ellenseg sebzese
				e.damage(bu);			
				
				Program.game.updateMana();
			}

			tick_counter = 0;
		}
	}
	
	//ko hozzaadasa
	public void addStone(StoneToTower s) {
		s.accept(this);
		
		Program.game.updateMana();
	}
	
	//ko eltarolasa
	public void setStone(StoneToTower s) {
		stones.add(s);
	}
	
	//celpont hozzaadasa
	public void addTarget(Enemy e) {
		targets.add(e);
	}
	
	public void removeTarget(Enemy target) {
		targets.remove(target);
	}
	
	//hatosugar novelese
	public void increaseRadius(int r) {
		if (r > 0) {
			radius += r;
			setDetectors(cell, 1);
		}
	}
	
	//lovesi gyakorisag novelese
	public void increaseFrequency(int f) {
		if (f > 0) {
			frequency -= f;
		}
	}
	
	//lovesi gyakorisag csokkentese
		public void decreaseFrequency(int f) {
			if (f > 0) {
				frequency += f;
			}
		}
	
	//sebzes novelese
	public void increaseDamage(int d) {
		if (d > 0) {
			damage += d;
		}
	}

	public TowerView getView(){
		return view;
	}

	//celpont kivalasztasa
	protected abstract Enemy selectTarget();

	//segedmetodus
	protected abstract void act_bridge(StoneToTower s);
}
