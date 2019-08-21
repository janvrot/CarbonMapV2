package game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.Carte;
import entities.Explorer;
import entities.MapObject;
import entities.Mountain;
import entities.Tresor;
import map.MapGen;

public class TheGame {

	private static String[] position = { "N", "O", "S", "E" };
	private Carte carte = MapGen.getInstance().getCarte();
	private List<MapObject> mountains = MapGen.getInstance().getMountains();
	private List<MapObject> tresors = MapGen.getInstance().getTresors();
	private List<MapObject> explorers = MapGen.getInstance().getAventuriers();

	
	// Deroulement de la partie
	public boolean moveExplorer() {
		int length = 0;
		if (this.explorers.size() > 0) {
			for (int i = 0; i < explorers.size(); i++) {
				Explorer explorer = (Explorer) explorers.get(i);
				String move = explorer.getActions();
				char[] moveArray = move.toCharArray();
				length = longerAction(moveArray, length);
			}
			if (checkExplorers(this.explorers)) {
				eachPlayer(length);
				this.generateExitFile();
				System.out.println("Partie terminee consultez le fichier End.txt");
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// Verification de la plus longue boucle d'actions
	private int longerAction(char[] moveArray, int length) {
		if (moveArray.length > length) {
			length = moveArray.length;
		}
		return length;
	}

	// Tour par tour des aventuriers
	private void eachPlayer(int longer) {
		for (int i = 0; i < longer; i++) {
			for (int j = 0; j < explorers.size(); j++) {
				Explorer explorer = (Explorer) explorers.get(j);
				String move = explorer.getActions();
				char[] moveArray = move.toCharArray();
				String pos = explorer.getOrientation();
				int orientation = getPos(pos);
				if (i < moveArray.length) {
					String orientationBis = move(orientation, moveArray[i], explorer);
					explorer.setOrientation(orientationBis);
				}
				System.out.print(explorer.getOrientation());
				System.out.print(explorer.getX());
				System.out.print(explorer.getY() + "\n");
			}
		}
	}

	// Generation du fichier de sortie
	public void generateExitFile() {
		if (this.carte != null) {
			BufferedWriter writer = null;
			String str = "";
			try {
				writer = new BufferedWriter(new FileWriter("src/main/resources/End.txt"));
			} catch (IOException ex) {
				Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
			}

			str += this.finalString();

			try {
				writer.write(str);
			} catch (IOException ex) {
				Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
			}
			try {
				writer.close();
			} catch (IOException ex) {
				Logger.getLogger(TheGame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	// Creation du texte du fichier de sortie
	private String finalString() {
		String str = "";
		WriteExit write = new WriteExit();
		str += write.getMap(this.carte);
		str += write.getMountains(this.mountains);
		str += write.getTresors(this.tresors);
		str += write.getExplorers(this.explorers);
		return str;
	}

	// Verifie si le mouvement de l'aventurier depasse les limites de la carte
	private boolean borderMap(int y, int x, Carte carte) {
		if (x < 0 || x > carte.getLengthMap() - 1) {
			return false;
		} else if (y < 0 || y > carte.getHighMap() - 1) {
			return false;
		} else {
			return true;
		}
	}

	// Verifie si l'aventurier croise une montagne
	private boolean isNotMountain(int y, int x, List<MapObject> mountains) {
		boolean result = true;
		if (mountains.size() > 0) {
			for (int i = 0; i < mountains.size(); i++) {
				Mountain mountain = (Mountain) mountains.get(i);
				if (x == mountain.getX() && y == mountain.getY()) {
					result = false;
				} else {
					result = true;
				}
			}
		}
		return result;
	}

	// Verifie si l'aventurier croise un autre aventurier
	private boolean isNotExplorer(int y, int x, List<MapObject> explorers) {
		boolean result = true;
		if (explorers.size() > 1) {
			for (int i = 0; i < explorers.size(); i++) {
				Explorer explorer = (Explorer) explorers.get(i);
				if (x == explorer.getX() && y == explorer.getY()) {
					result = false;
				} else {
					result = true;
				}
			}
		}
		return result;
	}

	// Verifie si 2 aventuriers ont les memes coordonnees au depart
	private boolean checkExplorers(List<MapObject> explorers) {
		boolean result = true;
		if (explorers.size() > 0) {
			int x = 0;
			int y = 0;
			for (int i = 0; i < explorers.size(); i++) {
				Explorer explorer = (Explorer) explorers.get(i);
				if (i == 0) {
					x = explorer.getX();
					y = explorer.getY();
					result = true;
				} else {
					if (explorer.getX() == x && explorer.getY() == y) {
						result = false;
					} else {
						x = explorer.getX();
						y = explorer.getY();
						result = true;
					}
				}
			}
		}
		return result;
	}

	// Verifie si l'aventurier croise un tresor
	private void isTresor(int y, int x, List<MapObject> tresors, Explorer explorer) {
		if (tresors.size() > 0) {
			for (int i = 0; i < tresors.size(); i++) {
				Tresor tresor = (Tresor) tresors.get(i);
				if (x == tresor.getX() && y == tresor.getY()) {
					addTresor(explorer);
					removeTresor(tresor);
				}
			}
		}
	}

	// Ajoute un tresor a l'aventurier
	private void addTresor(Explorer explorer) {
		int myTresors = explorer.getMyTresors();
		explorer.setMyTresors(myTresors + 1);
	}

	// Supprime un tresor de la case
	private void removeTresor(Tresor tresor) {
		int tresors = tresor.getNumber();
		tresor.setNumber(tresors - 1);
		if (tresor.getNumber() == 0) {
			this.tresors.remove(tresor);
		}
	}

	// Recupere l'orientation d'un aventurier
	private int getPos(String pos) {
		int i;
		int result = 0;
		for (i = 0; i < TheGame.position.length; i++) {
			if (TheGame.position[i].equals(pos)) {
				result = i;
			}
		}
		return result;
	}

	// Deplace un aventurier
	private String move(int pos, char move, Explorer explorer) {
		switch (move) {
		case 'D':
			pos = changeDirection(pos, 1);
			break;
		case 'G':
			pos = changeDirection(pos, -1);
			break;
		case 'A':
			this.realMove(pos, explorer);
			isTresor(explorer.getY(), explorer.getX(), this.tresors, explorer);
			break;
		}
		return TheGame.position[pos];
	}

	// Change l'orientation d'un aventurier
	private static int changeDirection(int pos, int move) {
		pos = pos + move;
		if (pos < 0) {
			pos = 4 + move;
		}
		if (pos > 3) {
			pos = pos - 4;
		}
		return pos;
	}

	// Fait avancer un aventurier
	private void realMove(int pos, Explorer explorer) {
		String move = TheGame.position[pos];
		switch (move) {
		case "N":
			this.moveDown(explorer);
			break;
		case "S":
			this.moveUp(explorer);
			break;
		case "O":
			this.moveRight(explorer);
			break;
		case "E":
			this.moveLeft(explorer);
			break;
		}
	}

	// Avance en haut
	private void moveUp(Explorer explorer) {
		int y = explorer.getY();
		if (borderMap(y + 1, explorer.getX(), this.carte) && isNotMountain(y + 1, explorer.getX(), this.mountains)
				&& isNotExplorer(y + 1, explorer.getX(), this.explorers)) {
			explorer.setY(y + 1);
		}
	}

	// Avance en bas
	private void moveDown(Explorer explorer) {
		int y = explorer.getY();
		if (borderMap(y - 1, explorer.getX(), this.carte) && isNotMountain(y - 1, explorer.getX(), this.mountains)
				&& isNotExplorer(y - 1, explorer.getX(), this.explorers)) {
			explorer.setY(y - 1);
		}
	}

	// Avance a gauche
	private void moveLeft(Explorer explorer) {
		int x = explorer.getX();
		if (borderMap(explorer.getY(), x - 1, this.carte) && isNotMountain(explorer.getY(), x - 1, this.mountains)
				&& isNotExplorer(explorer.getY(), x - 1, this.explorers)) {
			explorer.setX(x - 1);
		}
	}

	// Avance a droite
	private void moveRight(Explorer explorer) {
		int x = explorer.getX();
		if (borderMap(explorer.getY(), x + 1, this.carte) && isNotMountain(explorer.getY(), x + 1, this.mountains)
				&& isNotExplorer(explorer.getY(), x + 1, this.explorers)) {
			explorer.setX(x + 1);
		}
	}
}
