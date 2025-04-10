package pcostracker.gui;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CycleCalendarFrame extends JFrame {
    private JTextField lastPeriodField;
    private JLabel nextPeriodLabel;

    public CycleCalendarFrame(String username) {
        setTitle("Cycle Calendar - " + username);
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        add(new JLabel("Enter last period date (yyyy-MM-dd):"));
        lastPeriodField = new JTextField();
        add(lastPeriodField);

        JButton calculateButton = new JButton("Calculate Next Cycle");
        add(calculateButton);

        nextPeriodLabel = new JLabel("Next cycle: ");
        add(nextPeriodLabel);

        calculateButton.addActionListener(e -> {
            String inputDate = lastPeriodField.getText();
            try {
                LocalDate lastDate = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate nextCycle = lastDate.plusDays(28); // standard cycle
                nextPeriodLabel.setText("Next cycle starts: " + nextCycle);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Use yyyy-MM-dd");
            }
        });

        setVisible(true);
    }
}
