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

public class Treasure extends MapObject {

	private int treasureNumber;

	public Treasure(int xPos, int yPos, int treasureNumber) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.treasureNumber = treasureNumber;
	}

	public Treasure() {

	}

	public void removeTreasure() {
		treasureNumber = treasureNumber - 1;
	}

	@Override
	public MapObject verifyParamsAndReturnObject(String[] params) {
		if (verifyParameters.checkNumberParameters(4, params) && verifyParameters.isNumericAndPositive(params[1])
				&& verifyParameters.isNumericAndPositive(params[2]) && verifyParameters.isNumericAndPositive(params[3]))
			return new Treasure(Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]));
		else
			return null;
	}

}
