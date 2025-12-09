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


    public List<String> getSymptoms() {
        /** Parcourir le fichier de symptômes
         * @return la liste des symptômes identifiés
         */
        return reader.getSymptoms();
    }


    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        /** Méthode qui va compter le nombre de symptômes identifés et leurs occurrences en gérant les doublons
         * Création d'une Map pour attribuer clé/valeur (symptômes/quantité)
         * @param liste de String appellée symptoms
         * @return la Map renseignée avec les clés symptômes/quantité
         * */
        Map<String, Integer> count = new HashMap<>(); // Création de la Map qui va stocker les données
        for (String symptom : symptoms) { // Pour chaque symptômes identifié dans la liste des symptômes
            count.put(symptom, count.getOrDefault(symptom, 0) + 1); // Si le symptôme exsite déjà, on incrémente, sinon on crée le sypmtôme dans la liste
        }
        return count; // On retourne la Map renseignée
    }


    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        /** Méthode qui trie les symptômes dans l'ordre alphabétique sous forme de TreeMap
         * @param Map de symptoms pour associer une clé à une valeur
         * @return la Map renseignée dans l'ordre alphabétique
         */
        Map<String, Integer> sort = new TreeMap<>(); // Création d'une TreeMap qui organise les symptômes par ordre alphabétique
        sort.putAll(symptoms); // On ajoute tous les symptômes à la Map
        return sort; // On renvoie la Map remplie
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        /** Méthode writeSymptoms sans retour qui écrit les symptômes et leurs occurrences dans une Map
         *  @param Map de symptoms
         */
        this.writer.writeSymptoms(symptoms);
    }
}