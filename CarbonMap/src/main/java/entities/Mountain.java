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

public class Mountain extends MapObject {

	public Mountain(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public Mountain() {
		
	}

	@Override
	public MapObject verifyParamsAndReturnObject(String[] params) {
		if(verifyParameters.checkNumberParameters(3, params) 
				&& verifyParameters.isNumericAndPositive(params[1]) 
				&& verifyParameters.isNumericAndPositive(params[2])) 
		return new Mountain(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
		else
			return null;
	}


}

