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
 * Créé le 26 août 2019.
 * </p>
 */
package services;

import java.util.List;

import entities.Map;
import entities.Mountain;
import entities.Player;
import entities.Treasure;

public interface ActionService {

	public boolean checkObstacle(Player player, List<Mountain> mountains, List<Player> players, Map map);
	
	public List<Treasure> treasuresLeft(Player player, List<Treasure> treasures);
}

