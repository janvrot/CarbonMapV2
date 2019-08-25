package utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import entities.Game;
import entities.Map;
import entities.MapObject;
import entities.Mountain;
import entities.Player;
import entities.Treasure;
import exception.MapException;

public class CheckIfAllIsGood {

	public Game getFinalList(List<MapObject> objects) throws MapException {
		Map map = extractMap(objects);
		if (map != null) {
			List<MapObject> finalMap = checkIfIsInMap(map, objects);
			if (!finalMap.isEmpty()) {
				return new Game(map, extractMountains(finalMap), extractTreasures(finalMap), extractPlayers(finalMap));
			} else
				throw new MapException("Il manque des elements pour demarrer la partie");
		} else
			throw new MapException("Il n'y a pas de donnees de carte");
	}

	private Map extractMap(List<MapObject> objects) {

		return objects.stream().filter(map -> map instanceof Map).map(map -> (Map) map).findFirst().orElse(null);

	}

	private List<Player> extractPlayers(List<MapObject> objects) {

		return objects.stream().filter(player -> player instanceof Player).map(player -> (Player) player)
				.collect(Collectors.toList());

	}

	private List<Mountain> extractMountains(List<MapObject> objects) {

		return objects.stream().filter(mountain -> mountain instanceof Mountain).map(mountain -> (Mountain) mountain)
				.collect(Collectors.toList());

	}

	private List<Treasure> extractTreasures(List<MapObject> objects) {

		return objects.stream().filter(treasure -> treasure instanceof Treasure).map(treasure -> (Treasure) treasure)
				.collect(Collectors.toList());

	}

	private List<MapObject> checkIfIsInMap(Map map, List<MapObject> mapObjects) {

		List<MapObject> objects = mapObjects.stream().filter(mapObject -> !(mapObject instanceof Map))
				.filter(mapObject -> mapObject.getxPos() < map.getxPos() && mapObject.getyPos() < map.getyPos())
				.collect(Collectors.toList());

		if (containsPlayersAndTreasures(objects)) {
			return objects;
		} else {
			return Collections.emptyList();
		}

	}

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
