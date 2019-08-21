package entities;

public class Tresor extends MapObject {
	
	private int numberOf;
	
	public Tresor(int xValue, int yValue, int numberOf) {
		this.event = "Tresor";
		this.xValue = xValue;
		this.yValue = yValue;
		this.numberOf = numberOf;
	}

	public String toString() {
		String str = "T - " + this.xValue + " - " + this.yValue + " - " + this.numberOf;
		return str;
	}
	
	public int getNumber() {
		return this.numberOf;
	}
	
	public void setNumber(int number) {
        this.numberOf = number;
    }
}
