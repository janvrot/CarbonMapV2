package game;

import java.util.List;

import entities.Carte;
import entities.Explorer;
import entities.MapObject;
import entities.Mountain;
import entities.Tresor;

public class WriteExit {

	// Ecriture de la carte sur le fichier de sortie
	public String getMap(Carte carte) {
		String str = "";
		str += "# {C comme carte} - {Axe horizontal} - {Axe vertical} \r\n";
		str += carte.toString() + "\r\n";
		return str;
	}
	
	// Ecriture des montgnes sur le fichier de sortie
	public String getMountains(List<MapObject> mountains) {
		String str = "";
		str += "# {M comme montagne} - {Axe horizontal} - {Axe vertical} \r\n";
		for (int i = 0; i < mountains.size(); i++) {
			Mountain mountain = (Mountain) mountains.get(i);
			str += mountain.toString() + "\r\n";
		}
		return str;
	}
	
	// Ecriture des aventuriers sur le fichier de sortie
	public String getExplorers(List<MapObject> explorers) {
		String str = "";
		str += "# {A comme Aventurier} - {Nom de l'aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. tresors ramasses}\r\n";
		for (int i = 0; i < explorers.size(); i++) {
			Explorer explorer = (Explorer) explorers.get(i);
			str += explorer.toString() + "\r\n";
		}
		return str;
	}
	
	// Ecriture des tresors sur le fichier de sortie
	public String getTresors(List<MapObject> tresors) {
		String str = "";
		str += "# {T comme Tresor} - {Axe horizontal} - {Axe vertical} - {Nb. de tresors restants}\r\n";
		if (tresors.size() > 0) {
			for (int i = 0; i < tresors.size(); i++) {
				Tresor tresor = (Tresor) tresors.get(i);
				str += tresor.toString() + "\r\n";
			}
		}
		return str;
	}
}
