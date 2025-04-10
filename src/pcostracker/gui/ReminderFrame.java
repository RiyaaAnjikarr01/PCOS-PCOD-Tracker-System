package pcostracker.gui;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReminderFrame extends JFrame {
    private JTextField reminderDateField;
    private JTextField noteField;

    public ReminderFrame(String username) {
        setTitle("Set Check-up Reminder - " + username);
        setSize(400, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        add(new JLabel("Enter reminder date (yyyy-MM-dd):"));
        reminderDateField = new JTextField();
        add(reminderDateField);

        add(new JLabel("Add notes (e.g., Doctor Name):"));
        noteField = new JTextField();
        add(noteField);

        JButton setReminderButton = new JButton("Set Reminder");
        add(setReminderButton);

        setReminderButton.addActionListener(e -> {
            try {
                LocalDate date = LocalDate.parse(reminderDateField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String note = noteField.getText();
                JOptionPane.showMessageDialog(this, "Reminder set for " + date + " (" + note + ")");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid date. Use format yyyy-MM-dd");
            }
        });

        setVisible(true);
    }
}
