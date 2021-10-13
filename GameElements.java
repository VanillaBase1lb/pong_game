package pong_game;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;


class Ball {
    int x;
    int y;
    float speedX;
    float speedY;
    Color color;
    int radius;
    public static boolean ball_moving = true;
    
    public Ball(int radius, Color color) {
        this.radius = radius;
        this.color = color;
        this.setBall();
    }
    
    public void paint(Graphics g) {
        g.setColor(this.color);
        g.fillOval(this.x, this.y, this.radius * 2, this.radius * 2);
    }
    
    public void setBall() {
        this.x = Table.width / 2 - this.radius;
        this.y = Table.height / 2 - this.radius;
        ball_moving = false;
        
        Random random = new Random();
        int direction;
        direction = random.nextInt(2);
        switch (direction) {
            case 0:
                speedX = -1;
                break;               
            case 1:
                speedX = 1;
                break;
        }
        direction = random.nextInt(2);
        switch (direction) {
            case 0:
                speedY = random.nextInt(3);
                break;          
            case 1:
                speedY = random.nextInt(3) - 2;
                break;
        }
    }
}

class Bat {
    int id;
    int x;
    int y;
    float speedY;
    Color color;
    int thickness;
    int length;
    
    public Bat(Color color, int thickness, int length, int id) {
        this.color = color;
        this.thickness = thickness;
        this.length = length;
        this.id = id;
        this.setBat();
    }
    
    public void setBat() {
        if (this.id == 2)
            this.x = Table.width - this.thickness;
        else
            this.x = 0;
        this.y = Table.height / 2 - this.length / 2;
        this.speedY = Settings.bat_sensitivity;
    }
    
    public void paint(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.thickness, this.length);
    }
}

class Player {
    int id;
    int score;
    
    Player(int id) {
        this.id = id;
        this.score = 0;
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(Table.width / 2 - 6, 0, 2, 50);
        g.setFont(new Font("Consolas", Font.PLAIN, 50));
        if (this.id == 1)
            g.drawString(Integer.toString(this.score), Table.width / 2 - 70, 40);
        else
            g.drawString(Integer.toString(this.score), Table.width / 2 + 35, 40);
    }
}

class Table extends JPanel{
    Color color;
    public static int height = 864;
    public static int width = 1536;
    
    Table(Color color) {
        this.color = color;
    }
    
    public void paint(Graphics g) {
        g.setColor(this.color);
        g.fillRect(0, 0, Table.width, Table.height);
    }
}