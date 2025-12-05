package com.hemebiotech.analytics;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    /** Constructeur writeSymptomDataToFile prenant en paramètre un élément de type String nommé filepath */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }


    /** Instanciation de la méthode writeSymptoms déclarée dans l'interface ISymptomWriter
     *  Gestion de l'exception avec try/catch */
    @Override
    public void writeSymptoms (Map<String, Integer> symptoms) {
        String filepath = "result.out";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) { // On essaie d'écrire dans le fichier crée
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) { // Pour chaque entrée dans la Map, on attribue une clé d'entrée
                writer.write(entry.getKey() + " : " + entry.getValue()); // Pour chaque clé (symptôme) entrée, on lui attribue une valeur
                writer.newLine(); // On passe une ligne après chaque saisie de clé/valeur
            }
        }
        catch (IOException e) { // On attrappe l'exception et on la remplace pour un message d'erreur générique
            e.printStackTrace();
        }
    }
}
