package panels.GamePanel.GameManagement;

import panels.GamePanel.draw.Draw;
import panels.GamePanel.entity.ghosts.Ghosts;
import panels.GamePanel.levels.StateLevel;
import panels.GameResultsPanel.InternalStorageManagement.ResultsManagement;
import panels.GameResultsPanel.PanelResults;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class GamePanel extends JPanel implements Runnable{
    final static int originalTileSize =16;
    final static int scale =8;
    public static final int tileSize = originalTileSize+scale;
    public final static int maxScreenCol = 28;
    final static int maxScreenRow = 34;
    public final static int screenWidth = tileSize * maxScreenCol;
    public final static int screenHeight = tileSize * maxScreenRow;
    int stop = 0;
    public int lives = 3;
    public int level =1;
    int maxLevel = 3;
    public UpdatePoints points = new UpdatePoints();
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    GameMap map = new GameMap(PacMap.crateMap1(),keyH,points);
    Draw draw = new Draw();
    StateLevel SLevel =new StateLevel(map);
    ResultsManagement resultsManagement =new ResultsManagement();
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

//        int count =0;
//        long time =0L;
        while (gameThread!=null){
//            count++;
            long startTime = System.currentTimeMillis();

            if(!(level>maxLevel)){
                update();
            }
            if(keyH.stop.equals("new")){
                newOver();
            }

            repaint();
            long listTime = System.currentTimeMillis();
            long timeSleeping = (1000/60) - (listTime-startTime);

            try {
                if(timeSleeping>=0)
                    Thread.sleep(timeSleeping);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//             listTime = System.currentTimeMillis();
//            time += (listTime - startTime);
//            if(time >= 1000){
//                System.out.println(count);
//                count =0;
//                time =0;
//            }


        }


    }

    public void update() {
        if(map.pacman.isEaten&&!(lives < 0)){
            stop++;
            if(stop ==100) {

                disqualification();
            }
        } else if (points.getNumPoints() == 0) {
            stop++;
            if(stop ==50) {
                advanceLevel();
                stop =0;
            }
        }
        if(stop ==0 && !(lives < 0)){

            map.updatePac();
            map.updateGhost();
            map.updateFruit();
        }

    }
    public void advanceLevel(){
        level++;
        if(level> maxLevel){
            resultsManagement.setScores(points.getValue());

        }else if(level<=maxLevel){
            lives++;
            map = new GameMap(PacMap.crateMap1(), keyH,points);
            points.setNumPointsDefault();
            SLevel.setThisLevel(level);
        }
    }
    public void newOver(){
        map = new GameMap(PacMap.crateMap1(), keyH,points);
        points.setNumPointsDefault();
        points.setValueDefault();
        lives =3;
        level =1;
        stop = 0;
    }
    public void disqualification(){
        map.pacman.updateDefault();
        for (Ghosts ghost: map.ghosts) {
            if(ghost!= null)
                ghost.updateDefault();
        }
        lives--;
        stop = 0;
        map.pacman.isEaten = false;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        map.draw(g2);
        draw.drawLives(g2, lives);

        if (points.getNumPoints() == 0) {
            draw.drawCompletedLevel(g2, level);
        } else if (lives < 0) {
            draw.drawGameOver(g2);
        }

        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.setColor(Color.WHITE);

        g.drawString("LIVES: ", screenWidth - (tileSize * 8) - 4, tileSize * 34 - 3);
        g.drawString("LEVEL " + level, 5 * tileSize, tileSize - 4);

        g.drawString("SCORE", 5, tileSize - 4);
        g.drawString("" + points.getValue(), (int) (tileSize * 1.5), tileSize * 2 - 4);

//}else {
//    List<Long> results = resultsManagement.getLoadScores();
//
//
//
//    g2.setFont(new Font("Arial", Font.PLAIN, 34));
//    g2.setColor(Color.blue);
//    g2.drawString("Scores", screenWidth - (tileSize * 9) - 4, tileSize * 5 - 3);
//    g2.setFont(new Font("Arial", Font.PLAIN, 24));
//    ricResults(g2, results);
//}
        g2.dispose();

    }
    public void ricResults(Graphics g2,List<Long> res){
        if(res.isEmpty())
            return;
        ric(g2,res,0,7,res.size()-1);

    }
    public void ric(Graphics g2,List<Long> res, int index,int sizeY,int stop){
        if(index == stop){
            return;
        } else {
            g2.drawString(" "+res.get(index),screenWidth-(tileSize*9),(tileSize*sizeY)-3);
            ric(g2,res,index+1,sizeY+1,stop);
        }

    }





}
