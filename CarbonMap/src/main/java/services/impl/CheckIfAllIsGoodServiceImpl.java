package services.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import entities.Map;
import entities.MapObject;
import entities.Mountain;
import entities.Player;
import entities.Treasure;
import exception.MapException;
import services.CheckIfAllGoodService;
import utils.Game;

/**
 * Implementation du CheckIfAllGoodService
 * 
 * @author antoinejanvrot
 *
 */
public class CheckIfAllIsGoodServiceImpl implements CheckIfAllGoodService {

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public Game getFinalList(List<MapObject> objects) throws MapException {
		Map map = extractMap(objects);
		if (map != null) {
			List<MapObject> finalMap = checkIfIsInMap(map, objects);
			if (!finalMap.isEmpty()) {
				return new Game(map, extractMountains(finalMap), extractTreasures(finalMap), extractPlayers(finalMap));
			} else {
				throw new MapException("Il manque des elements pour demarrer la partie");
			}
		} else {
			throw new MapException("Il n'y a pas de donnees de carte");
		}
	}

	/**
	 * Extrait les objets Map de la liste
	 * 
	 * @param objects la liste initiale
	 * @return l'objet Map
	 */
	private Map extractMap(List<MapObject> objects) {

		return objects.stream().filter(map -> map instanceof Map).map(map -> (Map) map).findFirst().orElse(null);

	}

	/**
	 * Extrait les objets Player
	 * 
	 * @param objects la liste initiale
	 * @return la liste des aventuriers
	 */
	private List<Player> extractPlayers(List<MapObject> objects) {

		return objects.stream().filter(player -> player instanceof Player).map(player -> (Player) player)
				.collect(Collectors.toList());

	}

	/**
	 * Extrait les objets Mountain
	 * 
	 * @param objects la liste initiale
	 * @return la liste des montagnes
	 */
	private List<Mountain> extractMountains(List<MapObject> objects) {

		return objects.stream().filter(mountain -> mountain instanceof Mountain).map(mountain -> (Mountain) mountain)
				.collect(Collectors.toList());

	}

	/**
	 * Extrait les objets Treasure
	 * 
	 * @param objects la liste initiale
	 * @return la liste des tresors
	 */
	private List<Treasure> extractTreasures(List<MapObject> objects) {

		return objects.stream().filter(treasure -> treasure instanceof Treasure).map(treasure -> (Treasure) treasure)
				.collect(Collectors.toList());

	}

	/**
	 * Verifie aue les objets sont bien sur la carte
	 * 
	 * @param map        la carte
	 * @param mapObjects les differents objets
	 * @return les objets presents sur la carte
	 */
	private List<MapObject> checkIfIsInMap(Map map, List<MapObject> mapObjects) {

		List<MapObject> objects = mapObjects.stream().filter(mapObject -> !(mapObject instanceof Map))
				.filter(mapObject -> mapObject.getxPos() < map.getxPos() && mapObject.getyPos() < map.getyPos())
				.collect(Collectors.toList());

		if (containsPlayersAndTreasures(objects) && !checkIfStartAtTheSamePoint(objects)) {
			return objects;
		} else {
			return Collections.emptyList();
		}
	}

	/**
	 * Verifie aue deux objets n'ont pas les memes coordonnees
	 * 
	 * @param objects les objets sur la carte
	 * @return les objets n'ont pas les memes coordonnees
	 */
	private boolean checkIfStartAtTheSamePoint(List<MapObject> objects) {
		boolean result = false;
		for (MapObject mapObject : objects) {
			if (objects.stream().filter(
					object -> object.getxPos() == mapObject.getxPos() && object.getyPos() == mapObject.getyPos())
					.filter(object -> object != mapObject).count() > 0) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * Verifie que la partie contient bien des aventuriers et des tresors
	 * 
	 * @param objects les objets sur la carte
	 * @return la partie contient bien des aventuriers et des tresors
	 */
	private boolean containsPlayersAndTreasures(List<MapObject> objects) {

		boolean treasure = false;
		boolean player = false;

		for (MapObject obj : objects) {
			if (obj instanceof Treasure)
				treasure = true;
			if (obj instanceof Player)
				player = true;
		}

		if (treasure && player)
			return true;
		else
			return false;
	}
}
