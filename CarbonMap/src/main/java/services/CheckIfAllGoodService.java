package services;

import java.util.List;

import entities.MapObject;
import exception.MapException;
import utils.Game;

/**
 * Verifie si la partie peut etre lancee
 * 
 * @author antoinejanvrot
 *
 */
public interface CheckIfAllGoodService {

	/**
	 * Recupere la liste finale avant lancement
	 * 
	 * @param objects Les objets dans la carte
	 * @return La liste contenant les objets
	 * @throws MapException
	 */
	public Game getFinalList(List<MapObject> objects) throws MapException;
}
