package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    /** Création de la méthode main */

    public static void main (String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        /** Appel des méthodes dans l'ordre */
        List<String> getSymptoms = counter.getSymptoms(); // 1. On lit les symptômes dans le fichier symptoms.txt
        Map<String, Integer> count = counter.countSymptoms(getSymptoms); // 2. On compte le nombre d'occurrence des symptômes depuis getSymptoms
        Map<String, Integer> sort = counter.sortSymptoms(count); // 3. On trie les symptômes dans l'ordre
        counter.writeSymptoms(sort); // 4. On écrit les symptômes dans le fichier "result.out"
    }
}