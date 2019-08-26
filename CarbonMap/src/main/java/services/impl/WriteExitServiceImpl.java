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
import utils.Game;

public class WriteExitServiceImpl implements services.WriteExitService {

	@Override
	public void generateExitFile(Game game) throws MapException {
		if (game.getMap() != null) {
			String str = getFinalString(game);
			try (FileWriter fileWriter = new FileWriter("src/main/resources/End.txt"); BufferedWriter writer = new BufferedWriter(fileWriter);) {
				writer.write(str);
			} catch (IOException ex) {
				throw new MapException();
			}
		}
	}

	private String getFinalString(Game game) {
		StringBuilder finalString = new StringBuilder();
		List<MapObject> finalList = game.getGenericList();
		for (MapObject mapObject : finalList) {
			finalString.append(mapObject.toString());
		}
		return finalString.toString();
	}
}

