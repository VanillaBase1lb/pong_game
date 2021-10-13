package pong_game;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.*;
import java.awt.event.*;

public class Settings {
    static int bat_length = 150;
    static int bat_thickness = 15;
    static int bat_sensitivity = 8;
    static Color ball_color = Color.blue;
    static boolean special_ball_physics = true;

    JFrame frame2;
    Container c;
    JPanel batSensitivityPanel, settingsFunctionPanel, titlePanel, buttonPanel, batSensitivitySliderPanel,
            batLengthPanel, colorTextPanel, batLengthSliderPanel, colorButtonPanel, batThicknessPanel,
            batThicknessSliderPanel, radioTextPanel, radioButtonPanel;
    JLabel titleName, batSensitivity, batLength, ballColor, batThickness, ballRandomisation;
    Font textFont = new Font("Ariel", Font.PLAIN, 50);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton, settingsButton;
    JSlider batSensitivitySlider, batLengthSlider, batThicknessSlider;
    JColorChooser colorChooser;
    JRadioButton r1, r2;
    ButtonGroup bg1;

    public Settings() {
        // Creating Frame
        frame2 = new JFrame();
        frame2.setSize(1280, 820);
        frame2.setTitle("Settings");
        frame2.setResizable(false);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.getContentPane().setBackground(Color.black);
        frame2.setLayout(null);
        frame2.setVisible(true);
        c = frame2.getContentPane();

        // Creating Bat Sensitivity Slider
        batSensitivityPanel = new JPanel();
        batSensitivityPanel.setBounds(237, 50, 300, 50);
        batSensitivityPanel.setBackground(Color.white);

        batSensitivity = new JLabel("Bat Sensitivity :");
        batSensitivity.setForeground(Color.black);
        batSensitivity.setFont(normalFont);

        batSensitivitySliderPanel = new JPanel();
        batSensitivitySliderPanel.setBounds(237, 100, 300, 50);
        batSensitivitySliderPanel.setBackground(Color.white);

        batSensitivitySlider = new JSlider(JSlider.HORIZONTAL, 3, 10, 8);
        batSensitivitySlider.setMinorTickSpacing(1);
        batSensitivitySlider.setMajorTickSpacing(1);
        batSensitivitySlider.setPaintTicks(true);
        batSensitivitySlider.setPaintLabels(true);
        batSensitivitySlider.addChangeListener(new BatSensitivityListener());

        // Creating Bat Length Slider
        batLengthPanel = new JPanel();
        batLengthPanel.setBounds(762, 50, 300, 50);
        batLengthPanel.setBackground(Color.white);

        batLength = new JLabel("Bat Length Adjust :");
        batLength.setForeground(Color.black);
        batLength.setFont(normalFont);

        batLengthSliderPanel = new JPanel();
        batLengthSliderPanel.setBounds(762, 100, 300, 50);
        batLengthSliderPanel.setBackground(Color.white);

        batLengthSlider = new JSlider(JSlider.HORIZONTAL, 50, 250, 150);
        batLengthSlider.setMinorTickSpacing(0);
        batLengthSlider.setMajorTickSpacing(50);
        batLengthSlider.setPaintTicks(true);
        batLengthSlider.setPaintLabels(true);
        batLengthSlider.addChangeListener(new BatLengthListener());

        // Creating Bat Thickness Slider
        batThicknessPanel = new JPanel();
        batThicknessPanel.setBounds(762, 200, 300, 50);
        batThicknessPanel.setBackground(Color.white);

        batThickness = new JLabel("Bat Thickness Adjust :");
        batThickness.setForeground(Color.black);
        batThickness.setFont(normalFont);

        batThicknessSliderPanel = new JPanel();
        batThicknessSliderPanel.setBounds(762, 250, 300, 50);
        batThicknessSliderPanel.setBackground(Color.white);

        batThicknessSlider = new JSlider(JSlider.HORIZONTAL, 0, 20, 15);
        batThicknessSlider.setMinorTickSpacing(0);
        batThicknessSlider.setMajorTickSpacing(5);
        batThicknessSlider.setPaintTicks(true);
        batThicknessSlider.setPaintLabels(true);
        batLengthSlider.addChangeListener(new BatThicknessListener());

        // Color Panel and Color Chooser
        colorTextPanel = new JPanel();
        colorTextPanel.setBounds(315, 350, 650, 50);
        colorTextPanel.setBackground(Color.white);

        ballColor = new JLabel("Select Color of Ball :");
        ballColor.setFont(normalFont);
        ballColor.setForeground(Color.black);

        colorButtonPanel = new JPanel();
        colorButtonPanel.setBounds(315, 400, 650, 325);
        colorButtonPanel.setBackground(Color.white);

        colorChooser = new JColorChooser(Color.white);
        colorChooser.getSelectionModel().addChangeListener(new BallColorListener());

        // Creating Radio Buttons
        radioTextPanel = new JPanel();
        radioTextPanel.setBounds(237, 200, 300, 50);
        radioTextPanel.setBackground(Color.white);

        ballRandomisation = new JLabel("Ball Randomisation :");
        ballRandomisation.setFont(normalFont);
        ballRandomisation.setForeground(Color.black);

        radioButtonPanel = new JPanel();
        radioButtonPanel.setBounds(237, 250, 300, 50);
        radioButtonPanel.setBackground(Color.white);

        r1 = new JRadioButton("ON");
        r2 = new JRadioButton("OFF");
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);
        r1.setSelected(true);
        r1.setActionCommand("on");
        r2.setActionCommand("off");
        r1.addActionListener(new RadioButtonListner());
        r2.addActionListener(new RadioButtonListner());

        colorButtonPanel.add(colorChooser);
        colorTextPanel.add(ballColor);
        batSensitivitySliderPanel.add(batSensitivitySlider);
        batSensitivityPanel.add(batSensitivity);
        batLengthPanel.add(batLength);
        batLengthSliderPanel.add(batLengthSlider);
        batThicknessPanel.add(batThickness);
        batThicknessSliderPanel.add(batThicknessSlider);
        radioTextPanel.add(ballRandomisation);
        radioButtonPanel.add(r1);
        radioButtonPanel.add(r2);
        c.add(batSensitivityPanel);
        c.add(batSensitivitySliderPanel);
        c.add(batLengthPanel);
        c.add(batLengthSliderPanel);
        c.add(batThicknessPanel);
        c.add(batThicknessSliderPanel);
        c.add(colorTextPanel);
        c.add(colorButtonPanel);
        c.add(radioTextPanel);
        c.add(radioButtonPanel);
    }

    class BatLengthListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            Settings.bat_length = batLengthSlider.getValue();
        }
    }

    class BatThicknessListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            Settings.bat_thickness = batThicknessSlider.getValue();
        }
    }

    class BatSensitivityListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            Settings.bat_sensitivity = batSensitivitySlider.getValue();
        }
    }

    class BallColorListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            Settings.ball_color = colorChooser.getColor();
        }
    }

    class RadioButtonListner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "on":
                    Settings.special_ball_physics = true;
                    break;
                case "off":
                    Settings.special_ball_physics = false;
                    break;
            }
        }
    }

}