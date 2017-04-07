/**
 * Created by christianbutron on 3/24/17.
 */
public class Test {
    private static GUI gui;
    public static void main(String[] args) {
        gui = new GUI();
    }

    public static void endGame() {
        gui = null;
    }
}
