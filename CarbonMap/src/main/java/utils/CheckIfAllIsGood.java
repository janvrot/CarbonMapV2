package utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import entities.Map;
import entities.MapObject;

public final class CheckIfAllIsGood {

	private CheckIfAllIsGood() {

	}

	public static List<MapObject> getFinalList(List<MapObject> objects) {
		Map map = checkMap(objects);
		if (map != null) {
			return checkIfIsInMap(map, objects);
		} else
			return Collections.emptyList();
	}

	private static Map checkMap(List<MapObject> objects) {

		return objects.stream().filter(map -> map instanceof Map).map(map -> (Map) map).findFirst().orElse(null);

	}

	private static List<MapObject> checkIfIsInMap(Map map, List<MapObject> mapObjects) {

		return mapObjects.stream().filter(mapObject -> !(mapObject instanceof Map))
				.filter(mapObject -> mapObject.getxPos() < map.getxPos() && mapObject.getyPos() < map.getyPos())
				.collect(Collectors.toList());
	}
}
