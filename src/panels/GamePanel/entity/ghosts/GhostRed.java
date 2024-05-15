package panels.GamePanel.entity.ghosts;

import panels.GamePanel.GameManagement.Factorys.FactoryG;
import panels.GamePanel.GameManagement.GameMap;
import panels.GamePanel.entity.ghosts.stateGhosts.NormalState;

import javax.imageio.ImageIO;
import java.io.IOException;

public class GhostRed extends Ghosts{



    public GhostRed() {
        updateDefault();
    }

    public void updateDefault(){
        setState(new NormalState(this));
        x= 11* GameMap.tileSize;
        y= 11* GameMap.tileSize;
        speed =2;
        direction = "right";
        time =0;
    }
    public void updateDefaultImage(){
        try {
         up1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostR/ghostR.png"));
          up2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostR/ghostR.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostR/ghostR.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostR/ghostR.png"));
           left1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostR/ghostR.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostR/ghostR.png"));
          right1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostR/ghostR.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostR/ghostR.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateDefaultIA() {
        setAi(FactoryG.createAI("AIRed"));
    }
}
