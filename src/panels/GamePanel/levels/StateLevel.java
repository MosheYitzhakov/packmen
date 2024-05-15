package panels.GamePanel.levels;

import panels.GamePanel.GameManagement.Factorys.FactoryL;
import panels.GamePanel.GameManagement.GameMap;

import java.util.ArrayList;
import java.util.List;

public class StateLevel {
    private List <Level> thisLevel =new ArrayList<>();
    private GameMap map;

    public StateLevel(GameMap gm){
        map = gm;
        thisLevel.add(FactoryL.createLevel(gm,1));
    }

    public void setThisLevel(int level) {
        if(level == 1)
            thisLevel.clear();

        this.thisLevel.add(FactoryL.createLevel(map,level)) ;
    }
}
