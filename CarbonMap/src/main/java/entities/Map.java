
package entities;

/**
 * Class contenant les données de la Carte
 *
 * @author Antoine Janvrot
 * @version 26 août 2019
 */
public class Map extends MapObject {

	/**
	 * Constructeur avec paramètres
	 * 
	 * @param xPos Les coordonnées en abscisse
	 * @param yPos Les coordonnées en ordonnée
	 */
	public Map(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	/**
	 * Constructeur sans paramètres
	 */
	public Map() {

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public MapObject verifyParamsAndReturnObject(String[] params) {
		if (getVerifyParameters().checkNumberParameters(3, params)
				&& getVerifyParameters().isNumericAndMoreThanZero(params[1])
				&& getVerifyParameters().isNumericAndMoreThanZero(params[2]))
			return new Map(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
		else
			return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "C - " + xPos + " - " + yPos + "\r\n";
	}

}
