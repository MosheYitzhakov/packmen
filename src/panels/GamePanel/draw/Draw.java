package panels.GamePanel.draw;

import panels.GamePanel.GameManagement.GameMap;
import panels.GamePanel.GameManagement.GamePanel;
import panels.GamePanel.entity.Entity;
import panels.GamePanel.fruits.Fruit;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static panels.GamePanel.GameManagement.GamePanel.tileSize;

public class Draw {
    public List<Entity> entityList = new ArrayList<>();
    public Fruit  fruit;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    BufferedImage image[] = new BufferedImage[9];
    public Draw(){
        try {
            image[0] =  ImageIO.read(getClass().getResourceAsStream("/point/smallPoint.png"));
            image[1] =  ImageIO.read(getClass().getResourceAsStream("/wall/wall.png"));
            image[2] =  ImageIO.read(getClass().getResourceAsStream("/point/bigPoint.png"));
            image[3] =  ImageIO.read(getClass().getResourceAsStream("/wall/wallPink.png"));
            image[8] =  ImageIO.read(getClass().getResourceAsStream("/pacman/pacman.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void drawMap(Graphics2D g2, int[][] map, int tileSize){
        int x =0;
        int y =tileSize*2;

        for (int mapCol[]:map) {
            for (int mapTile:mapCol) {
                if(mapTile ==0){
                    g2.drawImage(image[0],x,y,tileSize,tileSize,null);
//                    count++;
                }
                else if (mapTile ==1){
                    g2.drawImage(image[1],x,y,tileSize,tileSize,null);
                } else if (mapTile ==2){
                    g2.drawImage(image[2],x,y,tileSize,tileSize,null);
//                    count++;
                } else if (mapTile ==5) {
                    if(fruit !=null)
                        g2.drawImage(fruit.getImage(),x,y,tileSize,tileSize,null);
                } else if (mapTile ==3) {
                    g2.drawImage(image[3],x,y,tileSize,tileSize,null);
                }
                x+= tileSize;
            }
            x= 0;
            y +=tileSize;
        }
//        System.out.println(count);
    }
    public void drawEntity(Graphics2D g2){
        for (Entity entity :entityList) {

            BufferedImage image = null;
            switch (entity.direction){
                case "up":
                    if(spriteNum==1)
                        image = entity.up1;
                    if(spriteNum==2)
                        image = entity.up2;
                    break;
                case "down":
                    if(spriteNum==1)
                        image = entity.down1;
                    if(spriteNum==2)
                        image = entity.down2;
                    break;
                case "left":
                    if(spriteNum==1)
                        image = entity.left1;
                    if(spriteNum==2)
                        image = entity.left2;
                    break;
                case "right":
                    if(spriteNum==1)
                        image = entity.right1;
                    if(spriteNum==2)
                        image = entity.right2;
                    break;
            }

            animationDraw();
            g2.drawImage(image,entity.x,entity.y+(2* GameMap.tileSize),GameMap.tileSize, GameMap.tileSize, null);
        }

    }
    public void animationDraw() {
        spriteCounter++;
        if (spriteCounter > 40) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    public void drawLives(Graphics2D g2, int lives){
        recuLives(g2,lives, 5);
    }
    public void recuLives(Graphics2D g2,int lives, int numLi){
        Image imageLive = image[8];
        if (lives <=0){
        } else {
            g2.drawImage(imageLive,(GamePanel.maxScreenCol- numLi)*tileSize,tileSize*33,tileSize,tileSize,null);
            recuLives(g2,lives-1,numLi-1);
        }

    }
    public void drawCompletedLevel(Graphics2D g2, int level){
        g2.setFont(new Font("Arial", Font.PLAIN, 45));
        g2.setColor(Color.blue);
        if(level ==4){
            g2.drawString( "You have completed the game" ,tileSize,tileSize*15);
            forNewGame(g2);
        }else {
        g2.drawString( "You have completed the stage" ,tileSize,tileSize*15);
        }

    }
    public void drawGameOver(Graphics2D g2){
        g2.setFont(new Font("Arial", Font.PLAIN, 45));
        g2.setColor(Color.red);
        g2.drawString( "game over" ,tileSize*10,tileSize*15);
        forNewGame(g2);
    }
    public void forNewGame(Graphics2D g2){
        g2.setColor(Color.green);
        g2.drawString( "Press 'Enter' for a new game" ,tileSize*2,tileSize*17);

    }
}
