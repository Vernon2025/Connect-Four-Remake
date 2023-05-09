import javax.swing.*;
import java.awt.*;

public class ConnectFourUI extends JPanel implements Runnable {
    final int diskSlotSize = 128;
    final int boardRowSlots = 6;
    final int boardColumnSlots = 7;
    final int diskSizeRed = 128;
    final int diskSizeYellow = 128;
    final int SCREEN_WIDTH = diskSlotSize * boardColumnSlots;
    final int SCREEN_HEIGHT = diskSlotSize * boardRowSlots + 128;
    int[] diskRowOneX = { 0, 128, 256, 384, 512, 640, 768 };
    int[] diskRowOneY = { -128, -128, -128, -128, -128, -128, -128 };
    int[] diskRowTwoX = { 0, 128, 256, 384, 512, 640, 768 };
    int[] diskRowTwoY = {-256, -256, -256, -256, -256, -256, -256};
    int diskSpeed = 3;
    boolean playerTurn = true;
    int select;
    Thread thread;
    ConnectFourUI() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLUE);
    }

    public void startThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (thread != null) {
            redraw();
            repaint();
            // Pause the game loop for 16 milliseconds to regulate the frame rate
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void redraw() {
        selectDiskPosition();
        collisionDisk();
    }

    private void collisionDisk() {
        if (diskRowOneY[0] > SCREEN_HEIGHT - diskSizeRed * 2) {
            diskRowOneY[0] = SCREEN_HEIGHT - diskSizeRed * 2;
        } else if (diskRowOneY[1] > SCREEN_HEIGHT - 128 * 2) {
            diskRowOneY[1] = SCREEN_HEIGHT - diskSizeRed * 2;
        } else if (diskRowOneY[2] > SCREEN_HEIGHT - diskSizeRed * 2) {
            diskRowOneY[2] = SCREEN_HEIGHT - diskSizeRed * 2;
        } else if (diskRowOneY[3] > SCREEN_HEIGHT - diskSizeRed * 2) {
            diskRowOneY[3] = SCREEN_HEIGHT - diskSizeRed * 2;
        } else if (diskRowOneY[4] > SCREEN_HEIGHT - diskSizeRed * 2) {
            diskRowOneY[4] = SCREEN_HEIGHT - diskSizeRed * 2;
        } else if (diskRowOneY[5] > SCREEN_HEIGHT - diskSizeRed * 2) {
            diskRowOneY[5] = SCREEN_HEIGHT - diskSizeRed * 2;
        } else if (diskRowOneY[6] > SCREEN_HEIGHT - diskSizeRed * 2) {
            diskRowOneY[6] = SCREEN_HEIGHT - diskSizeRed * 2;
        }
    }

    private void selectDiskPosition() {
        if (select == 1) {
            diskRowOneY[0] += diskSpeed;
        } else if (select == 2) {
            diskRowOneY[1] += diskSpeed;
        } else if (select == 3) {
            diskRowOneY[2] += diskSpeed;
        } else if (select == 4) {
            diskRowOneY[3] += diskSpeed;
        } else if (select == 5) {
            diskRowOneY[4] += diskSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        
        
        
        g2D.setColor(Color.RED);
        g2D.fillOval(diskRowOneX[0], diskRowOneY[0], diskSizeRed, diskSizeRed);
        g2D.fillOval(diskRowOneX[1], diskRowOneY[1], diskSizeRed, diskSizeRed);
        g2D.fillOval(diskRowOneX[2], diskRowOneY[2], diskSizeRed, diskSizeRed);
        g2D.fillOval(diskRowOneX[3], diskRowOneY[3], diskSizeRed, diskSizeRed);
        g2D.fillOval(diskRowOneX[4], diskRowOneY[4], diskSizeRed, diskSizeRed);
        g2D.fillOval(diskRowOneX[5], diskRowOneY[5], diskSizeRed, diskSizeRed);
        g2D.fillOval(diskRowOneX[6], diskRowOneY[6], diskSizeRed, diskSizeRed);
        
        g2D.setColor(Color.YELLOW);
        g2D.fillOval(diskRowTwoX[0], diskRowTwoY[0], diskSizeYellow, diskSizeYellow);
        g2D.fillOval(diskRowTwoX[1], diskRowTwoY[1], diskSizeYellow, diskSizeYellow);
        g2D.fillOval(diskRowTwoX[2], diskRowTwoY[2], diskSizeYellow, diskSizeYellow);
        g2D.fillOval(diskRowTwoX[3], diskRowTwoY[3], diskSizeYellow, diskSizeYellow);
        g2D.fillOval(diskRowTwoX[4], diskRowTwoY[4], diskSizeYellow, diskSizeYellow);
        g2D.fillOval(diskRowTwoX[5], diskRowTwoY[5], diskSizeYellow, diskSizeYellow);
        g2D.fillOval(diskRowTwoX[6], diskRowTwoY[6], diskSizeYellow, diskSizeYellow);
        g2D.dispose();
    }
}
