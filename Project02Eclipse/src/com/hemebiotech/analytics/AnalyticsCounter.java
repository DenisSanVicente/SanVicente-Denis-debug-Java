package com.hemebiotech.analytics;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
    private static int headacheCount = 0;	// initialize to 0
    private static int rashCount = 0;		// initialize to 0
    private static int pupilCount = 0;		// initialize to 0

    // 1. Attributs
    private ISymptomReader reader;
    private ISymptomWriter writer;
    private String finalList;

    // 1. Constructeur
    public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    // 2. Méthode getSymptoms
    @Override
    public List<String> getSymptoms () { // Utilisation de l'instance de l'interface ISymptomReader
        this.reader.GetSymptoms(); // Lecture du fichier et alimentation de getSymptoms
        return getSymptoms(); // Retour de getSymptoms
    }

    // 3. Méthode countSymptoms
    public Map<String, Integer> countSymptoms (List<String> symptoms) {
        Map<String, Integer> count = new HashMap<>(); // Déclaration de la HashMap où seront stockées les données

        for (String symptom : symptoms) { // Pour chaque symptômes dans la liste des symptômes
            int oldValue = count.get(symptom); // Déclaration d'une variable pour la gestion des doublons

            if (count.containsKey(symptom)) { // Si le symptôme a déjà été listé
                count.put(symptom, oldValue + 1); // On incrémente la quantité qui lui a déjà été attribué
            }

            else {
                count.put(symptom, 1); // Sinon on ajoute le nom du symptôme avec la valeur de 1
            }
        }

        return count; // On retourne la Map count
    }

    // 4. Méthode sortSymptoms
    public Map<String, Integer> sortSymptoms (Map<String, Integer> symptoms) {

        // Déclaration de la Map triée (TreeMap)
        TreeMap<String, Integer> sorted = new TreeMap<>();

        // On ajoute dans la nouvelle Map la liste des symptômes
        sorted.putAll(symptoms);

        // On renvoie la TreeMap
        return sorted;
    }

    /** 5. Méthode writeSymptoms
     *
    public void writeSymptoms (Map<String, Integer> symptoms) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"))) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
     */


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
