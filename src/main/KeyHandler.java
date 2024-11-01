package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    boolean checkDrawTime= false;
    GamePanel gp;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        // PLAY STATE
        if (gp.gameState == gp.playState) {

            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }

            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }

            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }

            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }

            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }

            if (code == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }

            // DEBUG
            if (code == KeyEvent.VK_T) {

                if (checkDrawTime == false) {
                    checkDrawTime = true;
                } else if (checkDrawTime == true) {
                    checkDrawTime = false;
                }

            }

        }

        // PAUSE STATE
        else if (gp.gameState == gp.pauseState) {

            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }

        }

        // DIALOGUE STATE
        else if (gp.gameState == gp.dialogueState) {

            if (code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }

        }

        /*
        if (code == KeyEvent.VK_UP) {
            gp.zoomInOut(1);
        }
        if (code == KeyEvent.VK_DOWN) {
            gp.zoomInOut(-1);
        }
        */

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {

            upPressed = false;

        }

        if (code == KeyEvent.VK_S) {

            downPressed = false;

        }

        if (code == KeyEvent.VK_A) {

            leftPressed = false;

        }

        if (code == KeyEvent.VK_D) {

            rightPressed = false;

        }

    }

}
