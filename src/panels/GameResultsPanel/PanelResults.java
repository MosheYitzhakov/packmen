package panels.GameResultsPanel;

import panels.GameResultsPanel.InternalStorageManagement.ResultsManagement;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelResults extends JPanel{
    final static int originalTileSize =16;
    final static int scale =8;
    public static final int tileSize = originalTileSize+scale;
    public final static int maxScreenCol = 14;
    final static int maxScreenRow = 7;
    public final static int screenWidth = tileSize * maxScreenCol;
    public final static int screenHeight = tileSize * maxScreenRow;
ResultsManagement resultsManagement =new ResultsManagement();
    public PanelResults() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.CYAN);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }




    @Override
    protected void paintComponent(Graphics g2) {
        super.paintComponent(g2);

       List<Long> results = resultsManagement.getLoadScores();


        g2.setFont(new Font("Arial", Font.PLAIN, 34));
        g2.setColor(Color.blue);
        g2.drawString("Scores",screenWidth-(tileSize*9)-4,tileSize*5-3);
        g2.setFont(new Font("Arial", Font.PLAIN, 24));
        ricResults(g2,results);

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