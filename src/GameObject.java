/**
 * Created by christianbutron on 3/24/17.
 */
import java.awt.*;

public abstract class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    protected Rectangle rect;

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.rect = new Rectangle(x, y, width, height);
    }

    public abstract void update();
    public abstract void draw(Graphics g);
}
