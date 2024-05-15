package panels.GamePanel.entity;

import panels.GamePanel.GameManagement.GamePanel;

import java.awt.image.BufferedImage;

abstract public class Entity implements Move{
    public int x;
    public int y;
    public double speed;
    public BufferedImage up1, up2, down1,down2, left1, left2, right1, right2;
    public String direction;
    public boolean isOfBridge =false;
    @Override
    public void updateDirection(String direction) {
        if(direction == "up"){
            this.direction = "up";
            y -=speed;
        } else if (direction == "down") {
            this.direction = "down";
            y +=speed;

        }else if (direction == "left") {
            this.direction = "left";
            x-=speed;
            if(x<-5){
                x = GamePanel.screenWidth;
            }

        }else if (direction == "right") {
            this.direction = "right";
            x +=speed;
            if(x> GamePanel.screenWidth+5){
                x = 0;
            }
        }
    }
}
