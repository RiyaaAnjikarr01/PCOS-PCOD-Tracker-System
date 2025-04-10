/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pcostracker.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import pcostracker.gui.DashboardFrame;


public class LoginRegisterFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;

    public LoginRegisterFrame() {
        setTitle("PCOS Tracker - Login/Register");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        add(loginButton);
        add(registerButton);

        // Action Listeners
        loginButton.addActionListener(e -> handleLogin());
        registerButton.addActionListener(e -> handleRegister());

        setVisible(true);
    }

    private void handleLogin() {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());
        // TODO: Validate from database
        JOptionPane.showMessageDialog(this, "Login successful (Placeholder)");
        // Open DashboardFrame after login
        new DashboardFrame(user);
        dispose();
    }

    private void handleRegister() {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());
        // TODO: Save to database
        JOptionPane.showMessageDialog(this, "User registered (Placeholder)");
    }
}
