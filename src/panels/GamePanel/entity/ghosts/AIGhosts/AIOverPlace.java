package panels.GamePanel.entity.ghosts.AIGhosts;

public class AIOverPlace implements AI{

    public String Direction(int[][] tam,int x,int  y,int px,int py){
        int up,down,right,left,res;

        int[][] map = new int[tam.length][tam[0].length];

        for (int i = 0; i < tam.length; i++) {
            for (int j = 0; j <tam[i].length; j++) {
                map[i][j] = tam[i][j];
            }
        }
        String strRes ="";
        if((py+5) <(map.length-3)&&py-3>1){
            if(map[py-3][px] ==0){
                    py-=3;
            } else {
                if(map[py+3][px] ==0)
                py+=3;
            }

        }
        if(!(px+5>=map[0].length)&&px-3>0){
            if(map[py][px+3] ==0){
                px+=3;
            } else {
                if(map[py][px-3] ==0)
                    px-=3;
            }
        }



        up = Way(map,x,y-1,px,py, 0);
        down = Way(map,x,y+1,px,py, 0);
        right = Way(map,x+1,y,px,py, 0);
        left = Way(map,x-1,y,px,py, 0);

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
        return Between4(up,down,left,right);
    }
    public String getName() {
        return "AIOverPlace";
    }
}
