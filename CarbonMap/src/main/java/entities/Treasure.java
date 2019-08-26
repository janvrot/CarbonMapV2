
package entities;

/**
 * Class contenant les Trésors des aventuriers
 *
 * @author Antoine Janvrot
 * @version 26 août 2019
 */
public class Treasure extends MapObject {

	private int treasureNumber;

	/**
	 * Constructeur avec paramètres
	 * 
	 * @param xPos
	 *            Les coordonnées en abscisse
	 * @param yPos
	 *            Les coordonnées en ordonnée
	 * @param treasureNumber
	 *            Le nombre de trésors présents
	 */
	public Treasure(int xPos, int yPos, int treasureNumber) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.treasureNumber = treasureNumber;
	}

	/**
	 * Constructeur sans paramètres
	 */
	public Treasure() {

	}

	/**
	 * Suppression d'un trésor
	 */
	public void removeTreasure() {
		treasureNumber = treasureNumber - 1;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public MapObject verifyParamsAndReturnObject(String[] params) {
		if (getVerifyParameters().checkNumberParameters(4, params)
				&& getVerifyParameters().isNumericAndPositive(params[1])
				&& getVerifyParameters().isNumericAndPositive(params[2])
				&& getVerifyParameters().isNumericAndPositive(params[3]))
			return new Treasure(Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]));
		else
			return null;
	}

	/**
	 * @return {@link #treasureNumber}
	 */
	public int getTreasureNumber() {
		return treasureNumber;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "T - " + xPos + " - " + yPos + " - " + treasureNumber + "\r\n";
	}

}
