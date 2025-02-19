
package entities;

/**
 * Class contenant les objets Montagne
 *
 * @author Antoine Janvrot
 * @version 26 août 2019
 */
public class Mountain extends MapObject {

	/**
	 * Constructeur avec paramètres
	 * 
	 * @param xPos
	 *            Les coordonnées en abscisse
	 * @param yPos
	 *            Les coordonnées en ordonnée
	 */
	public Mountain(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	/**
	 * Constructeur sans paramètres
	 */
	public Mountain() {

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public MapObject verifyParamsAndReturnObject(String[] params) {
		if (getVerifyParameters().checkNumberParameters(3, params)
				&& getVerifyParameters().isNumericAndPositive(params[1])
				&& getVerifyParameters().isNumericAndPositive(params[2]))
			return new Mountain(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
		else
			return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "M - " + xPos + " - " + yPos + "\r\n";
	}

}
