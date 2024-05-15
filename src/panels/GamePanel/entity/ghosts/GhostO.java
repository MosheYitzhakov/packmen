package panels.GamePanel.entity.ghosts;

import panels.GamePanel.GameManagement.Factorys.FactoryG;
import panels.GamePanel.GameManagement.GameMap;
import panels.GamePanel.entity.ghosts.AIGhosts.AIUpdating;
import panels.GamePanel.entity.ghosts.Ghosts;
import panels.GamePanel.entity.ghosts.stateGhosts.NormalState;

import javax.imageio.ImageIO;
import java.io.IOException;

public class GhostO extends Ghosts {
    public GhostO() {
        canGoOut =false;
        updateDefault();
    }

    @Override
    public void updateDefault() {
        x= 13* GameMap.tileSize;
        y= 14* GameMap.tileSize;
        speed =2;
        direction = "right";
        setState(new NormalState(this));
        time =0;
    }

    public void updateDefaultImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostO/ghostO.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostO/ghostO.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostO/ghostO.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostO/ghostO.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostO/ghostO.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostO/ghostO.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostO/ghostO.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostO/ghostO.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void updateDefaultIA() {
        setAi(FactoryG.createAI("AIUpdating"));
    }
}
