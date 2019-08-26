import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import entities.MapObject;
import exception.MapException;
import services.ExtractElementsFromFileService;
import services.impl.ExtractElementsFromFileServiceImpl;

public class ExtractElementsFromFileServiceTest {

	private ExtractElementsFromFileService extractElementsFromFileService = new ExtractElementsFromFileServiceImpl();

	@Test
	public void testgetMapObjectsFromFile() {
		try {
			extractElementsFromFileService.getMapObjectsFromFile("/test/Map.txt");
		} catch (MapException mex) {
			assertTrue(mex.getMessage().equals("Un problème est survenu à la lecture du fichier"));
		}

		try {
			List<MapObject> mapObject = extractElementsFromFileService
					.getMapObjectsFromFile("src/test/resources/Map.txt");
			assertFalse(mapObject.isEmpty());
			assertTrue(mapObject.size() == 6);
		} catch (MapException mex) {

		}
	}

}
