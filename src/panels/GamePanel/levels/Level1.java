package panels.GamePanel.levels;


import panels.GamePanel.GameManagement.GameMap;

public class Level1 implements Level{
public Level1(GameMap map){
    updateByLevel(map);
}
    @Override
    public void updateByLevel(GameMap map) {
        System.out.println("level 1");
    }
}
