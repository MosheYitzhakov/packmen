package panels.GamePanel.levels;

import panels.GamePanel.GameManagement.Factorys.FactoryG;
import panels.GamePanel.GameManagement.GameMap;
import panels.GamePanel.entity.ghosts.AIGhosts.AIRandom;
import panels.GamePanel.entity.ghosts.AIGhosts.AIUpdating;
import panels.GamePanel.entity.ghosts.Ghosts;

public class Level3 implements Level{
    public Level3(GameMap map){
        updateByLevel(map);
    }
    @Override
    public void updateByLevel(GameMap map) {
        for (Ghosts ghost: map.ghosts) {
            if(ghost.getAi() instanceof AIRandom){
                ghost.setAi(FactoryG.createAI("AIUpdating"));
                ((AIUpdating)ghost.getAi()).setWhenToUpdate(5);
            }
        }

        System.out.println("level 3");
    }
}