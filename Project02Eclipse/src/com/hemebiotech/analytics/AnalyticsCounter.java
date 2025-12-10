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

    // Déclaration des deux attributs ISymptomReader et ISymptomWriter
    private ISymptomReader reader;
    private ISymptomWriter writer;

    // Constructeur AnalyticsCoutner prenant en pamramètre les attributs déclarés précédemment
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /** Méthode sans paramètre qui va parcourir le fichier de symptômes et lire les symptômes du fichier
     * @return getSymptoms
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /** Méthode qui va compter le nombre de symptômes identifés et leurs occurrences en gérant les doublons
     * @param symptoms Map de symptômes associant une clé et une valeur
     * @return la Map renseignée avec les clés symptômes/quantité
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {

        Map<String, Integer> count = new HashMap<>(); // Création de la Map qui va stocker les données
        for (String symptom : symptoms) { // Pour chaque symptômes identifié dans la liste des symptômes
            count.put(symptom, count.getOrDefault(symptom, 0) + 1); // Si le symptôme exsite déjà, on incrémente, sinon on crée le sypmtôme dans la liste
        }
        return count;
    }

    /** Méthode qui trie les symptômes dans l'ordre alphabétique sous forme de TreeMap
     * @param symptoms Map de symptômes associant une clé à une valeur
     * @return la Map renseignée dans l'ordre alphabétique
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

        Map<String, Integer> sort = new TreeMap<>(); // Création d'une TreeMap qui organise les symptômes par ordre alphabétique
        sort.putAll(symptoms); // On ajoute tous les symptômes à la Map
        return sort;
    }

    /** Méthode writeSymptoms sans retour qui écrit les symptômes et leurs occurrences dans une Map
     *  @param symptoms de symptoms
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        this.writer.writeSymptoms(symptoms);
    }
}