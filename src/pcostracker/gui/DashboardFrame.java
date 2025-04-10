package pcostracker.gui;

import java.util.List;
import javax.swing.*;
import java.awt.*;

import pcostracker.dao.SymptomDAO;
import pcostracker.model.SymptomEntry;
import pcostracker.util.ReportExporter;

public class DashboardFrame extends JFrame {
    private String username;

    public DashboardFrame(String username) {
        this.username = username;

        setTitle("Welcome " + username + " - PCOS Tracker");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Hello, " + username + "! Here's your PCOS Dashboard.", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(welcomeLabel, BorderLayout.NORTH);

        JTextArea infoArea = new JTextArea("Coming soon:\n- Log symptoms\n- Cycle calendar\n- Check-up reminders\n- Export reports");
        infoArea.setEditable(false);
        add(infoArea, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton logSymptomBtn = new JButton("Log Symptom");
        logSymptomBtn.addActionListener(e -> new SymptomLoggerFrame(username));
        buttonPanel.add(logSymptomBtn);

        JButton cycleCalendarButton = new JButton("Cycle Calendar");
        cycleCalendarButton.addActionListener(e -> new CycleCalendarFrame(username));
        buttonPanel.add(cycleCalendarButton);

        JButton reminderButton = new JButton("Check-up Reminder");
        reminderButton.addActionListener(e -> new ReminderFrame(username));
        buttonPanel.add(reminderButton);

        JButton exportButton = new JButton("Export Reports");
        exportButton.addActionListener(e -> {
            List<SymptomEntry> entries = SymptomDAO.getSymptomsForUser(username);
            if (entries.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No symptoms to export!");
            } else {
                ReportExporter.exportToText(username, entries);
                JOptionPane.showMessageDialog(this, "Report exported as " + username + "_PCOS_Report.txt");
            }
        });
        buttonPanel.add(exportButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
