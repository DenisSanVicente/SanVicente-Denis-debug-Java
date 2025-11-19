package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter { // La classe implémente la méthode de l'interface

    // Implémentation de la méthode en Override
    @Override
    public void ISymptomWriter (Map<String, Integer> symptoms) {

        // Déclaration du nom de fichier en String
        String symptomsList = "result.out";

        // Ecriture dans le fichier avec la gestion des exceptions en Try/Catch
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(symptomsList))) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) { // Pour chaque entrée clé/valeur : générer une valeur associée
                writer.write(entry.getKey() + " : " + entry.getValue()); // Récupérer la clé (getKey) et l'associer à une valeur (getValue)
                writer.newLine(); // Retour à la ligne après chaque saisie clé/valeur
            }
        }

        catch (IOException e) { // On attrape l'exception pour afficher un message d'erreur en retour
            System.err.println("Erreur lors de l'écriture du fichier");
        }

    }

}
