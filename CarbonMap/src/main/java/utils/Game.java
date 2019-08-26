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

public class Game {

	private Map map;
	private List<Mountain> mountains;
	private List<Treasure> treasures;
	private List<Player> players;
	private ActionService action = new ActionServiceImpl();

	public Game(Map map, List<Mountain> mountains, List<Treasure> treasures, List<Player> players) {
		super();
		this.map = map;
		this.mountains = mountains;
		this.treasures = treasures;
		this.players = players;
	}

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

	private boolean canPlay(int turn, Player player) {
		return player.getMovements().length() > turn;
	}

	private boolean doAction(Player player) {
		Player futurePlayer = new Player();
		futurePlayer.setxPos(player.getxPos());
		futurePlayer.setyPos(player.getyPos());
		futurePlayer.setOrientation(player.getOrientation());
		futurePlayer.move(futurePlayer.getOrientation());
		return action.checkObstacle(futurePlayer, mountains, players, map);
	}

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

	private int getTreasures(List<Treasure> treasures) {
		int result = 0;
		for (Treasure treasure : treasures) {
			result = result + treasure.getTreasureNumber();
		}
		return result;
	}

	public Map getMap() {
		return map;
	}

	public List<Mountain> getMountains() {
		return mountains;
	}

	public List<Treasure> getTreasures() {
		return treasures;
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	public List<MapObject> getGenericList() {
		List<MapObject> objects = new ArrayList<>();
		objects.add(map);
		objects.addAll(mountains);
		objects.addAll(treasures);
		objects.addAll(players);
		return objects;
	}
}
