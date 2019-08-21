package entities;

public class Carte {
	
	private int lengthMap;
	private int highMap;
	
	public void setLengthMap(int lengthMap) {
        this.lengthMap = lengthMap;
    }

    public int getLengthMap() {
        return this.lengthMap;
    }
    
    public void setHighMap(int highMap) {
        this.highMap = highMap;
    }

    public int getHighMap() {
        return this.highMap;
    }
    
    public String toString() {
    	String str = "C - " + this.lengthMap + " - " + this.highMap;
    	return str;
    }
}
