package services;

import java.util.List;

import entities.MapObject;
import exception.MapException;

/**
 * Recupere les elements depuis le fichier
 * 
 * @author antoinejanvrot
 *
 */
public interface ExtractElementsFromFileService {

	/**
	 * Recupere les elements depuis le fichier
	 * 
	 * @param filePath le chemin vers le fichier
	 * @return Les objets dans la carte
	 * @throws MapException
	 */
	public List<MapObject> getMapObjectsFromFile(String filePath) throws MapException;
}
