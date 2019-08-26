package services;

import java.util.List;

import entities.Map;
import entities.Mountain;
import entities.Player;
import entities.Treasure;

/**
 * Verification si les actions sont possibles
 * 
 * @author antoinejanvrot
 *
 */
public interface ActionService {

	/**
	 * Verifie si il y a un obstacle
	 * 
	 * @param player    l'aventurier
	 * @param mountains les montagnes
	 * @param players   les avnturiers
	 * @param map       la carte
	 * @return la verification
	 */
	public boolean checkObstacle(Player player, List<Mountain> mountains, List<Player> players, Map map);

	/**
	 * Verifie les tresors restants apres passage du joueur
	 * 
	 * @param player    le joueur
	 * @param treasures les tresors
	 * @return les tresors restants
	 */
	public List<Treasure> treasuresLeft(Player player, List<Treasure> treasures);
}
