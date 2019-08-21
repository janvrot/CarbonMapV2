package map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.Explorer;
import entities.Carte;
import entities.MapObject;
import entities.Mountain;
import entities.Tresor;
import game.TheGame;

public class MapGen {

	private static MapGen mapGen;
	private Carte carte = null;
	private List<String> fileObjects = new ArrayList<String>();
	private List<MapObject> mountains = new ArrayList<>();
	private List<MapObject> tresors = new ArrayList<>();
	private List<MapObject> aventuriers = new ArrayList<>();

	// Recupere la liste des objets dans le fichier map
	public List<String> getFileObjects() {
		return this.fileObjects;
	}

	// Recupere les infos de la Carte
	public Carte getCarte() {
		return this.carte;
	}

	// Recupere les infos des montagnes
	public List<MapObject> getMountains() {
		return this.mountains;
	}

	// Recupere les infos des tresors
	public List<MapObject> getTresors() {
		return this.tresors;
	}

	// Recupere les infos des aventuriers
	public List<MapObject> getAventuriers() {
		return this.aventuriers;
	}

	// Chargement de la map en singleton
	private MapGen() {
		this.loadFile();
	}

	// Chargement du fichier map
	private void loadFile() {
		BufferedReader br = null;
		FileReader fr = null;

		try {
			File file = new File(getClass().getClassLoader().getResource("Map.txt").getFile());
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.charAt(0) != '#') {
					if (CheckStart.checkIfEnoughParams(sCurrentLine)) {
						this.fileObjects.add(sCurrentLine);
					}
				}
			}
			this.addMap();
			this.MapFactory();
			System.out.println("Generation de la partie");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null) {
					br.close();
				}

				if (fr != null) {
					fr.close();
				}

			} catch (IOException ex) {
				Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	// Instnce de MapGen en Singleton
	public static MapGen getInstance() {
		if (mapGen == null) {
			mapGen = new MapGen();
		}
		return mapGen;
	}

	// Creation de la carte
	private void addMap() {
		for (int i = 0; i < this.fileObjects.size(); i++) {
			String oneObject = this.fileObjects.get(i);
			String[] params = oneObject.split(" - ");
			if (params[0].equals("C")) {
				if (CheckStart.checkMap(oneObject)) {
					this.carte = new Carte();
					this.carte.setLengthMap(Integer.parseInt(params[1]));
					this.carte.setHighMap(Integer.parseInt(params[2]));
				}
			}
		}
	}

	// Creation des objets de la partie en factory
	private void MapFactory() {
		List<String> allObjects = this.fileObjects;
		MapObject mapObject = null;
		for (int i = 0; i < allObjects.size(); i++) {
			String oneObject = allObjects.get(i);
			String[] params = oneObject.split(" - ");
			switch (params[0]) {
			case "M":
				if (CheckStart.checkMountain(oneObject, this.carte)) {
					mapObject = new Mountain(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
					this.mountains.add(mapObject);
				}
				break;
			case "A":
				if (CheckStart.checkExplorer(oneObject, this.carte)) {
					mapObject = new Explorer(params[1], Integer.parseInt(params[2]), Integer.parseInt(params[3]),
							params[4], params[5]);
					this.aventuriers.add(mapObject);
				}
				break;
			case "T":
				if (CheckStart.checkTresor(oneObject, this.carte)) {
					mapObject = new Tresor(Integer.parseInt(params[1]), Integer.parseInt(params[2]),
							Integer.parseInt(params[3]));
					this.tresors.add(mapObject);
				}
				break;
			default:
				break;
			}
		}
	}
}
