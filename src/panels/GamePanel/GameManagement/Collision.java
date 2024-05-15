package panels.GamePanel.GameManagement;

import panels.GamePanel.entity.Entity;
import panels.GamePanel.entity.Pacman;
import panels.GamePanel.entity.ghosts.Ghosts;

import java.util.ArrayList;
import java.util.List;

public class Collision {
    Pacman pacman;
    int[][] map;
    List<Ghosts> ghosts = new ArrayList<>();
    public boolean colToGhosts(){
        for (Ghosts ghost:ghosts) {
            if (Math.abs(pacman.y-ghost.y) <   GameMap.tileSize-4 && Math.abs(pacman.x-ghost.x)< GameMap.tileSize-4) {
                if(ghost.canEaten){
                    ghost.updateDefault();
                    ghost.canEaten =false;
                }else {
                    pacman.isEaten = true;
                    System.out.println("game over");
                }

            }
        }
        return true;
    }
    public boolean XInMap(int x){
      return   x>0 && (x+GamePanel.tileSize)<GamePanel.screenWidth;
    }
    public int changeNumToTile(int num){
        return num/GameMap.tileSize;
    }
    public boolean isNumNotEverTile(int num){
        return  num% GameMap.tileSize==0;
    }
    public boolean isMiddleTile(int x, int y){
        return isNumNotEverTile(x) && isNumNotEverTile(y);
    }
    public boolean NotStuckInWall(Entity entity, String key){
        if(isNumNotEverTile( key== "up" || key== "down" ? entity.x : entity.y)){
            if(isNumNotEverTile(key!= "up" && key!= "down" ? entity.x : entity.y)) {
                boolean NewSpeedX = (key== "up" || key== "down")? false: true;
                int x = entity.x/GameMap.tileSize;
                int y = entity.y/GameMap.tileSize;
                if(NewSpeedX){
                    x = changeNumToTile(nextTile(entity.x, key));
                } else {
                    y = changeNumToTile(nextTile(entity.y, key));
                }
                return map[y][x] != 1 && map[y][x] != 3;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public int nextTile(int place, String direction){
        if(direction == "up"|| direction == "left"){
            return   place-GameMap.tileSize;
        } else {
            return   place+GameMap.tileSize;
        }
    }



}
