import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entities.Map;
import entities.MapObject;
import entities.Mountain;
import entities.Player;
import entities.Treasure;
import exception.MapException;
import services.CheckIfAllGoodService;
import services.impl.CheckIfAllIsGoodServiceImpl;

public class CheckIfAllIsGoodServiceTest {

	private CheckIfAllGoodService allIsGood = new CheckIfAllIsGoodServiceImpl();

	@Test
	public void testGetFinalList() {

		List<MapObject> mapObjects = new ArrayList<>();
		Map map = new Map(3, 4);
		Mountain mountain = new Mountain(4, 4);
		Treasure treasure = new Treasure(2, 3, 1);
		Player player = new Player(1, 2, "toto", "N", "AAG", 0);
		mapObjects.add(mountain);
		mapObjects.add(map);

		try {
			allIsGood.getFinalList(mapObjects);
		} catch (MapException mex) {
			assertTrue(mex.getMessage().equals("Il manque des elements pour demarrer la partie"));
		}

		mapObjects.clear();
		mapObjects.add(mountain);

		try {
			allIsGood.getFinalList(mapObjects);
		} catch (MapException mex) {
			assertTrue(mex.getMessage().equals("Il n'y a pas de donnees de carte"));
		}

		mapObjects.add(treasure);
		mapObjects.add(player);
		mapObjects.add(map);

		try {
			allIsGood.getFinalList(mapObjects);
			assertFalse(allIsGood.getFinalList(mapObjects).getGenericList().isEmpty());
			assertTrue(allIsGood.getFinalList(mapObjects).getGenericList().size() == 3);
		} catch (MapException mex) {
		}
	}

}
