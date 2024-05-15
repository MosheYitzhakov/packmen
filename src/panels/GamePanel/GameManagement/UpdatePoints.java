package panels.GamePanel.GameManagement;

public class UpdatePoints {
    private int numPoints;
    private long value = 0;
public UpdatePoints(){
    setNumPointsDefault();
}
    public int getNumPoints() {
        return numPoints;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value += value;
    }

    public void setNumPoints() {
        this.numPoints -= 1;
    }
    public void setNumPointsDefault(){
        this.numPoints = 245;
    }
    public void setValueDefault(){
        this.value = 0;
    }
}
