import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Dude implements Constants {
    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    private Rectangle hitBox;

    public Dude() {
        initDude();
    }

    private void initDude() {
        ImageIcon ii = new ImageIcon(getClass().getResource(PICTURES_PATH+"sans.png"));
        image = ii.getImage();
        x = y = 10;
        hitBox = new Rectangle(0, 0, 46, 60);
    }

    public void move() {
        x += dx;
        y += dy;
        if (y <= 0)
            y = 1;
    }

    public void fall() {
        if (dy == 0)
            dy = 4;
    }

    public void stopFalling() {
        dy = 0;
        y = (y + hitBox.height) / BLOCK_SIZE * BLOCK_SIZE - hitBox.height - 1;
    }

    public void stopRunning() {    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -HORIZONTAL_MOVEMENT_SPEED;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = HORIZONTAL_MOVEMENT_SPEED;
        }
        if (key == KeyEvent.VK_UP) {
            dy = -VERTICAL_MOVEMENT_SPEED;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }
    }
}