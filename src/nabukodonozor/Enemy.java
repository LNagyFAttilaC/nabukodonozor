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
		System.out.println("void Enemy::act(Dwarf d) f�ggv�ny megh�v�dott.");
	}
	
	public void act(Elf e){
		System.out.println("void Enemy::act(Elf e) f�ggv�ny megh�v�dott.");
	}
	
	public void act(Hobbit h){
		System.out.println("void Enemy::act(Hobbit h) f�ggv�ny megh�v�dott.");
	}
	
	public void act(Human h){
		System.out.println("void Enemy::act(Human h) f�ggv�ny megh�v�dott.");
	}
	
	public void damage(Bullet b){
		System.out.println("void Enemy::damage(Bullet b) f�ggv�ny megh�v�dott.");
	}
	
	public boolean accept(Road r){
		System.out.println("boolean Enemy::accept(Road r) f�ggv�ny megh�v�dott.");
	}
	
	public boolean accept(Land l){
		System.out.println("boolean Enemy::accept(Land l) f�ggv�ny megh�v�dott.");
	}

	public boolean accept(Mountain m){
		System.out.println("boolean Enemy::accept(Mountain m) f�ggv�ny megh�v�dott.");
	}

	public boolean accept(Tower t){
		System.out.println("boolean Enemy::accept(Tower t) f�ggv�ny megh�v�dott.");
	}

	public boolean accept(Trap t){
		System.out.println("boolean Enemy::accept(Trap t) f�ggv�ny megh�v�dott.");
	}

	public boolean accept(Enemy e){
		System.out.println("boolean Enemy::accept(Enemy e) f�ggv�ny megh�v�dott.");
	}

	public boolean accept(Detector d){
		System.out.println("boolean Enemy::accept(Detector d) f�ggv�ny megh�v�dott.");
	}

	public void addSpeedItem(int s){
		System.out.println("void Enemy::addSpeedItem(int s) f�ggv�ny megh�v�dott.");
	}
	
	private Cell selectDestination(){
		System.out.println("Cell Enemy::selectDestination() f�ggv�ny megh�v�dott.");
	}

	@Override
	public void tick() {
		System.out.println("void Enemy::tick() f�ggv�ny megh�v�dott.");
	}
}
