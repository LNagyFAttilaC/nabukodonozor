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
		System.out.println("Enemy konstruktora meghivodott.");
	}
	
	public void act(Dwarf d){
		System.out.println("void Enemy::act(Dwarf d) függvény meghívódott.");
	}
	
	public void act(Elf e){
		System.out.println("void Enemy::act(Elf e) függvény meghívódott.");
	}
	
	public void act(Hobbit h){
		System.out.println("void Enemy::act(Hobbit h) függvény meghívódott.");
	}
	
	public void act(Human h){
		System.out.println("void Enemy::act(Human h) függvény meghívódott.");
	}
	
	public void damage(Bullet b){
		System.out.println("void Enemy::damage(Bullet b) függvény meghívódott.");
	}
	
	public boolean accept(Road r){
		System.out.println("boolean Enemy::accept(Road r) függvény meghívódott.");
	}
	
	public boolean accept(Land l){
		System.out.println("boolean Enemy::accept(Land l) függvény meghívódott.");
	}

	public boolean accept(Mountain m){
		System.out.println("boolean Enemy::accept(Mountain m) függvény meghívódott.");
	}

	public boolean accept(Tower t){
		System.out.println("boolean Enemy::accept(Tower t) függvény meghívódott.");
	}

	public boolean accept(Trap t){
		System.out.println("boolean Enemy::accept(Trap t) függvény meghívódott.");
	}

	public boolean accept(Enemy e){
		System.out.println("boolean Enemy::accept(Enemy e) függvény meghívódott.");
	}

	public boolean accept(Detector d){
		System.out.println("boolean Enemy::accept(Detector d) függvény meghívódott.");
	}

	public void addSpeedItem(int s){
		System.out.println("void Enemy::addSpeedItem(int s) függvény meghívódott.");
	}
	
	private Cell selectDestination(){
		System.out.println("Cell Enemy::selectDestination() függvény meghívódott.");
	}

	@Override
	public void tick() {
		System.out.println("void Enemy::tick() függvény meghívódott.");
	}
}
