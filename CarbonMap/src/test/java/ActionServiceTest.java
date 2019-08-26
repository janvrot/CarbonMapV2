import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entities.Map;
import entities.Mountain;
import entities.Player;
import entities.Treasure;
import services.ActionService;
import services.impl.ActionServiceImpl;

public class ActionServiceTest {
	
	private ActionService actionService = new ActionServiceImpl();

	@Test
	public void testCheckObstacle() {
		List<Mountain> mountains = new ArrayList<>();
		List<Player> players = new ArrayList<>();
		Map map = new Map(3, 4);
		mountains.add(new Mountain(2, 3));
		players.add(new Player(2, 1, "toto", "N", "AAG", 0));
		Player player = new Player(3, 1, "toto", "N", "AAG", 0);
		Player player2 = new Player(2, 3, "toto", "N", "AAG", 0);
		Player player3 = new Player(2, 1, "toto", "N", "AAG", 0);
		Player player4 = new Player(1, 1, "toto", "N", "AAG", 0);
		assertFalse(actionService.checkObstacle(player, mountains, players, map));
		assertFalse(actionService.checkObstacle(player2, mountains, players, map));
		assertFalse(actionService.checkObstacle(player3, mountains, players, map));
		assertTrue(actionService.checkObstacle(player4, mountains, players, map));
	}
	
	@Test
	public void testTreasuresLeft() {
		List<Treasure> treasures = new ArrayList<>();
		treasures.add(new Treasure(1, 1, 1));
		treasures.add(new Treasure(1, 2, 2));
		Player player = new Player(1, 1, "toto", "N", "AAG", 0);
		Player player2 = new Player(1, 2, "toto", "N", "AAG", 0);
		assertTrue(actionService.treasuresLeft(player, treasures).size() == 1);
		assertTrue(actionService.treasuresLeft(player2, treasures).get(0).getTreasureNumber() == 1);
		
	}

}
