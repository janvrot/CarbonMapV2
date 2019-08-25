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
	
	public void move(String orientation) {
		
	}
	
	public void move(String orientation, String direction) {
		
	}

	@Override
	public <T extends MapObject> T verifyParamsAndReturnObject(String[] params) {
		return null;
	}
}

