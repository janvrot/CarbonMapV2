
package services.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import constants.MapConstants;
import entities.Map;
import entities.MapObject;
import entities.Mountain;
import entities.Player;
import entities.Treasure;
import exception.MapException;
import services.ExtractElementsFromFileService;

/**
 * Extrait les elements du fichier d'entree
 * 
 * @author antoinejanvrot
 *
 */
public final class ExtractElementsFromFileServiceImpl implements ExtractElementsFromFileService {

	/**
	 * Récupère les lignes du fichier texte et les stocke dans une liste
	 *
	 * @return La liste contenant les lignes du fichier
	 * @throws MapException
	 */
	private List<String> extractFileLinesWithoutSpaces(String filePath) throws MapException {
		List<String> lines = new ArrayList<>();
		try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr);) {
			String line = null;

			while ((line = br.readLine()) != null) {
				lines.add(line.replaceAll("\\s", "").toUpperCase());
			}
		} catch (IOException e) {
			throw new MapException("Un problème est survenu à la lecture du fichier", e);
		}
		return lines;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public List<MapObject> getMapObjectsFromFile(String filePath) throws MapException {

		List<MapObject> mapObjects = new ArrayList<>();
		List<String> mapLines = extractFileLinesWithoutSpaces(filePath);

		mapLines.forEach(line -> {
			MapObject object = getMapObject(line);
			if (object != null) {
				mapObjects.add(object);
			}
		});
		return mapObjects;
	}

	/**
	 * Recupere un objet
	 * 
	 * @param line la ligne contenant les infos de l'objet
	 * @return l'objet trouve
	 */
	private MapObject getMapObject(String line) {

		String[] params = line.split("-");
		if (MapConstants.OBJECTS_IDENTIFIER.contains(params[0]) && null != getMapObjectTypeFromKey(params)) {
			return getMapObjectTypeFromKey(params);
		} else {
			return null;
		}
	}

	/**
	 * Genere un objet sur la carte
	 * 
	 * @param params les parametres trouves dans le fichier
	 * @return l'objet genere
	 */
	private MapObject getMapObjectTypeFromKey(String[] params) {
		switch (params[0]) {
		case "C":
			return new Map().verifyParamsAndReturnObject(params);
		case "M":
			return new Mountain().verifyParamsAndReturnObject(params);
		case "T":
			return new Treasure().verifyParamsAndReturnObject(params);
		case "A":
			return new Player().verifyParamsAndReturnObject(params);
		default:
			return null;
		}
	}

}
