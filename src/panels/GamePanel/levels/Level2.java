package panels.GamePanel.levels;

import panels.GamePanel.GameManagement.GameMap;
import panels.GamePanel.entity.ghosts.AIGhosts.AIUpdating;
import panels.GamePanel.entity.ghosts.Ghosts;

public class Level2 implements Level{

    public Level2(GameMap map){
        updateByLevel(map);
    }

    @Override
    public void updateByLevel(GameMap map) {
        for (Ghosts ghost: map.ghosts) {
            if(ghost.getAi() instanceof AIUpdating)
                ((AIUpdating)ghost.getAi()).setWhenToUpdate(5);
        }
        System.out.println("level 2");
    }
}