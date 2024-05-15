package panels.GamePanel.GameManagement.Factorys;

import panels.GamePanel.fruits.*;

public class FactoryF {

    public static Fruit createFruit(String FruitType){
        Fruit fruit = null;
        if (FruitType.equals("Apple")){
            fruit = new Apple();
        }
        else if (FruitType.equals("Cherry")){
            fruit = new Cherry();
        }
        else if (FruitType.equals("Hotel")){
            fruit = new Hotel();
        }
        else if (FruitType.equals("Orange")){
            fruit = new Orange();
        } else if (FruitType.equals("Strawberry")) {
            fruit = new Strawberry();
        }
        else{
            System.out.println("You can not create "+ FruitType);
        }
        return fruit;
    }


}
