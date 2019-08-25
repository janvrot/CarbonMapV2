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

public class Map extends MapObject {

	public Map(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public Map() {
		
	}

	@Override
	public MapObject verifyParamsAndReturnObject(String[] params) {
		if(verifyParameters.checkNumberParameters(3, params) 
				&& verifyParameters.isNumericAndMoreThanZero(params[1]) 
				&& verifyParameters.isNumericAndMoreThanZero(params[2])) 
		return new Map(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
		else
			return null;
	}

}
