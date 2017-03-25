import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by christianbutron on 3/24/17.
 */

public class GUI extends Canvas implements Runnable, KeyListener {
    private Thread thread;
    private JFrame frame;
    private BufferStrategy bs = null;
    private Graphics graphics = null;

    public static final int WIDTH = 960;
    public static final int HEIGHT = 540;

    private boolean running = false;

    private Snake snake;
    private Block block;

    public GUI() {
        frame = new JFrame("Snake");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        snake = new Snake();

        int randX = ThreadLocalRandom.current().nextInt(0, WIDTH-20);
        int randY = ThreadLocalRandom.current().nextInt(0, HEIGHT-20);

        block = new Block((randX / 20) * 20, (randY / 20) * 20, 20, 20);

        frame.add(this);

        thread = new Thread(this);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addKeyListener(this);
    }

    public void paint(Graphics g) {
        if(bs == null) {
            createBufferStrategy(2);
            bs = getBufferStrategy();
            graphics = bs.getDrawGraphics();

            thread.start();
            running = true;
        }
    }

    public void update() {
        if(snake.head.rect.intersects(block.rect)) {
            int randX = ThreadLocalRandom.current().nextInt(0, WIDTH-20);
            int randY = ThreadLocalRandom.current().nextInt(0, HEIGHT-20);
            block = new Block((randX / 20) * 20, (randY / 20) * 20, 20, 20);

            snake.tailLength++;
        }
        snake.update();
        block.update();
    }

    public void render() {
        graphics.clearRect(0, 0, WIDTH, HEIGHT);

        graphics.setColor(Color.black);
        graphics.fillRect(0,0,WIDTH,HEIGHT);

        graphics.setColor(Color.green);
        snake.draw(graphics);

        graphics.setColor(Color.red);
        block.draw(graphics);
    }

    @Override
    public void run() {
        while(running) {
            update();
            render();
            bs.show();

            Thread.currentThread();
            try {
                thread.sleep(100);
            } catch(InterruptedException e) { }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(snake.move != "Right" && snake.move != "Left" && e.getKeyCode() == KeyEvent.VK_LEFT) {
            snake.move("Left");
        }
        else if(snake.move != "Left" && snake.move != "Right" && e.getKeyCode() == KeyEvent.VK_RIGHT) {
            snake.move("Right");
        }
        else if(snake.move != "Down" && snake.move != "Up" && e.getKeyCode() == KeyEvent.VK_UP) {
            snake.move("Up");
        }
        else if(snake.move != "Up" && snake.move != "Down" && e.getKeyCode() == KeyEvent.VK_DOWN) {
            snake.move("Down");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
