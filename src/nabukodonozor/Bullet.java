package nabukodonozor;

import grafikus.BulletView;

public abstract class Bullet {
	protected int damage; //sebzes
	protected BulletView view;
	protected boolean drawable;	//Mivel a Bullet nem tartozik hozza a palyahoz, igy ezzek jelezzuk, hogy
								//eppen letezik-e, ki kell-e rajzolni (a view-nak segitunk ezzel).
	
	//konstruktor
	public Bullet() {
		damage = 0;
		drawable = true;
	}
	
	//sebzes novelese
	public void increaseDamage(int d) {
		if (d > 0) {
			damage += d;
		}
	}
	
	public boolean getDrawable() {
		return drawable;
	}
	
	//interakcio az ellenseggel
	public abstract void act(Enemy e);
}
