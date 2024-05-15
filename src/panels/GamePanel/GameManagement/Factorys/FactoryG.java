package panels.GamePanel.GameManagement.Factorys;

import panels.GamePanel.entity.ghosts.*;
import panels.GamePanel.entity.ghosts.AIGhosts.*;

public class FactoryG {
    public static Ghosts create(String ghostTypeIA){
        Ghosts ghost = null;
        if (ghostTypeIA.equals("GhostRed")){
            ghost = new GhostRed();
        }
        else if (ghostTypeIA.equals("GhostPink")){
            ghost = new GhostPink();
        }else if (ghostTypeIA.equals("GhostO")){
            ghost = new GhostO();
        }else if (ghostTypeIA.equals("GhostC")){
            ghost = new GhostC();
        }
        else{
            System.out.println("You can not create "+ ghostTypeIA);
        }
        return ghost;
    }
    public static AI createAI(String ghostTypeIA){
        AI ai = null;
        if (ghostTypeIA.equals("AICanEaten")){
            ai = new AICanEaten();
        }
        else if (ghostTypeIA.equals("AIOverPlace")){
            ai = new AIOverPlace();
        }else if (ghostTypeIA.equals("AIRandom")){
            ai = new AIRandom();
        }else if (ghostTypeIA.equals("AIRed")){
            ai = new AIRed();
        }else if (ghostTypeIA.equals("AIUpdating")){
            ai = new AIUpdating();
        }
        else{
            System.out.println("You can not create "+ ghostTypeIA);
        }
        return ai;
    }

}
