import java.awt.*;

/**
 * Created by christianbutron on 3/24/17.
 */
public class Block extends GameObject {

    public Block(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void update() {
        if(x < 0) {
            x = GUI.WIDTH - width;
            rect.x = GUI.WIDTH - width;
        }
        else if(x >= GUI.WIDTH) {
            x = 0;
            rect.x = 0;
        }
        else if(y < 0) {
            y = y + GUI.HEIGHT - height;
            rect.y = rect.y + GUI.HEIGHT - height;
        }
        else if(y >= GUI.HEIGHT) {
            y = y - GUI.HEIGHT;
            rect.y = rect.y - GUI.HEIGHT;
        }
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, 19, 19);
    }
}
