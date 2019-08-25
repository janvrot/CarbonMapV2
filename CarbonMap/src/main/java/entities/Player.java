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

	public void turn(String orientation, String movement) {
		int position = getOrientationPosition(orientation);
		if (movement.equals("D")) {
			position++;
		} else {
			position --;
		}
		orientation = checkOrientation(position);
	}

	public void move(String orientation) {
		switch (orientation) {
		case "N":
			yPos = yPos + 1;
			break;
		case "E":
			xPos = xPos + 1;
			break;
		case "S":
			yPos = yPos - 1;
			break;
		case "W":
			xPos = xPos - 1;
			break;
		default:
			break;
		}
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
	
	private int getOrientationPosition(String orientation) {
		int position = 0;
		for(int i = 0;i<MapConstants.ORIENTATIONS.size();i++) {
			if (MapConstants.ORIENTATIONS.get(i).equals(orientation)) {
				position = i;
				break;
			}
		}
		return position;
	}
	
	private String checkOrientation(int position) {
		if (position >= MapConstants.ORIENTATIONS.size()) {
			return MapConstants.ORIENTATIONS.get(0);
		} else if (position < 0) {
			return MapConstants.ORIENTATIONS.get(MapConstants.ORIENTATIONS.size() - 1);
		} else {
			return MapConstants.ORIENTATIONS.get(position);
		}
	}
	
	public String getMovements() {
		return movements;
	}

}
