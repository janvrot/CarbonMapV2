package entities;

public class Mountain extends MapObject {
	
	public Mountain(int xValue, int yValue) {
		this.event = "Montagne";
		this.xValue = xValue;
		this.yValue = yValue;
	}
	
	public String toString() {
		String str = "M - " + this.xValue + " - " + this.yValue;
		return str;
	}
}
