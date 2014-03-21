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
		Skeleton.entry("void Enemy::act(Dwarf d) f�ggv�ny megh�v�dott.");
	}
	
	public void act(Elf e){
		Skeleton.entry("void Enemy::act(Elf e) f�ggv�ny megh�v�dott.");
	}
	
	public void act(Hobbit h){
		Skeleton.entry("void Enemy::act(Hobbit h) f�ggv�ny megh�v�dott.");
	}
	
	public void act(Human h){
		Skeleton.entry("void Enemy::act(Human h) f�ggv�ny megh�v�dott.");
	}
	
	public void damage(Bullet b){
		Skeleton.entry("void Enemy::damage(Bullet b) f�ggv�ny megh�v�dott.");
	}
	
	public boolean accept(Road r){
		Skeleton.entry("boolean Enemy::accept(Road r) f�ggv�ny megh�v�dott.");
	}
	
	public boolean accept(Land l){
		Skeleton.entry("boolean Enemy::accept(Land l) f�ggv�ny megh�v�dott.");
	}

	public boolean accept(Mountain m){
		Skeleton.entry("boolean Enemy::accept(Mountain m) f�ggv�ny megh�v�dott.");
	}

	public boolean accept(Tower t){
		Skeleton.entry("boolean Enemy::accept(Tower t) f�ggv�ny megh�v�dott.");
	}

	public boolean accept(Trap t){
		Skeleton.entry("boolean Enemy::accept(Trap t) f�ggv�ny megh�v�dott.");
	}

	public boolean accept(Enemy e){
		Skeleton.entry("boolean Enemy::accept(Enemy e) f�ggv�ny megh�v�dott.");
	}

	public boolean accept(Detector d){
		Skeleton.entry("boolean Enemy::accept(Detector d) f�ggv�ny megh�v�dott.");
	}

	public void addSpeedItem(int s){
		Skeleton.entry("void Enemy::addSpeedItem(int s) f�ggv�ny megh�v�dott.");
	}
	
	private Cell selectDestination(){
		Skeleton.entry("Cell Enemy::selectDestination() f�ggv�ny megh�v�dott.");
	}

	@Override
	public void tick() {
		Skeleton.entry("void Enemy::tick() f�ggv�ny megh�v�dott.");
	}
}
