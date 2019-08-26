import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import entities.Map;
import entities.Mountain;
import entities.Player;
import entities.Treasure;
import exception.MapException;
import services.ExtractElementsFromFileService;
import services.WriteExitService;
import services.impl.ExtractElementsFromFileServiceImpl;
import services.impl.WriteExitServiceImpl;
import utils.Game;

public class WriteExitServiceTest {
	
	private WriteExitService writeFile = new WriteExitServiceImpl();
	private ExtractElementsFromFileService extractFile = new ExtractElementsFromFileServiceImpl();

	@Test
	public void testGenerateExitFile() {
		Map map = new Map(3, 4);
		List<Player> players = Arrays.asList(new Player(1, 2, "toto", "S", "AA", 2));
		List<Mountain> mountains = Arrays.asList(new Mountain(1, 1));
		List<Treasure> treasures = Arrays.asList(new Treasure(2, 3, 2));
		Game game = new Game(null, null, null, null);
		try {
			writeFile.generateExitFile(game, "src/test/resources/End.txt");
		} catch (MapException mex) {
			assertTrue(mex.getMessage().equals("Aucune carte n'a ete trouvee"));
		}
		
		Game game2 = new Game(map, mountains, treasures, players);
		try {
			writeFile.generateExitFile(game2, "src/test/resources/End.txt");
			assertTrue(extractFile.getMapObjectsFromFile("src/test/resources/End.txt").size() == 3);
			
		} catch (MapException mex) {
			
		}
	}

}
