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
package services.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import entities.MapObject;
import exception.MapException;
import services.WriteExitService;
import utils.Game;

/**
 * Implementation du WriteExitService
 * 
 * @author antoinejanvrot
 *
 */
public class WriteExitServiceImpl implements WriteExitService {

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void generateExitFile(Game game, String filePath) throws MapException {
		if (game.getMap() != null) {
			String str = getFinalString(game);
			try (FileWriter fileWriter = new FileWriter(filePath);
					BufferedWriter writer = new BufferedWriter(fileWriter);) {
				writer.write(str);
			} catch (IOException ex) {
				throw new MapException("Probleme lors de l'ecriture du fichier");
			}
		} else {
			throw new MapException("Aucune carte n'a ete trouvee");
		}
	}

	/**
	 * Recupere les informations a ecrire dans le fichier de sortie
	 * 
	 * @param game les donnees de fin de partie
	 * @return le texte a ecrire
	 */
	private String getFinalString(Game game) {
		StringBuilder finalString = new StringBuilder();
		List<MapObject> finalList = game.getGenericList();
		for (MapObject mapObject : finalList) {
			finalString.append(mapObject.toString());
		}
		return finalString.toString();
	}
}
