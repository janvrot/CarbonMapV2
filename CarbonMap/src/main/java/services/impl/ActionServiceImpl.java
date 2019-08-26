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

/**
 * Implementation de l'ActionService
 * 
 * @author antoinejanvrot
 *
 */
public class ActionServiceImpl implements ActionService {

	/**
	 * 
	 */
	@Override
	public boolean checkObstacle(Player player, List<Mountain> mountains, List<Player> players, Map map) {
		List<MapObject> objects = new ArrayList<>();
		objects.addAll(players);
		objects.addAll(mountains);
		return checkLimit(player, map) && checkOtherObstactle(player, objects);
	}

	/**
	 * Verifie aue les limites du terrain ne sont pas depassees
	 * 
	 * @param player l'aventurier en train de bouger
	 * @param map    la carte
	 * @return l'aventurier peut bouger
	 */
	private boolean checkLimit(Player player, Map map) {
		return player.getxPos() < map.getxPos() && player.getyPos() < map.getyPos();
	}

	/**
	 * Verifie si des obstacles ssont presents sur la carte
	 * 
	 * @param player  l'aventurier en train de bouger
	 * @param objects les objets sur la carte
	 * @return l'aventurier peut bouger
	 */
	private boolean checkOtherObstactle(Player player, List<MapObject> objects) {

		long count = objects.stream()
				.filter(object -> (object.getxPos() == player.getxPos() && object.getyPos() == player.getyPos()))
				.count();
		return count == 0;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public List<Treasure> treasuresLeft(Player player, List<Treasure> treasures) {
		treasures.forEach(treasure -> {
			if (treasure.getxPos() == player.getxPos() && treasure.getyPos() == player.getyPos()
					&& treasure.getTreasureNumber() > 0)
				treasure.removeTreasure();
		});
		return removeTreasuresIfZero(treasures);
	}

	/**
	 * Retire les tresors de la liste
	 * 
	 * @param treasures la liste des tresors
	 * @return la liste des tresors actualisee
	 */
	private List<Treasure> removeTreasuresIfZero(List<Treasure> treasures) {
		return treasures.stream().filter(treasure -> treasure.getTreasureNumber() > 0).collect(Collectors.toList());
	}
}
