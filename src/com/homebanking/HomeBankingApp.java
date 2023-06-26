package com.homebanking;

import javax.swing.*;
import java.awt.*;

public class HomeBankingApp {
    public static void main(String[] args) {
        // Crear el marco principal de la aplicación
        JFrame frame = new JFrame("Home Banking App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        // Crear un panel para contener el formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(50, 50, 300, 180);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Crear una etiqueta para el título
        JLabel titleLabel = new JLabel("Home Banking App");
        titleLabel.setBounds(100, 20, 200, 30);
        frame.add(titleLabel);

        // Crear etiquetas y campos de texto para los datos
        JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setBounds(10, 10, 100, 20);
        formPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(110, 10, 180, 20);
        formPanel.add(nameField);

        JLabel lastNameLabel = new JLabel("Apellido:");
        lastNameLabel.setBounds(10, 40, 100, 20);
        formPanel.add(lastNameLabel);

        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(110, 40, 180, 20);
        formPanel.add(lastNameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 70, 100, 20);
        formPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(110, 70, 180, 20);
        formPanel.add(emailField);

        JLabel dniLabel = new JLabel("DNI:");
        dniLabel.setBounds(10, 100, 100, 20);
        formPanel.add(dniLabel);

        JTextField dniField = new JTextField();
        dniField.setBounds(110, 100, 180, 20);
        formPanel.add(dniField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(10, 130, 100, 20);
        formPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(110, 130, 180, 20);
        formPanel.add(passwordField);

        // Agregar el panel del formulario al marco principal
        frame.add(formPanel);

        // Mostrar la interfaz
        frame.setVisible(true);
    }
}