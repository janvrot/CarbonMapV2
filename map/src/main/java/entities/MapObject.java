package entities;

public abstract class MapObject {
	protected int xValue;
	protected int yValue;
	protected String event;
	
	public String toString() {
		String str = "X : " + this.xValue + "\n";
		str += "Y : " + this.yValue + "\n";
		str += "Type : " + this.event + "\n";
		return str;
	}
	
	public String getEvent() {
		return this.event;
	}
	
	public int getX() {
		return this.xValue;
	}
	
	public int getY() {
		return this.yValue;
	}
	
	public void setX(int xValue) {
        this.xValue = xValue;
    }
	
	public void setY(int yValue) {
        this.yValue = yValue;
    }
}
