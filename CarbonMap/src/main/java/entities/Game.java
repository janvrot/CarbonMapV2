package entities;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private Map map;
	private List<Mountain> mountains;
	private List<Treasure> treasures;
	private List<Player> players;
	
	@Override
	public String toString() {
		return "Game [map=" + map + ", mountains=" + mountains + ", treasures=" + treasures + ", players=" + players
				+ "]";
	}

	public Game(Map map, List<Mountain> mountains, List<Treasure> treasures, List<Player> players) {
		super();
		this.map = map;
		this.mountains = mountains;
		this.treasures = treasures;
		this.players = players;
	}
	
	public List<MapObject> playGame() {
		int turn = 0;
		while(canContinue(turn)) {
			List<Player> nextTurn = new ArrayList<Player>();
			players.forEach(player -> {
				if (canPlay(turn, player)) {
					nextTurn.add(doAction(player));
				}
			});
			players = nextTurn;
		}
		return null;
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
		if (player.getMovements().length() > turn) {
			return true;
		} else {
			return false;
		}
	}
	
	private  Player doAction(Player player) {
		return player;
		
	}
}
