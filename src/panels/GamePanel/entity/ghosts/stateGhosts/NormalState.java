package panels.GamePanel.entity.ghosts.stateGhosts;

import panels.GamePanel.entity.ghosts.Ghosts;


public class NormalState implements StateGhosts{
    public NormalState(Ghosts ghost) {
            stateWalk(ghost,false);
            stateColor(ghost);
            stateAI(ghost);
    }

    @Override
    public void stateWalk(Ghosts ghost, boolean slowWalk) {
        if(ghost.speed+2<3){
        ghost.speed+=2;
        } else {
            ghost.speed =2;
        }

        if(slowWalk){
            if(ghost.speed-2>=1){
            ghost.speed-=2;
            } else {
                ghost.speed=1;
            }
        }

        if(ghost.y%2 !=0){
            ghost.y-=1;
        }
            if(ghost.x%2 !=0){
                ghost.x-=1;
            }



    }

    @Override
    public void stateColor(Ghosts ghost) {
ghost.updateDefaultImage();
    }

    @Override
    public void stateAI(Ghosts ghost) {
ghost.updateDefaultIA();
    }
}
