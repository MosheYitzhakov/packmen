package panels.GamePanel.entity.ghosts;

import panels.GamePanel.GameManagement.Collision;
import panels.GamePanel.entity.Entity;
import panels.GamePanel.entity.ghosts.AIGhosts.AI;
import panels.GamePanel.entity.ghosts.stateGhosts.NormalState;
import panels.GamePanel.entity.ghosts.stateGhosts.StateGhosts;

import javax.imageio.ImageIO;
import java.io.IOException;

abstract public class Ghosts extends Entity implements DefaultAI{
    private AI ai;
    public int time =0;
    public boolean canGoOut = true;
    private StateGhosts state= new NormalState(this);

    public boolean canEaten =false;
    public void setState(StateGhosts state) {
        this.state = state;
    }

    public StateGhosts getState() {
        return state;
    }

public String  getGo(int[][] tam, int x, int y, int px, int py){
        if(canGoOut ==false)
          return   y==14?"up":"down";
        if(ai == null){
            System.out.println("AI in Ghosts is null");
            return "";
        }
       return ai.Direction(tam, x, y,  px, py);
}
    public void setAi(AI ai) {
        this.ai = ai;
    }

    public AI getAi() {
        return ai;
    }
}
