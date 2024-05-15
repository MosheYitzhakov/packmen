package panels.GamePanel.entity;

import panels.GamePanel.GameManagement.GameMap;

import javax.imageio.ImageIO;


public class Pacman extends Entity{
public boolean isEaten = false;
    public Pacman(){
        updateDefaultImage();
        updateDefault();
    }
    public void updateDefault(){
        x=13 * GameMap.tileSize;
        y=23 *  GameMap.tileSize;
        speed =3;
        direction = "up";
    }

    @Override
    public void updateDefaultImage() {
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/pacman/pacmanUp1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/pacman/pacmanUp2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/pacman/pacmanDown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/pacman/pacmanDown2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/pacman/pacmanLeft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/pacman/pacmanLeft2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/pacman/pacmanRight1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/pacman/pacmanRight2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
