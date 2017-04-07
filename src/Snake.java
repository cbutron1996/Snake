/**
 * Created by christianbutron on 3/24/17.
 */
import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Snake {

    public String move;
    public Block head;
    public List<Block> tails;

    public int tailLength;

    public Snake() {
        move = "Stop";
        tails = new CopyOnWriteArrayList<>();
        head = new Block(0, 0, 20, 20);
        tailLength = 0;
    }

    public void move(String move) {
        this.move = move;
    }

    public void move() {
        int lastX = head.x;
        int lastY = head.y;

        if(move == "Left") {
            head.x -= head.width;
            head.rect.x -= head.width;
        } else if(move == "Right") {
            head.x += head.width;
            head.rect.x += head.width;
        } else if(move == "Up") {
            head.y -= head.height;
            head.rect.y -= head.height;
        } else if(move == "Down") {
            head.y += head.height;
            head.rect.y += head.height;
        }

        tails.add(new Block(lastX, lastY, 20, 20));
        if(tails.size() > tailLength) {
            tails.remove(0);
        }
    }

    public void update() {
        for(Block tail : tails) {
            if(tail.rect.intersects(head.rect)) {
                Test.endGame();
                return;
            }
            tail.update();
        }
        move();
        head.update();
    }

    public void draw(Graphics g) {
        head.draw(g);
        for(Block tail : tails) {
            tail.draw(g);
        }
    }
}
