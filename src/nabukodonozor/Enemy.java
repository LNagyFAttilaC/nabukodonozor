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
		Skeleton.entry("Enemy konstruktora meghivodott.");
	}
	
	public void act(Dwarf d){
		Skeleton.entry("void Enemy::act(Dwarf d) függvény meghívódott.");
	}
	
	public void act(Elf e){
		Skeleton.entry("void Enemy::act(Elf e) függvény meghívódott.");
	}
	
	public void act(Hobbit h){
		Skeleton.entry("void Enemy::act(Hobbit h) függvény meghívódott.");
	}
	
	public void act(Human h){
		Skeleton.entry("void Enemy::act(Human h) függvény meghívódott.");
	}
	
	public void damage(Bullet b){
		Skeleton.entry("void Enemy::damage(Bullet b) függvény meghívódott.");
	}
	
	public boolean accept(Road r){
		Skeleton.entry("boolean Enemy::accept(Road r) függvény meghívódott.");
	}
	
	public boolean accept(Land l){
		Skeleton.entry("boolean Enemy::accept(Land l) függvény meghívódott.");
	}

	public boolean accept(Mountain m){
		Skeleton.entry("boolean Enemy::accept(Mountain m) függvény meghívódott.");
	}

	public boolean accept(Tower t){
		Skeleton.entry("boolean Enemy::accept(Tower t) függvény meghívódott.");
	}

	public boolean accept(Trap t){
		Skeleton.entry("boolean Enemy::accept(Trap t) függvény meghívódott.");
	}

	public boolean accept(Enemy e){
		Skeleton.entry("boolean Enemy::accept(Enemy e) függvény meghívódott.");
	}

	public boolean accept(Detector d){
		Skeleton.entry("boolean Enemy::accept(Detector d) függvény meghívódott.");
	}

	public void addSpeedItem(int s){
		Skeleton.entry("void Enemy::addSpeedItem(int s) függvény meghívódott.");
	}
	
	private Cell selectDestination(){
		Skeleton.entry("Cell Enemy::selectDestination() függvény meghívódott.");
	}

	@Override
	public void tick() {
		Skeleton.entry("void Enemy::tick() függvény meghívódott.");
	}
}
