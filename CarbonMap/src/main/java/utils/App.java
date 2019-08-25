package utils;

import constants.MapConstants;
import exception.MapException;
import services.ExtractElementsFromFileService;
import services.impl.ExtractElementsFromFileServiceImpl;

public class App
{
	private static ExtractElementsFromFileService extractedElements = new ExtractElementsFromFileServiceImpl();
	
	public static void main(String[] args) throws MapException {
		System.out.println(extractedElements.getMapObjectsFromFile(MapConstants.DEFAULT_FILE_PATH));
	}
}
