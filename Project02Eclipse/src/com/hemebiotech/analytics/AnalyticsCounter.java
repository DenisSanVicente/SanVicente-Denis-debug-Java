package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/** DECLARATION DES ATTRIBUTS
 * Utiliser protected au lieu de private ?
 * Déclarer simplement les variables sans initialiser à 0 ?
 *
 */

public class AnalyticsCounter {
	private static int headacheCount = 0;
    private static int rashCount = 0;
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

        /** CALCUL DU NOMBRE D'OCCURRENCE DES SYMPTOMES
         *  Boucles while qui permet de parcourir tout le fichier texte tant qu'il y a une ligne de symptôme à analyser
         *  Pourquoi incrémenter i++ ?
         *  Cette boucle permet-elle de répertorier tous les symptômes ?
         */
        
		int i = 0;
		int headCount = 0;
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
