package panels.GamePanel.entity.ghosts.AIGhosts;

public class AIUpdating implements AI{
    int firstX =0;
    int firstY =0;
  private int whenToUpdate =1;
    public boolean needUpdate(int num, int first){
        if(num+whenToUpdate>= first && num-whenToUpdate<= first)
            return true;
        return false;

    }
    public String Direction(int[][] tam,int x,int  y,int px,int py){
        int up,down,right,left,res;

        int[][] map = new int[tam.length][tam[0].length];

        for (int i = 0; i < tam.length; i++) {
            for (int j = 0; j <tam[i].length; j++) {
                map[i][j] = tam[i][j];
            }
        }
        String strRes ="";
        if(needUpdate(x,firstX)&&needUpdate(y,firstY) ||firstX ==0){
            firstX = px;
            firstY = py;
        }


        up = Way(map,x,y-1,firstX,firstY, 0);
        down = Way(map,x,y+1,firstX,firstY, 0);
        right = Way(map,x+1,y,firstX,firstY, 0);
        left = Way(map,x-1,y,firstX,firstY, 0);

        res = Between4(up,down,left,right);
//        System.out.println("up = " + up + ", right = " + right +", down = " + down +", left = " + left + ", res = " + res);



        if (res == up){
            strRes = "up";
        } else if (res == down) {
            strRes = "down";
        }else if (res == right) {
            strRes = "right";
        }else if (res == left) {
            strRes = "left";
        }

        return strRes;
    }
    public int Between4(int num1, int num2, int num3, int num4){
        int res1, res2;
        res1 = Math.min(num1,num2);
        res2 = Math.min(num3,num4);
        return Math.min(res1,res2);
    }
    public int Way(int[][] map,int x,int  y,int px,int py,int count){
        int up,down,right,left;
        if(y<0 || y> map.length-1){
            return 60;
        } else if(x<0 || x> map[y].length-1){
            return 60;
        }

        if(x==px&& y==py){
            return count+1;

        } else if (map[y][x]==1||map[y][x]==-1) {
            return 60;
        } else if (count >= 60){
            return count;
        } else{

            map[y][x] =-1;

            up = Way(map,x,y-1,px,py, count+1);
            down = Way(map,x,y+1,px,py, count+1);
            right = Way(map,x+1,y,px,py, count+1);
            left = Way(map,x-1,y,px,py, count+1);

            map [y][x] =0;
        }
        return Between4(down,right,up,left);
    }
    public String getName() {
        return "AIUpdating";
    }

    public void setWhenToUpdate(int whenToUpdate) {
        this.whenToUpdate = whenToUpdate;
    }
}
