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

import services.VerifyParametersService;
import services.impl.VerifyParametersServiceImpl;

public abstract class MapObject {

	protected int xPos;
	protected int yPos;
	
	protected VerifyParametersService verifyParameters = new VerifyParametersServiceImpl();
	
	public abstract MapObject verifyParamsAndReturnObject(String[] params);
}

