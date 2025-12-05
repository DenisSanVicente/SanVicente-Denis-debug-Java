package com.hemebiotech.analytics;

import javax.lang.model.util.AbstractAnnotationValueVisitor6;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
    private static int headacheCount = 0;	// initialize to 0
    private static int rashCount = 0;		// initialize to 0
    private static int pupilCount = 0;		// initialize to 0

    /**
     * Déclaration des deux attributs ISymptomReader et ISymptomWriter
     */
    private ISymptomReader reader;
    private ISymptomWriter writer;

    /**
     * Constructeur AnalyticsCoutner prenant en pamramètre les attributs déclarés précédemment
     */
    public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /** Création de la méthode getSymptoms
     * Cette méthode utilise l'instance de ISymptomReader et retourne la liste getSymptoms
     * */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }


    /** Méthode countSymptoms */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> count = new HashMap<>(); // Création de la Map qui va stocker les données

        for (String symptom : symptoms) { // Pour chaque symptômes identifié dans la liste des symptômes
            count.put(symptom, count.getOrDefault(symptom, 0) + 1); // Si le symptôme exsite déjà, on incrémente, sinon on crée le sypmtôme dans la liste
        }
        return count; // On retourne la Map renseignée
    }

    /** Méthode sortSymptoms */
    public Map<String, Integer> sortSymptoms (Map<String, Integer> symptoms) {
        Map<String, Integer> sort = new TreeMap<>(); // Création d'une TreeMap qui organise les symptômes par ordre alphabétique
        sort.putAll(symptoms); // On ajoute tous les symptômes de la Map
        return sort; // On renvoie la Map remplie
    }

    /** Méthode write Symptoms */
    public void writeSymptoms (Map<String, Integer> symptoms) {
        this.writer.writeSymptoms(symptoms);
    }



    
    public static void main(String args[]) throws Exception {
        // first get input
        BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
        String line = reader.readLine();

        int i = 0;	// set i to 0
        int headCount = 0;	// counts headaches
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