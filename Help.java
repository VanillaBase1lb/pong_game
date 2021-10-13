package pong_game;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class Help {
    JFrame frame3;
    Container c;
    JPanel titlePanel, buttonPanel, settingsFunctionPanel, controlPanel, playerOnePanel, playerTwoPanel,
            playerOneButtonPanel, playerTwoButtonPanel, instructionPanel, instructionTextPanel1, instructionTextPanel2,
            instructionTextPanel3, instructionTextPanel4, creatorPanel, creatorPanel1, creatorPanel2;
    JLabel titleName, controlText, playerOne, playerTwo, instructions, instructionText1, instructionText2,
            instructionText3, instructionText4, creatorText, creator1Text, creator2Text;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font normalFont = new Font("Calibri", Font.PLAIN, 30);
    JButton startButton, settingsButton, helpButton, wButton, sButton, pButton, lButton;
    JSlider slider;

    public Help() {
        frame3 = new JFrame();
        frame3.setSize(1280, 820);
        frame3.setResizable(false);
        frame3.setTitle("Help");
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame3.getContentPane().setBackground(Color.black);
        frame3.setLayout(null);
        frame3.setVisible(true);
        c = frame3.getContentPane();

        // Control Panel
        controlPanel = new JPanel();
        controlPanel.setBounds(500, 50, 300, 50);
        controlPanel.setBackground(Color.white);

        // Adding Text to Control Panel
        controlText = new JLabel("Controls :");
        controlText.setForeground(Color.black);
        controlText.setFont(titleFont);

        // Player One Panel
        playerOnePanel = new JPanel();
        playerOnePanel.setBounds(237, 125, 300, 50);
        playerOnePanel.setBackground(Color.white);

        playerOne = new JLabel("Player One :");
        playerOne.setForeground(Color.black);
        playerOne.setFont(normalFont);

        // Player One Button Panel
        playerOneButtonPanel = new JPanel();
        playerOneButtonPanel.setBounds(237, 175, 300, 90);
        playerOneButtonPanel.setBackground(Color.white);

        wButton = new JButton("W");
        wButton.setBackground(Color.black);
        wButton.setForeground(Color.white);
        wButton.setFont(normalFont);

        sButton = new JButton("S ");
        sButton.setBackground(Color.black);
        sButton.setForeground(Color.white);
        sButton.setFont(normalFont);

        // Player Two Panel
        playerTwoPanel = new JPanel();
        playerTwoPanel.setBounds(762, 125, 300, 50);
        playerTwoPanel.setBackground(Color.white);

        playerTwo = new JLabel("Player Two :");
        playerTwo.setForeground(Color.black);
        playerTwo.setFont(normalFont);

        // Player Two Button Panel
        playerTwoButtonPanel = new JPanel();
        playerTwoButtonPanel.setBounds(762, 175, 300, 90);
        playerTwoButtonPanel.setBackground(Color.white);

        pButton = new JButton("P");
        pButton.setBackground(Color.black);
        pButton.setForeground(Color.white);
        pButton.setFont(normalFont);

        lButton = new JButton("L ");
        lButton.setBackground(Color.black);
        lButton.setForeground(Color.white);
        lButton.setFont(normalFont);

        // Instruction Panel
        instructionPanel = new JPanel();
        instructionPanel.setBounds(500, 300, 300, 50);
        instructionPanel.setBackground(Color.white);

        instructions = new JLabel("Instuctions :");
        instructions.setForeground(Color.black);
        instructions.setFont(titleFont);

        /*instructionTextPanel1 = new JPanel();
        instructionTextPanel1.setBounds(312, 350, 900, 50);
        instructionTextPanel1.setBackground(Color.white);

        instructionText1 = new JLabel("*Press 'CAPS LOCK' button on you keyboard to
        enable controls.");
        instructionText1.setForeground(Color.black);
        instructionText1.setFont(normalFont);*/

        instructionTextPanel2 = new JPanel();
        instructionTextPanel2.setBounds(200, 375, 900, 50);
        instructionTextPanel2.setBackground(Color.white);

        instructionText2 = new JLabel("*Press 'B' button on your keyboard to start.");
        instructionText2.setForeground(Color.black);
        instructionText2.setFont(normalFont);

        instructionTextPanel3 = new JPanel();
        instructionTextPanel3.setBounds(200, 425, 900, 50);
        instructionTextPanel3.setBackground(Color.white);

        instructionText3 = new JLabel("*The maximum ball speed is directly proprtional to the bat thicknesss.");
        instructionText3.setForeground(Color.black);
        instructionText3.setFont(normalFont);

        instructionTextPanel4 = new JPanel();
        instructionTextPanel4.setBounds(200, 475, 900, 50);
        instructionTextPanel4.setBackground(Color.white);

        instructionText4 = new JLabel("*Press 'ESC' button on your keyboard to exit.");
        instructionText4.setForeground(Color.black);
        instructionText4.setFont(normalFont);

        // About the Creators
        creatorPanel = new JPanel();
        creatorPanel.setBounds(500, 600, 300, 50);
        creatorPanel.setBackground(Color.white);

        creatorText = new JLabel("The Creators :");
        creatorText.setForeground(Color.black);
        creatorText.setFont(titleFont);

        // Creator1
        creatorPanel1 = new JPanel();
        creatorPanel1.setBounds(175, 675, 400, 50);
        creatorPanel1.setBackground(Color.white);

        creator1Text = new JLabel("Pulkit Aggarwal (19XJ1A0554)");
        creator1Text.setForeground(Color.black);
        creator1Text.setFont(normalFont);

        // Creator2
        creatorPanel2 = new JPanel();
        creatorPanel2.setBounds(735, 675, 400, 50);
        creatorPanel2.setBackground(Color.white);

        creator2Text = new JLabel("Yuvraj Mishra (19XJ1A0576)");
        creator2Text.setForeground(Color.black);
        creator2Text.setFont(normalFont);

        controlPanel.add(controlText);
        playerOnePanel.add(playerOne);
        playerTwoPanel.add(playerTwo);
        playerOneButtonPanel.add(wButton);
        playerOneButtonPanel.add(sButton);
        playerTwoButtonPanel.add(pButton);
        playerTwoButtonPanel.add(lButton);
        instructionPanel.add(instructions);
        // instructionTextPanel1.add(instructionText1);
        instructionTextPanel2.add(instructionText2);
        instructionTextPanel3.add(instructionText3);
        instructionTextPanel4.add(instructionText4);
        creatorPanel.add(creatorText);
        creatorPanel1.add(creator1Text);
        creatorPanel2.add(creator2Text);
        c.add(controlPanel);
        c.add(playerOnePanel);
        c.add(playerTwoPanel);
        c.add(playerOneButtonPanel);
        c.add(playerTwoButtonPanel);
        c.add(instructionPanel);
        // c.add(instructionTextPanel1);
        c.add(instructionTextPanel2);
        c.add(instructionTextPanel3);
        c.add(instructionTextPanel4);
        c.add(creatorPanel);
        c.add(creatorPanel1);
        c.add(creatorPanel2);
    }
}