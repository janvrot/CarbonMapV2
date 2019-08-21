package entities;

public class Explorer extends MapObject {
	
	private String nom;
	private String orientation;
	private String actions;
	private int myTresors = 0;
	
	public Explorer(String nom, int xValue, int yValue, String orientation, String actions) {
		this.event = "Aventurier";
		this.nom = nom;
		this.xValue = xValue;
		this.yValue = yValue;
		this.orientation = orientation;
		this.actions = actions;
	}
	
	public String toString() {
		String str = "A - " + this.nom + " - " + this.xValue + " - " + this.yValue + " - " + this.orientation + " - " + this.myTresors;
		return str;
	}
	
	public String getOrientation() {
		return this.orientation;
	}
	
	public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
	
	public String getNom() {
		return this.nom;
	}
	
	public String getActions() {
		return this.actions;
	}
	
	public void setNom(String nom) {
        this.nom = nom;
    }
	
	public int getMyTresors() {
		return this.myTresors;
	}
	
	public void setMyTresors(int myTresors) {
        this.myTresors = myTresors;
    }

}
