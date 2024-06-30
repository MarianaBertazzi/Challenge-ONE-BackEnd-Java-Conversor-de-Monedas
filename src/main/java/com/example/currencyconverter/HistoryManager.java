package com.example.currencyconverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private static final List<ConversionRecord> conversionHistory = new ArrayList<>();
    private static final String HISTORY_FILE = "conversion_history.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void addConversionRecord(ConversionRecord record) {
        conversionHistory.add(record);
    }

    public void showConversionHistory() {
        System.out.println("Historial de Conversiones:");
        for (ConversionRecord record : conversionHistory) {
            System.out.println(record);
        }
    }

    public void saveConversionHistory() {
        try (FileWriter writer = new FileWriter(HISTORY_FILE)) {
            gson.toJson(conversionHistory, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el historial de conversiones: " + e.getMessage());
        }
    }
}
