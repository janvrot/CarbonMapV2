package utils;

import java.util.ArrayList;
import java.util.List;

import entities.Map;
import entities.MapObject;
import entities.Mountain;
import entities.Player;
import entities.Treasure;
import services.ActionService;
import services.impl.ActionServiceImpl;

/**
 * Class utilitaire permettant d'executer la partie
 * 
 * @author antoinejanvrot
 *
 */
public class Game {

	private Map map;
	private List<Mountain> mountains;
	private List<Treasure> treasures;
	private List<Player> players;
	private ActionService action = new ActionServiceImpl();

	/**
	 * constructeur avec parametres
	 * 
	 * @param map       la carte
	 * @param mountains les montagnes
	 * @param treasures les tresors
	 * @param players   les aventuriers
	 */
	public Game(Map map, List<Mountain> mountains, List<Treasure> treasures, List<Player> players) {
		super();
		this.map = map;
		this.mountains = mountains;
		this.treasures = treasures;
		this.players = players;
	}

	/**
	 * Boucle d'execution de la partie
	 */
	public void playGame() {
		int turn = 0;
		while (canContinue(turn)) {
			List<Player> futurePlayers = new ArrayList<>();
			for (Player player : players) {
				if (canPlay(turn, player)) {
					String[] move = player.getMovements().split("");
					moveOrTurn(move[turn], player);
					futurePlayers.add(player);
				} else {
					futurePlayers = players;
				}
			}
			players = futurePlayers;
			turn++;
		}
	}

	/**
	 * Verifie si u moins un joueur peut jouer
	 * 
	 * @param turn le tour de jeu
	 * @return au moins un joueur peut jouer
	 */
	private Boolean canContinue(int turn) {
		boolean result = false;
		for (Player player : players) {
			if (canPlay(turn, player)) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * Verifie si le joueur peut jouer
	 * 
	 * @param turn   le tour actuel
	 * @param player le joueur selectionne
	 * @return le joueur peut jouer
	 */
	private boolean canPlay(int turn, Player player) {
		return player.getMovements().length() > turn;
	}

	/**
	 * Deplace le joueur
	 * 
	 * @param player le joueur en cours
	 * @return le joueur peut bouger
	 */
	private boolean doAction(Player player) {
		Player futurePlayer = new Player();
		futurePlayer.setxPos(player.getxPos());
		futurePlayer.setyPos(player.getyPos());
		futurePlayer.setOrientation(player.getOrientation());
		futurePlayer.move(futurePlayer.getOrientation());
		return action.checkObstacle(futurePlayer, mountains, players, map);
	}

	/**
	 * Deplace ou tourne le joueur
	 * 
	 * @param move   le mouvement effectue
	 * @param player le joueur courant
	 */
	private void moveOrTurn(String move, Player player) {
		if (move.equals("A")) {
			if (doAction(player)) {
				player.move(player.getOrientation());
				int firstCount = getTreasures(treasures);
				treasures = action.treasuresLeft(player, treasures);
				int newCount = getTreasures(treasures);
				if (firstCount > newCount)
					player.addTreasure();
			}
		} else {
			player.turn(player.getOrientation(), move);
		}
	}

	/**
	 * Recupere le total de tresors
	 * 
	 * @param treasures les objets Treasure
	 * @return le nombre de tresors restants
	 */
	private int getTreasures(List<Treasure> treasures) {
		int result = 0;
		for (Treasure treasure : treasures) {
			result = result + treasure.getTreasureNumber();
		}
		return result;
	}

	/**
	 * @return {@link #map}
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * @return {@link #mountains}
	 */
	public List<Mountain> getMountains() {
		return mountains;
	}

	/**
	 * @return {@link #treasures}
	 */
	public List<Treasure> getTreasures() {
		return treasures;
	}

	/**
	 * @return {@link #players}
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * Recupere tous les objets sous forme de liste generiaue
	 * 
	 * @return la liste des objets de la carte
	 */
	public List<MapObject> getGenericList() {
		List<MapObject> objects = new ArrayList<>();
		objects.add(map);
		objects.addAll(mountains);
		objects.addAll(treasures);
		objects.addAll(players);
		return objects;
	}
}
