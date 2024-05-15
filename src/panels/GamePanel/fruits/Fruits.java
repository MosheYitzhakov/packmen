package panels.GamePanel.fruits;

import panels.GamePanel.GameManagement.Factorys.FactoryF;

import java.util.Random;

public class Fruits {
    Random ran = new Random();
   private int count;
   private int time = 0;
    Fruit[]  fruitsArr;
  private int placeX;
   private int placeY;

    public Fruits(){
        fruitsArr =new Fruit[5];

        fruitsArr[0] = FactoryF.createFruit("Apple");
        fruitsArr[1] = FactoryF.createFruit("Cherry");
        fruitsArr[2] = FactoryF.createFruit("Hotel");
        fruitsArr[3] = FactoryF.createFruit("Orange");
        fruitsArr[4] = FactoryF.createFruit("Strawberry");

    }

    public Fruit getFruit(){
        Fruit fruit =null;
        if(fruitsArr==null)
            return null;
        count = fruitsArr.length;
        while (fruit == null){
            int index = ran.nextInt(0, count);
            fruit= fruitsArr[index];
        }
        return fruit;
    }

    public int getPlaceX() {
        return placeX;
    }

    public int getPlaceY() {
        return placeY;
    }

    public void setPlaceX(int placeX) {
        this.placeX = placeX;
    }

    public void setPlaceY(int placeY) {
        this.placeY = placeY;
    }

    public void setPlaceFruit(int x, int y){
        setPlaceX(x);
        setPlaceY(y);
    }

    public void setMoreTime(int time) {
        this.time += time;
    }

    public void resetTime() {
        this.time =0;
    }

    public int getTime() {
        return time;
    }
}
