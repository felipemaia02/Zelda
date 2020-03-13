package com.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.main.Game;

public class Player extends Entity {

    public boolean right, up, left, down;
    public int right_dir = 1, up_dir = 2, left_dir = 3,down_dir = 0;
    public int dir = down_dir;
    public double speed = 1.4;

    private int frames = 0, maxFrames = 12, index = 0, maxIndex = 1;
    private boolean moved = false;
    private BufferedImage[] rightPlayer;
    private BufferedImage[] leftPlayer;
    private BufferedImage[] downPlayer;
    private BufferedImage[] upPlayer;

    public Player(int x, int y, int width, int height, BufferedImage sprite) {
        super(x, y, width, height, sprite);

        rightPlayer = new BufferedImage[2];
        leftPlayer = new BufferedImage[2];
        downPlayer = new BufferedImage[2];
        upPlayer = new BufferedImage[2];

        for(int i = 0; i < 2; i++){
            rightPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 16, 16, 16);      
        }

        for(int i = 0; i < 2; i++){
            leftPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 32, 16, 16);   
        }

        for(int i = 0; i < 2; i++){
            downPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 0, 16, 16);   
        }

        for(int i = 0; i < 2; i++){
            upPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 48, 16, 16);   
        }
    }

    public void tick(){
        moved = false;
        if(right){
            moved = true;
            dir = right_dir;
            x += speed;
        }

        else if(left){
            moved = true;
            dir = left_dir;
            x -= speed;
        }

        else if(down){
            moved = true;
            dir = down_dir;
            y += speed;
        }

        else if(up){
            moved = true;
            dir = up_dir;
            y -= speed;
        }

        if (moved){
            frames++;
            if(frames == maxFrames){
                frames = 0;
                index++;
                if(index > maxIndex){
                    index = 0;
                }
            }
        }
    }

    public void render(Graphics g){
        if(dir == down_dir){
            g.drawImage(downPlayer[index], this.getX(), this.getY(), null);
        }
        else if(dir == up_dir){
            g.drawImage(upPlayer[index], this.getX(), this.getY(), null);
        }
        else if(dir == right_dir){
            g.drawImage(rightPlayer[index], this.getX(), this.getY(), null);
        }
        else if(dir == left_dir){
            g.drawImage(leftPlayer[index], this.getX(), this.getY(), null);
        }
        else{
            
        }
        
    }
}