package pong_game;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;


public class Game extends JFrame implements Runnable {
    Ball ball;
    Table table;
    Graphics g;
    Bat bat1, bat2;
    Game game;
    Player p1, p2;
    Random random_ball = new Random();
    Image backgroundImage;
    
    Game() {
        ball = new Ball(16, Settings.ball_color);
        bat1 = new Bat(Color.red, Settings.bat_thickness, Settings.bat_length, 1);
        bat2 = new Bat(Color.yellow, Settings.bat_thickness, Settings.bat_length, 2);
        p1 = new Player(1);
        p2 = new Player(2);
    }
    
    // main method during development
    
    /*public static void main(String args[]) {
        Game game = new Game();
        game.setTable();
        
        Thread frame_refresher = new Thread(game);
        frame_refresher.start();
    }*/
    
    void gameLoop(int fps) {
        repaint();
        
        try {
            Thread.sleep(1000 / fps);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    void setTable() {
        table = new Table(Color.black);
        
        // super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setUndecorated(true);
        super.setAlwaysOnTop(true);
        super.setTitle("Pong Game");
        super.setBackground(table.color);
        super.setSize(Table.width, Table.height);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
        super.setResizable(false);
        super.addKeyListener(new Controls(bat1, bat2, this));
        super.add(table);
    }

    public void paint(Graphics g) {
        table.setVisible(false); // to create temporary buffer effect
        table.paint(g);
        bat1.paint(g);
        bat2.paint(g);
        p1.paint(g);
        p2.paint(g);
        ball.paint(g);
        table.setVisible(true); // to create temporary buffer effect 
        
        // to prevent flickering in linux
        // Toolkit.getDefaultToolkit().sync();       
    }
    
    public void run() {
        while (true) {
            gameLoop(120); // fps
            batPhysics();
            ballPhysics();
        }
    }
    
    public void batPhysics() {
        if (Controls.bat1up == true && bat1.y > 0)
            bat1.y -= bat1.speedY;
        if (Controls.bat1down == true && bat1.y < Table.height - bat1.length)
            bat1.y += bat1.speedY;
        if (Controls.bat2up == true && bat2.y > 0)
            bat2.y -= bat2.speedY;
        if (Controls.bat2down == true && bat2.y < Table.height - bat2.length)
            bat2.y += bat2.speedY;
    }
    
    public void ballPhysics() {
        if (Ball.ball_moving == true) {
            ball.x += ball.speedX;
            ball.y += ball.speedY;
        }

        // ball out of bounds
        if (ball.x + ball.radius * 2 < 0 || ball.x > Table.width) {
            // score
            if (ball.x > Table.width) {
                p1.score++;
            } else {
                p2.score++;
            }

            // reset the table
            ball.setBall();
            bat1.setBat();
            bat2.setBat();
            repaint();

            matchEnd();
        }

        // ball table collision
        if (ball.y < 0 || ball.y + ball.radius * 2 > Table.height) {
            ball.speedY = 0 - ball.speedY;
        }

        // ball bat collision
        if (ball.x < bat1.thickness || ball.x + ball.radius * 2 > Table.width - bat2.thickness) {
            if ((ball.y <= bat1.y + bat1.length && ball.y + ball.radius * 2 >= bat1.y && ball.speedX <= 0)
                    || (ball.y <= bat2.y + bat2.length && ball.y + ball.radius * 2 >= bat2.y && ball.speedX > 0)) {

                if (Settings.special_ball_physics == true)
                    ball.speedY = random_ball.nextInt(13) - 6;
                else if (ball.speedY == 0) { // if ball randomization is off and ball comes straight
                    ball.speedY = random_ball.nextInt(13) - 6;
                }
                
                // ball speed increases after each hit
                if (Math.abs(ball.speedX) < bat1.thickness) {
                    if (ball.speedX <= 0) {
                        ball.speedX = 0 - ball.speedX + 1;
                    } else {
                        ball.speedX = 0 - ball.speedX - 1;
                    }
                } else { // when speed maxes out
                    ball.speedX = 0 - ball.speedX;
                }
            }
        }
    }
    
    public void matchEnd() {
        String player_won = "Nobody";
        int max_score = 5;
        if (p1.score >= max_score) {
            player_won = "Player 1";
        }
        else if (p2.score >= max_score) {
            player_won = "Player 2";
        }
        
        if (p1.score >= max_score || p2.score >= max_score) {
            JFrame endGame = new JFrame();
            endGame.setAlwaysOnTop(true);
            endGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(endGame, "Congratulations, " + player_won + " won with " + max_score + " points!", "Game Over !", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

class Controls extends KeyAdapter {
    public static boolean bat1up = false;
    public static boolean bat1down = false;
    public static boolean bat2up = false;
    public static boolean bat2down = false;

    Bat bat1, bat2;
    Game game;
    public Controls(Bat bat1, Bat bat2, Game game) {
        this.bat1 = bat1;
        this.bat2 = bat2;
        this.game = game;
    }
    
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                bat1up = true;
                break;
            case 's':
                bat1down = true;
                break;
            case 'p':
                bat2up = true;
                break;
            case 'l':
                bat2down = true;
                break;
            case 'b':
                Ball.ball_moving = true;
                break;
            case KeyEvent.VK_ESCAPE:
                game.dispose();
                System.exit(0);
                break;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                bat1up = false;
                break;
            case 's':
                bat1down = false;
                break;
            case 'p':
                bat2up = false;
                break;
            case 'l':
                bat2down = false;
                break;
        }
    }
}
