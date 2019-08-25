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
package services;

import java.util.List;

import entities.MapObject;
import exception.MapException;

public interface ExtractElementsFromFileService {
	
	/**
	 * Extrait les informations du fichier en entrée et les convertit en Liste d'objets
	 *
	 * @param filePath
	 * 		le chemin vers le fichier
	 * @return
	 * 		la liste contenant tous les objets présents sur la carte
	 * @throws MapException
	 */
	public List<MapObject> getMapObjectsFromFile(String filePath) throws MapException;
}

