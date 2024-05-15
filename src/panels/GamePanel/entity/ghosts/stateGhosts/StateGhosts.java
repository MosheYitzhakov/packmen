package panels.GamePanel.entity.ghosts.stateGhosts;

import panels.GamePanel.entity.ghosts.Ghosts;

public interface StateGhosts {

    void stateWalk(Ghosts ghost, boolean w);
    void stateColor(Ghosts ghost);
    void stateAI(Ghosts ghost);
}
