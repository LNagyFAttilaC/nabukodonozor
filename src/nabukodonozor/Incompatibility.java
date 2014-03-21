package nabukodonozor;

public interface Incompatibility {
	public boolean accept(Tower t);
	public boolean accept(Trap t);
	public boolean accept(Enemy e);
	public boolean accept(Detector d);
}
