package panels.GamePanel.GameManagement;

import panels.GamePanel.GameManagement.Factorys.FactoryG;
import panels.GamePanel.draw.Draw;

import panels.GamePanel.entity.Pacman;
import panels.GamePanel.fruits.Fruits;
import panels.GamePanel.entity.ghosts.GhostC;
import panels.GamePanel.entity.ghosts.GhostO;
import panels.GamePanel.entity.ghosts.Ghosts;
import panels.GamePanel.entity.ghosts.stateGhosts.NormalState;
import panels.GamePanel.entity.ghosts.stateGhosts.StateCanEaten;
import panels.GamePanel.levels.StateLevel;


import java.awt.*;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private static int[][] map;
    public static final int tileSize = GamePanel.tileSize;
    public UpdatePoints points;
    public List<Ghosts> ghosts= new ArrayList<>();
    Pacman pacman= new Pacman();
    Fruits fruits = new Fruits();
    KeyHandler keyH;
    Collision collision= new Collision();
    Draw draw;

    public GameMap(int[][] map,KeyHandler keyH, UpdatePoints points){
        this.points = points;
        this.map =map;
        this.keyH =keyH;
        firstUpdate();
    }
    public void firstUpdate(){
        draw = new Draw();
        ghosts.add(FactoryG.create("GhostRed"));
        ghosts.add(FactoryG.create("GhostPink"));
        ghosts.add(FactoryG.create("GhostC"));
        ghosts.add(FactoryG.create("GhostO"));
        collision.pacman = pacman;
        collision.map = map;

        draw.entityList.add(pacman);

        for (Ghosts ghost:ghosts) {
            if(ghost !=null){
                draw.entityList.add(ghost);
                collision.ghosts.add(ghost);
            }
        }
    }

    public void updateMovePac(Pacman pacman){
        if (collision.isMiddleTile(pacman.x, pacman.y)) {
            updateMap(collision.changeNumToTile(pacman.y), collision.changeNumToTile(pacman.x));
            if (collision.NotStuckInWall(pacman, keyH.getDirection())) {
                pacman.updateDirection(keyH.getDirection());
            } else {
                if (collision.NotStuckInWall(pacman, pacman.direction)) {
                    pacman.updateDirection(pacman.direction);
                }
            }
        } else {
            pacman.updateDirection(pacman.direction);
        }
    }
    public void updatePac(){
        if(collision.XInMap(pacman.x)) {
            updateMovePac(pacman);
        }else {
            pacman.updateDirection(keyH.getDirection().equals("right")||keyH.getDirection().equals("left")? keyH.getDirection():pacman.direction);
        }
        collision.colToGhosts();
    }

    public void updateGhost(){
        for (Ghosts ghost:ghosts) {
            if (ghost != null) {
                updateMoveGhost(ghost);

                if (collision.isMiddleTile(ghost.x, ghost.y)) {
                    if (map[collision.changeNumToTile(ghost.y)][collision.changeNumToTile(ghost.x)] == 11) {
                        if (ghost.speed > 1)
                            ghost.getState().stateWalk(ghost, true);
                    } else if (map[collision.changeNumToTile(ghost.y)][collision.changeNumToTile(ghost.x)] == 40) {
                        ghost.getState().stateWalk(ghost, false);
                    }
                }
                if(ghost.canEaten){
                    timeToGhostsCanEaten(ghost);
                }
            }
        }
    }
    public void updateMoveGhost(Ghosts ghost){
        if (collision.isMiddleTile(ghost.x, ghost.y)) {
            ghost.updateDirection(ghost.getGo(map, collision.changeNumToTile(ghost.x), collision.changeNumToTile(ghost.y), collision.changeNumToTile(pacman.x), collision.changeNumToTile(pacman.y)));
        } else {
            ghost.updateDirection(ghost.direction);
        }
    }
    public void timeToGhostsCanEaten(Ghosts ghost){
        if (ghost != null) {
            if (ghost.time < 200) {
                ghost.time++;
            } else {
                ghost.setState(new NormalState(ghost));
                updateMoveGhost(ghost);
                ghost.canEaten = false;
                ghost.time = 0;
            }
        }
    }
    public void updateMap(int y, int x){
        if(map[y][x] == 0 || map[y][x] == 2 ||map[y][x] == 5){
            updatePoint(map[y][x]);
            if(map[y][x] == 2){
                canEatGhosts();
            }
            map[y][x] = 4;
        }

    }

    public void updateFruit(){
        fruits.setMoreTime(1);
        if(fruits.getTime() == 100){
            fruits.setPlaceFruit(collision.changeNumToTile(pacman.x),collision.changeNumToTile(pacman.y));
        } else if (fruits.getTime() == 200) {
            draw.fruit = fruits.getFruit();
            map[fruits.getPlaceY()][fruits.getPlaceX()] = 5;
        } else if (fruits.getTime() == 400) {
            map[fruits.getPlaceY()][fruits.getPlaceX()] = 4;
            fruits.resetTime();
        }
    }


    public void updatePoint(int numInMap){
        if(numInMap == 0){
            points.setValue(10);
            points.setNumPoints();
        }else if (numInMap ==2){
            points.setValue(50);
            points.setNumPoints();
        } else if (numInMap ==5) {
            points.setValue(draw.fruit.getValue());
        }

        if(points.getNumPoints()==170){
            for (Ghosts ghost: ghosts) {
                if(ghost instanceof GhostO)
                    ghost.canGoOut =true;
            }
        } else if (points.getNumPoints() == 100) {
            for (Ghosts ghost:ghosts) {
                if(ghost instanceof GhostC)
                    ghost.canGoOut =true;
            }
        }
    }
    public void canEatGhosts(){
        for (Ghosts ghost:
                ghosts) {
            if(ghost !=null){
                ghost.setState(new StateCanEaten(ghost,false));
                ghost.canEaten = true;
            }
        }
    }
    public void draw(Graphics2D g2){
        draw.drawMap( g2, map, tileSize);
        draw.drawEntity(g2);
    }

}
