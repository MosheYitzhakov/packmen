package panels.GamePanel.entity.ghosts.AIGhosts;

public interface AI {
     String getName();
     String Direction(int[][] tam, int x, int y, int px, int py);
     int Between4(int num1, int num2, int num3, int num4);
     int Way(int[][] map,int x,int  y,int px,int py,int count);


}
