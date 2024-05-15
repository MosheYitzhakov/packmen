package panels.GamePanel.fruits;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

abstract public class Fruit {
   private int name;
    private int value;
    private String nameImage;
    private Image image;
    public Fruit(int name,int value,String nameImage){
        setName(name);
        setValue(value);
setNameImage(nameImage);
        try {
            image = ImageIO.read(getClass().getResourceAsStream(getNameImage()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name=" + name +
                ", value=" + value +
                ", image=" + image +
                '}';
    }
}
