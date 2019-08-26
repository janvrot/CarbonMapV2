package services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Map;
import entities.MapObject;
import entities.Mountain;
import entities.Player;
import entities.Treasure;
import services.ActionService;

public class ActionServiceImpl implements ActionService {

	@Override
	public boolean checkObstacle(Player player, List<Mountain> mountains, List<Player> players, Map map) {
		List<MapObject> objects = new ArrayList<>();
		objects.addAll(players);
		objects.addAll(mountains);
		return checkLimit(player, map) && checkOtherObstactle(player, objects);
	}

	private boolean checkLimit(Player player, Map map) {
		return player.getxPos() < map.getxPos() && player.getyPos() < map.getyPos();
	}

	private boolean checkOtherObstactle(Player player, List<MapObject> objects) {

		long count = objects.stream().filter(
				object -> (object.getxPos() == player.getxPos() && object.getyPos() == player.getyPos())).count();
		return count == 0;
	}
	
	@Override
	public List<Treasure> treasuresLeft(Player player, List<Treasure> treasures) {
		treasures.forEach(treasure -> {
			if (treasure.getxPos() == player.getxPos() && treasure.getyPos() == player.getyPos() && treasure.getTreasureNumber() > 0)
				treasure.removeTreasure();
		});
		return removeTreasuresIfZero(treasures);
	}
	
	private List<Treasure> removeTreasuresIfZero(List<Treasure> treasures) {
		return treasures.stream().filter(treasure -> treasure.getTreasureNumber() > 0).collect(Collectors.toList());
	}
}
