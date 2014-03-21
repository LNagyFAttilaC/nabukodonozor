package nabukodonozor;

import java.util.ArrayList;

public class Enemy extends Element implements Active{
	protected int life;
	protected int value;
	protected ArrayList<Integer> speed;
    //-----------------------------------
	public Enemy(){
		life = 0;
		value = 0;
		speed = null;
		String[] params = {};
		Skeleton.entry("e", "Enemy", "Enemy", params);
	}
	
	public void act(Dwarf d){
		String[] params = {"d: Dwarf"};
		Skeleton.entry("e","Enemy","act",params);
	}
	
	public void act(Elf e){
		String[] params = {"e: Elf"};
		Skeleton.entry("e","Enemy","act",params);
	}
	
	public void act(Hobbit h){
		String[] params = {"h: Hobbit"};
		Skeleton.entry("e","Enemy","act",params);
	}
	
	public void act(Human h){
		String[] params = {"h: Human"};
		Skeleton.entry("e","Enemy","act",params);
	}
	
	public void damage(Bullet b){
		String[] params = {"b: Bullet"};
		Skeleton.entry("e","Enemy","damage",params);
	}
	
	public boolean accept(Road r){
		String[] params = {"r: Road"};
		Skeleton.entry("e","Enemy","accept",params);
	}
	
	public boolean accept(Land l){
		String[] params = {"l: Land"};
		Skeleton.entry("e","Enemy","accept",params);
	}

	public boolean accept(Mountain m){
		String[] params = {"m: Mountain"};
		Skeleton.entry("e","Enemy","accept",params);
	}

	public boolean accept(Tower t){
		String[] params = {"t: Tower"};
		Skeleton.entry("e","Enemy","accept",params);
	}

	public boolean accept(Trap t){
		String[] params = {"t: Trap"};
		Skeleton.entry("e","Enemy","accept",params);
	}

	public boolean accept(Enemy e){
		String[] params = {"e: Enemy"};
		Skeleton.entry("e","Enemy","accept",params);
	}

	public boolean accept(Detector d){
		String[] params = {"d: Detector"};
		Skeleton.entry("e","Enemy","accept",params);
	}

	public void addSpeedItem(int s){
		String[] params = {"s: int"};
		Skeleton.entry("e","Enemy","addSpeedItem",params);
	}
	
	private Cell selectDestination(){
		String[] params = {};
		Skeleton.entry("e","Enemy","selectDestination",params);
	}

	@Override
	public void tick() {
		String[] params = {};
		Skeleton.entry("e","Enemy","tick",params);
	}
}
