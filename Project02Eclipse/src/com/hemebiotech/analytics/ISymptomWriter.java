package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {

    // Déclaration de la méthode writeSymptoms qui sera instanciée par la classe WriteSymptomDataToFile
        public void writeSymptoms (Map<String, Integer> symptoms);

     }
