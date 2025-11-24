package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    @Override
    public void writeSymptoms (Map<String, Integer> symptoms) {

        // Déclaration du nom du fichier qui stockera les données
        String symptomsList = "result.out";

        // Déclaration de la Map qui stockera les données
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(symptomsList))) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
