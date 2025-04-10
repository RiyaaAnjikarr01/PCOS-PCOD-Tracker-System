/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pcostracker.gui;

import pcostracker.model.SymptomEntry;
import pcostracker.dao.SymptomDAO;


import javax.swing.*;
import java.awt.*;

public class SymptomLoggerFrame extends JFrame {
    public SymptomLoggerFrame(String username) {
        setTitle("Log Symptoms - " + username);
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        JLabel symptomLabel = new JLabel("Symptom:");
        JTextField symptomField = new JTextField();
        JLabel severityLabel = new JLabel("Severity (1-10):");
        JTextField severityField = new JTextField();
        JLabel notesLabel = new JLabel("Notes:");
        JTextArea notesArea = new JTextArea();

        JButton saveButton = new JButton("Save");

        add(symptomLabel); add(symptomField);
        add(severityLabel); add(severityField);
        add(notesLabel); add(new JScrollPane(notesArea));
        add(new JLabel()); add(saveButton);

        saveButton.addActionListener(e -> {
        String symptom = symptomField.getText();
    int severity = Integer.parseInt(severityField.getText());
    String notes = notesArea.getText();

    SymptomEntry s = new SymptomEntry(username, symptom, severity, notes);
    boolean saved = SymptomDAO.saveSymptom(s);

    if (saved) {
        JOptionPane.showMessageDialog(this, "Symptom saved successfully!");
        dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to save symptom.");
    }
        });

        setVisible(true);
    }
}

