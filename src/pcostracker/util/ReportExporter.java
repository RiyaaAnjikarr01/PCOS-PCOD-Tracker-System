package pcostracker.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import pcostracker.model.SymptomEntry;

public class ReportExporter {

    public static void exportToText(String username, List<SymptomEntry> symptoms) {
        String fileName = username + "_PCOS_Report.txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("PCOS Symptom Report for " + username + "\n\n");
            for (SymptomEntry entry : symptoms) {
                writer.write("Symptom: " + entry.getSymptom() + "\n");
                writer.write("Severity: " + entry.getSeverity() + "\n");
                writer.write("Notes: " + entry.getNotes() + "\n");
                //writer.write("Timestamp: " + entry.getTimestamp() + "\n");
                writer.write("-------------------------\n");
            }
            System.out.println("Report exported to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
