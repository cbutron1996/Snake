import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by christianbutron on 3/24/17.
 */
public class Block extends GameObject {

    public Block(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void update() {
        if(x < 0) {
            x = GUI.WIDTH;
            rect.x = GUI.WIDTH;
        }
        else if(x >= GUI.WIDTH) {
            x = 0;
            rect.x = 0;
        }
        else if(y < 0) {
            y = GUI.HEIGHT;
            rect.y = GUI.HEIGHT;
        }
        else if(y >= GUI.HEIGHT) {
            y = 0;
            rect.y = 0;
        }
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, 19, 19);
    }
}
