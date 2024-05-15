package panels.GamePanel.entity.ghosts;

import panels.GamePanel.GameManagement.Factorys.FactoryG;
import panels.GamePanel.GameManagement.GameMap;
import panels.GamePanel.entity.ghosts.AIGhosts.AIRandom;
import panels.GamePanel.entity.ghosts.stateGhosts.NormalState;

import javax.imageio.ImageIO;
import java.io.IOException;

public class GhostPink extends Ghosts {
    public GhostPink() {
        updateDefault();
    }

    @Override
    public void updateDefault() {
        x= 12* GameMap.tileSize;
        y= 14* GameMap.tileSize;
        speed =2;
        direction = "right";
        setState(new NormalState(this));
        time =0;
    }

    public void updateDefaultImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostP/ghostP.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostP/ghostP.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostP/ghostP.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostP/ghostP.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostP/ghostP.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostP/ghostP.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostP/ghostP.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostP/ghostP.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void updateDefaultIA() {
        setAi(FactoryG.createAI("AIOverPlace"));
    }
}
