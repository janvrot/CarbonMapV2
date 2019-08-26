/**
 * <p>
 * Copyright © 2019 THALES Communications, France. All rights reserved.
 * </p>
 * <p>
 * Ce document est la propriété de THALES Communications, France,
 * il ne peut être ni reproduit, ni utilisé, ni communiqué, ni distribué
 * à  des tiers sans son autorisation préalable.
 * </p>
 * <p>
 * Créé le 23 août 2019.
 * </p>
 */
package entities;

import constants.MapConstants;

/**
 * Class contenant les aventuriers
 *
 * @author Antoine Janvrot
 * @version 23 août 2019
 */
public class Player extends MapObject {

	private String name;
	private String orientation;
	private String movements;
	private int treasuresFound;

	/**
	 * Constructeur avec paramètres
	 * 
	 * @param xPos
	 *            Les coordonnées en abscisse
	 * @param yPos
	 *            Les coordonnées en ordonnée
	 * @param name
	 *            Le nom de l'aventurier
	 * @param orientation
	 *            L'orientation de l'aventurier
	 * @param movements
	 *            La suite de mouvements de l'aventurier
	 * @param treasuresFound
	 *            Le nombre de trésors trouvés par l'aventurier
	 */
	public Player(int xPos, int ypos, String name, String orientation, String movements, int treasuresFound) {
		this.xPos = xPos;
		this.yPos = ypos;
		this.name = name;
		this.orientation = orientation;
		this.movements = movements;
		this.treasuresFound = treasuresFound;
	}

	/**
	 * Constructeur sans paramètres
	 */
	public Player() {

	}

	/**
	 * Change l'orientation de l'aventurier
	 *
	 * @param orientation
	 *            L'orientation initiale
	 * @param movement
	 *            Le mouvement prévu
	 */
	public void turn(String orientation, String movement) {
		int position = getOrientationPosition(orientation);
		if (movement.equals("D")) {
			position++;
		} else {
			position--;
		}
		String futureOrientation = checkOrientation(position);
		this.orientation = futureOrientation;
	}

	/**
	 * Change les coordonnées de l'aventurier de 1 case
	 *
	 * @param orientation
	 *            L'orientation de l'aventurier
	 */
	public void move(String orientation) {
		switch (orientation) {
		case "N":
			yPos = yPos - 1;
			break;
		case "E":
			xPos = xPos + 1;
			break;
		case "S":
			yPos = yPos + 1;
			break;
		case "W":
			xPos = xPos - 1;
			break;
		default:
			break;
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public MapObject verifyParamsAndReturnObject(String[] params) {
		if (getVerifyParameters().checkNumberParameters(6, params) && getVerifyParameters().isNotEmptyString(params[1])
				&& getVerifyParameters().isNumericAndPositive(params[2])
				&& getVerifyParameters().isNumericAndPositive(params[3])
				&& getVerifyParameters().hasValuesIncludedInDefaultValues(params[4], MapConstants.ORIENTATIONS)
				&& getVerifyParameters().hasValuesIncludedInDefaultValues(params[5], MapConstants.MOVEMENTS))
			return new Player(Integer.parseInt(params[2]), Integer.parseInt(params[3]), params[1], params[4], params[5],
					0);
		else
			return null;
	}

	/**
	 * Récupération de l'orientation de puis le tableau d'orientations
	 *
	 * @param orientation
	 *            L'orientation initiale
	 * @return La position de l'orientation dans le tableau
	 */
	private int getOrientationPosition(String orientation) {
		int position = 0;
		for (int i = 0; i < MapConstants.ORIENTATIONS.size(); i++) {
			if (MapConstants.ORIENTATIONS.get(i).equals(orientation)) {
				position = i;
				break;
			}
		}
		return position;
	}

	/**
	 * Attribue la nouvelle orientation
	 *
	 * @param position
	 *            La position de l'orientation dans le tableau
	 * @return La nouvelle orienbtation
	 */
	private String checkOrientation(int position) {
		if (position >= MapConstants.ORIENTATIONS.size()) {
			return MapConstants.ORIENTATIONS.get(0);
		} else if (position < 0) {
			return MapConstants.ORIENTATIONS.get(MapConstants.ORIENTATIONS.size() - 1);
		} else {
			return MapConstants.ORIENTATIONS.get(position);
		}
	}

	/**
	 * @return {@link #movements}
	 */
	public String getMovements() {
		return movements;
	}

	/**
	 * @return {@link #orientation}
	 */
	public String getOrientation() {
		return orientation;
	}

	/**
	 * Ajoute 1 aux trésors de l'aventurier
	 */
	public void addTreasure() {
		treasuresFound = treasuresFound + 1;
	}

	/**
	 * @param orientation
	 *            {@link #orientation}
	 */
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "A - " + name + " - " + xPos + " - " + yPos + " - " + orientation + " - " + treasuresFound + "\r\n";
	}
}
