package utils;

import constants.MapConstants;
import exception.MapException;
import services.CheckIfAllGoodService;
import services.ExtractElementsFromFileService;
import services.WriteExitService;
import services.impl.CheckIfAllIsGoodServiceImpl;
import services.impl.ExtractElementsFromFileServiceImpl;
import services.impl.WriteExitServiceImpl;

public class App
{	
	private static CheckIfAllGoodService parameters = new CheckIfAllIsGoodServiceImpl();
	private static WriteExitService writeExit = new WriteExitServiceImpl();
	private static ExtractElementsFromFileService mapObjects = new ExtractElementsFromFileServiceImpl();
	
	public static void main(String[] args) throws MapException {
		Game game = parameters.getFinalList(mapObjects.getMapObjectsFromFile(MapConstants.DEFAULT_FILE_PATH));
		game.playGame();
		writeExit.generateExitFile(game);
	}
}
