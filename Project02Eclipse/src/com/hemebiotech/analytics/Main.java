package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main (String[] args) {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        /* Appel des méthodes dans l'ordre
        *  Utilisation des instances ISymptomReader, ISymptomWriter et AnalyticsCounter
        *  On lit, on compte, on trie et on écrit les symptômes et leurs occurrences dans le fichier "result.out"
        */
        List<String> getSymptoms = counter.getSymptoms(); // 1. On lit les symptômes dans le fichier symptoms.txt
        Map<String, Integer> count = counter.countSymptoms(getSymptoms); // 2. On compte le nombre d'occurrence des symptômes depuis getSymptoms
        Map<String, Integer> sort = counter.sortSymptoms(count); // 3. On trie les symptômes dans l'ordre
        counter.writeSymptoms(sort); // 4. On écrit les symptômes dans le fichier "result.out"
    }
}