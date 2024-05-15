package panels.GamePanel.GameManagement;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private String direction = "down";
    public String stop= " ";
    public String getDirection() {
        return direction;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            direction ="up";
        }

        if (code == KeyEvent.VK_DOWN) {
            direction ="down";
        }
        if (code == KeyEvent.VK_LEFT) {
            direction ="left";
        } else if (code == KeyEvent.VK_RIGHT) {
            direction ="right";
        } else if (code == KeyEvent.VK_ENTER) {
            stop = "new";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
stop = " ";

    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
}
