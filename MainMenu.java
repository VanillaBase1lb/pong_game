package pong_game;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class MainMenu {
    JFrame frame1;
    Container c;
    JPanel titlePanel, buttonPanel, settingsFunctionPanel;
    JLabel titleName;
    Font titleFont = new Font("Ariel", Font.PLAIN, 100);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton, settingsButton, helpButton;
    StartScreenHandler ssh = new StartScreenHandler();
    SettingsScreenHandler ssH = new SettingsScreenHandler();
    HelpScreenHandler HSH = new HelpScreenHandler();
    JSlider slider;

    public static void main(String[] args) {
        new MainMenu();
    }

    public MainMenu() {
        // Creating Frame
        frame1 = new JFrame();
        frame1.setSize(1280, 820);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.getContentPane().setBackground(Color.black);
        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setTitle("Main Menu");
        c = frame1.getContentPane();

        // Creating Panel for Title
        titlePanel = new JPanel();
        titlePanel.setBounds(280, 100, 700, 150);
        titlePanel.setBackground(Color.white);

        // Creating Title and adding it to Panel
        titleName = new JLabel("PING - PONG");
        titleName.setForeground(Color.black);
        titleName.setFont(titleFont);

        // Creating Panel for Buttons
        buttonPanel = new JPanel();
        buttonPanel.setBounds(525, 500, 200, 160);
        buttonPanel.setBackground(Color.white);

        // Creatting Start Button
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(ssh);

        // Creating Settings Button
        settingsButton = new JButton("SETTINGS");
        settingsButton.setBackground(Color.black);
        settingsButton.setForeground(Color.white);
        settingsButton.setFont(normalFont);
        settingsButton.addActionListener(ssH);

        // Creating Help Button
        helpButton = new JButton("HELP");
        helpButton.setBackground(Color.black);
        helpButton.setForeground(Color.white);
        helpButton.setFont(normalFont);
        helpButton.addActionListener(HSH);

        titlePanel.add(titleName);
        buttonPanel.add(startButton);
        buttonPanel.add(settingsButton);
        buttonPanel.add(helpButton);
        c.add(titlePanel);
        c.add(buttonPanel);

    }

    public class StartScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Game game = new Game();
            game.setTable();

            Thread frame_refresher = new Thread(game);
            frame_refresher.start();
        }
    }

    public class SettingsScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            new Settings();
        }
    }

    public class HelpScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            new Help();
        }

    }

}