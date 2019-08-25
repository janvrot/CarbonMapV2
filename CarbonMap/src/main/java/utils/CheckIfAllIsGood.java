package utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import entities.Map;
import entities.MapObject;
import entities.Player;
import entities.Treasure;
import exception.MapException;

public final class CheckIfAllIsGood {

	private CheckIfAllIsGood() {

	}

	public static List<MapObject> getFinalList(List<MapObject> objects) throws MapException {
		Map map = checkMap(objects);
		List<MapObject> finalMap = checkIfIsInMap(map, objects);
		if (map != null && !finalMap.isEmpty()) {
			return finalMap;
		} else
			throw new MapException("Il manque des elements pour demarrer la partie");
	}

	private static Map checkMap(List<MapObject> objects) {

		return objects.stream().filter(map -> map instanceof Map).map(map -> (Map) map).findFirst().orElse(null);

	}

	private static List<MapObject> checkIfIsInMap(Map map, List<MapObject> mapObjects) {

		List<MapObject> objects = mapObjects.stream().filter(mapObject -> !(mapObject instanceof Map))
				.filter(mapObject -> mapObject.getxPos() < map.getxPos() && mapObject.getyPos() < map.getyPos())
				.collect(Collectors.toList());
		
		if (containsPlayersAndTreasures(objects)) {
			return objects;
		} else {
			return Collections.emptyList();
		}
			
	}
	
	private static boolean containsPlayersAndTreasures(List<MapObject> objects) {
		
		boolean treasure = false;
		boolean player = false;
		
		for(MapObject obj: objects) {
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
