package main;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

// clasa KeyHandler gestioneaza apasarea tastelor si legatura dintre ele si actiunile care au loc in joc
public class KeyHandler implements KeyListener {
    public GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, EPressed, shotKeyPressed;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (gp.gameState == gp.titleState) {
            if (code == KeyEvent.VK_W) {
                if (gp.ui.commandNum == 1 || gp.ui.commandNum == 2)
                    gp.ui.commandNum--;
                else
                    gp.ui.commandNum = 2;
            } else if (code == KeyEvent.VK_S) {
                if (gp.ui.commandNum == 0 || gp.ui.commandNum == 1)
                    gp.ui.commandNum++;
                else
                    gp.ui.commandNum = 0;
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gp.ui.commandNum == 0) {//selectam new game
                    gp.gameState = gp.storyState;
                    gp.currentStoryImage = 1;
                    gp.currentMap = 0;
                    try {
                        gp.player.setValuesNewGame();
                        gp.npc[gp.currentMap][0].setValuesLoadNPCHelena();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (gp.ui.commandNum == 1) {//selectam load game
                    if(gp.loadLevel == 0){
                        gp.stopMusic();
                        gp.playMusic(0);
                        gp.currentMap = 0;
                        gp.npc[gp.currentMap][0].dialogueIndex = 0;
                    }
                    if(gp.loadLevel == 1){
                        gp.stopMusic();
                        gp.playMusic(3);
                        gp.currentMap = 1;
                        gp.npc[gp.currentMap][0].dialogueIndex = 9;
                    }
                    if(gp.loadLevel == 2){
                        gp.stopMusic();
                        gp.playMusic(9);
                        gp.currentMap = 2;
                        gp.npc[gp.currentMap][0].dialogueIndex = 13;
                    }
                    gp.gameState = gp.playState;
                }
                if (gp.ui.commandNum == 2) {//selectam exit game
                    System.exit(0);
                }
            }
        }

        if (gp.gameState == gp.storyState && code == KeyEvent.VK_SPACE) { //derulam cutscene urile
            if (gp.currentStoryImage < 6) {
                gp.currentStoryImage++;
                gp.repaint();
            } else {
                gp.gameState = gp.playState;
                gp.stopMusic();
                if(gp.currentMap == 0) {
                    gp.playMusic(0);
                }
                if(gp.currentMap == 1){
                    gp.playMusic(3);
                }
                if(gp.currentMap == 2){
                    gp.playMusic(9);
                }
                gp.repaint();
            }
        }

        if (gp.gameState == gp.storyState2 && code == KeyEvent.VK_SPACE) {
            if (gp.currentStoryImage < 10) {
                gp.currentStoryImage++;
                gp.repaint();
            }
            else{
                gp.gameState = gp.titleState;
            }
        }
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
            if (code == KeyEvent.VK_E) {
                EPressed = true;
            }
            if (code == KeyEvent.VK_SPACE){
                shotKeyPressed = true;
            }
        }
        else if (gp.gameState == gp.dialogueState) {
        if (code == KeyEvent.VK_E) {
            gp.gameState = gp.playState;
             }
        }

        if(gp.gameState == gp.gameOverState){
            if(code == KeyEvent.VK_W) {
                if (gp.ui.commandNum == 0) {
                    gp.ui.commandNum = 1;
                }
                else{
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_S) {
                if (gp.ui.commandNum == 1) {
                    gp.ui.commandNum = 0;
                }
                else{
                    gp.ui.commandNum = 1;
                }
            }

            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.gameState=gp.playState;
                    try {
                        gp.retry();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    if(gp.currentMap == 0) {
                        gp.stopMusic();
                        gp.playMusic(0);
                    }
                    if(gp.currentMap == 1) {
                        gp.stopMusic();
                        gp.playMusic(3);
                    }
                    if(gp.currentMap == 2) {
                        gp.stopMusic();
                        gp.playMusic(9);
                    }
                }
                else if(gp.ui.commandNum == 1){
                    gp.gameState=gp.titleState;
                    try {
                        gp.restart();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }

         if(gp.gameState == gp.playState){
             if(code==KeyEvent.VK_P) {
                 gp.gameState = gp.pauseState;
             }
         }
         else if(gp.gameState == gp.pauseState){
                 if(code==KeyEvent.VK_P) {
                     gp.gameState = gp.playState;
                 }
            }
    }
//        if(code == KeyEvent.VK_W){
//            upPressed = true;
//        }
//        else if(code == KeyEvent.VK_A){
//            leftPressed = true;
//        }
//        else if(code == KeyEvent.VK_S){
//            downPressed = true;
//        }
//        else if(code == KeyEvent.VK_D){
//            rightPressed = true;
//        }
//        else if(code == KeyEvent.VK_E){
//            if(gp.gameState != gp.dialogueState) {
//                gp.gameState = gp.dialogueState;
//            }
//            else{
//
//            }
//            EPressed = true;
//        }
//        else if(gp.gameState == gp.dialogueState){
//            if(code == KeyEvent.VK_Q){
//                gp.gameState = gp.playState;
//            }
//        }
//    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if (code == KeyEvent.VK_SPACE){
            shotKeyPressed = false;
        }
    }
}
