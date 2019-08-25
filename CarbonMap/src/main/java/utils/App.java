package utils;

import constants.MapConstants;
import exception.MapException;

public class App
{	
	public static void main(String[] args) throws MapException {
		System.out.println(CheckIfAllIsGood.getFinalList(ExtractElementsFromFile.getMapObjectsFromFile(MapConstants.DEFAULT_FILE_PATH)));
	}
}
