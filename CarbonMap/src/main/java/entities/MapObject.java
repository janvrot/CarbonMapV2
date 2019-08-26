
package entities;

import services.VerifyParametersService;
import services.impl.VerifyParametersServiceImpl;

/**
 * Class abstraite permettant de générer les éléments de la carte
 *
 * @author Antoine Janvrot
 * @version 26 août 2019
 */
public abstract class MapObject {

	protected int xPos;
	protected int yPos;
	private VerifyParametersService verifyParameters = new VerifyParametersServiceImpl();

	/**
	 * Méthode de vérification des paramètres d'entrée et de création (Factory)
	 *
	 * @param params
	 *            Les paramètre extraits
	 * @return L'objet instancié
	 */
	public abstract MapObject verifyParamsAndReturnObject(String[] params);

	/**
	 * @return {@link #xPos}
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @return {@link #yPos}
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @param xPos
	 *            {@link #xPos}
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	
	/**
	 * @param verifyParameters
	 *            {@link #verifyParameters}
	 */
	public void setVerifyParameters(VerifyParametersService verifyParameters) {
		this.verifyParameters = verifyParameters;
	}

	/**
	 * @param yPos
	 *            {@link #yPos}
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	/**
	 * @return {@link #verifyParameters}
	 */
	public VerifyParametersService getVerifyParameters() {
		return verifyParameters;
	}
}
