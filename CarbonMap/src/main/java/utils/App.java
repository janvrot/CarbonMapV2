package utils;

import constants.MapConstants;
import entities.Game;
import exception.MapException;

public class App
{	
	private static CheckIfAllIsGood parameters = new CheckIfAllIsGood();
	
	public static void main(String[] args) throws MapException {
		Game game = parameters.getFinalList(ExtractElementsFromFile.getMapObjectsFromFile(MapConstants.DEFAULT_FILE_PATH));
		System.out.println(game);
	}
}
