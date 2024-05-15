package panels.GamePanel.GameManagement.Factorys;

import panels.GamePanel.GameManagement.GameMap;
import panels.GamePanel.levels.Level;
import panels.GamePanel.levels.Level1;
import panels.GamePanel.levels.Level2;
import panels.GamePanel.levels.Level3;

public class FactoryL {
    public static Level createLevel(GameMap map,int levelNum ){
        Level level = null;
        if (levelNum == 1){
            level = new Level1(map);
        }
        else if (levelNum == 2){
            level = new Level2(map);
        } else if (levelNum == 3) {
            level = new Level3(map);
        } else{
            System.out.println("You can not create level Number "+ levelNum);
        }
        return level;

    }
}
