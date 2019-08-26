import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import entities.Map;
import entities.MapObject;
import entities.Mountain;
import entities.Player;
import entities.Treasure;
import utils.Game;

public class GameTest {

	@Test
	public void testGame() {
		Map map = new Map(3, 4);
		List<Player> players = Arrays.asList(new Player(1, 1, "toto", "S", "AADADAGGA", 0));
		List<Mountain> mountains = Arrays.asList(new Mountain(1, 0), new Mountain(2, 1));
		List<Treasure> treasures = Arrays.asList(new Treasure(0, 3, 2), new Treasure(1, 3, 3));
		Game game = new Game(map, mountains, treasures, players);
		
		game.playGame();
		List<MapObject> finalObjects = game.getGenericList();
		
		assertTrue(finalObjects.size() == 5);
	}

}
