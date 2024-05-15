package panels.GamePanel.entity.ghosts.stateGhosts;

import panels.GamePanel.GameManagement.Factorys.FactoryG;
import panels.GamePanel.entity.ghosts.AIGhosts.AICanEaten;
import panels.GamePanel.entity.ghosts.Ghosts;

import javax.imageio.ImageIO;
import java.io.IOException;

public class StateCanEaten implements StateGhosts{
    public StateCanEaten(Ghosts ghost , boolean slowWalk){
        if(slowWalk){
            stateWalk(ghost,slowWalk);
        } else {
            stateWalk(ghost,slowWalk);
            stateColor(ghost);
            stateAI(ghost);
        }
    }


    @Override
    public void stateWalk(Ghosts ghost, boolean slowWalk) {
        if(ghost.speed>1)
        ghost.speed-=1;
    }

    @Override
    public void stateColor(Ghosts ghost) {
        try {
            ghost.up1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostCanEaten.png"));
            ghost.up2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostCanEaten.png"));
            ghost.down1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostCanEaten.png"));
            ghost.down2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostCanEaten.png"));
            ghost.left1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostCanEaten.png"));
            ghost.left2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostCanEaten.png"));
            ghost.right1 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostCanEaten.png"));
            ghost.right2 = ImageIO.read(getClass().getResourceAsStream("/ghosts/ghostCanEaten.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stateAI(Ghosts ghost) {
       ghost.setAi(FactoryG.createAI("AICanEaten"));
    }
}
