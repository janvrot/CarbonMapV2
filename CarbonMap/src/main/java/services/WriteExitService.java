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
 * Créé le 26 août 2019.
 * </p>
 */
package services;

import exception.MapException;
import utils.Game;

/**
 * Ecriture du fichier de sortie
 * 
 * @author antoinejanvrot
 *
 */
public interface WriteExitService {

	/**
	 * Ecriture du fichier de sortie
	 * 
	 * @param game
	 * 		le resultat de la partie
	 * @throws MapException
	 */
	public void generateExitFile(Game game, String filePath) throws MapException;
}

