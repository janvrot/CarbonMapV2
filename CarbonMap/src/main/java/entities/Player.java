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
 * 
 *
 * @author Antoine Janvrot
 * @version 23 août 2019
 */
public class Player extends MapObject {

	private String name;
	private String orientation;
	private String movements;
	private int treasuresFound;

	public Player(int xPos, int ypos, String name, String orientation, String movements, int treasuresFound) {
		this.xPos = xPos;
		this.yPos = ypos;
		this.name = name;
		this.orientation = orientation;
		this.movements = movements;
		this.treasuresFound = treasuresFound;
	}

	public Player() {

	}

	public void move(String orientation) {

	}

	public void move(String orientation, String direction) {

	}

	@Override
	public MapObject verifyParamsAndReturnObject(String[] params) {
		if (verifyParameters.checkNumberParameters(6, params) && verifyParameters.isNotEmptyString(params[1])
				&& verifyParameters.isNumericAndPositive(params[2])
				&& verifyParameters.isNumericAndPositive(params[3])
				&& verifyParameters.hasValuesIncludedInDefaultValues(params[4], MapConstants.ORIENTATIONS)
				&& verifyParameters.hasValuesIncludedInDefaultValues(params[5], MapConstants.MOVEMENTS))
			return new Player(Integer.parseInt(params[2]), Integer.parseInt(params[3]), params[1], params[4], params[5],
					0);
		else
			return null;
	}

}
