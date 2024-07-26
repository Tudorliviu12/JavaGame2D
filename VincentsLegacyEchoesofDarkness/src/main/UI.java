package main;

import object.OBJ_Bone;
import object.OBJ_MrCoconut;
import object.OBJ_Health;
import object.SuperObject;
import object.OBJ_Scarab;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


//clasa UI gestioneaza interfata cu utilizatorul
public class UI {
    GamePanel gp;
    Graphics2D g2;
    BufferedImage health1, health2, health3, health4, health5, health6;
    Font chiller_40, textbox;
    BufferedImage boneImage, fruitImage, scarabImage;
    public Color myGray = new Color(202,193,175);

    public String currentDialogue = "";
    public int commandNum = 0;

    public UI(GamePanel gp){
        this.gp = gp;
        chiller_40 = new Font("Chiller", Font.BOLD, 40);

        OBJ_Bone bone = new OBJ_Bone();
        boneImage = bone.image;

        OBJ_MrCoconut fruit = new OBJ_MrCoconut();
        fruitImage = fruit.image;

        OBJ_Scarab scarab = new OBJ_Scarab();
        scarabImage = scarab.image;

        SuperObject health = new OBJ_Health(gp);
        health1 = health.image;
        health2 = health.image2;
        health3 = health.image3;
        health4 = health.image4;
        health5 = health.image5;
        health6 = health.image6;
    }

    public void draw(Graphics2D g2, GamePanel gp1) throws IOException {
        this.g2 = g2;

        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
        else {
            if (gp.gameState == gp.playState) {
                drawPlayerLife();
            }
            Color myColor = new Color(65, 54, 74, 200);
            if (gp.currentMap == 0) { //verificam in functie de harta, ca sa ne afiseze contorul potrivit (oase/cocos/scarabei)
                if (gp.npc[this.gp.currentMap][0] != null && gp.npc[gp.currentMap][0].boneSpawnIndex == 1) {
                    g2.setColor(myColor);
                    g2.fillRoundRect(20, 20, 182, 65, 15, 15);

                    g2.setFont(chiller_40);
                    g2.setColor(myGray);
                    g2.drawImage(boneImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
                    g2.drawString(": " + gp.player.boneCounter + "/20", 74, 64);
                }
            }
            if (gp.currentMap == 1) {
                if (gp.npc[this.gp.currentMap][0] != null) {
                    g2.setColor(myColor);
                    g2.fillRoundRect(20, 20, 182, 65, 15, 15);

                    g2.setFont(chiller_40);
                    g2.setColor(myGray);
                    g2.drawImage(fruitImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
                    g2.drawString(": " + gp.player.fruitCounter + "/20", 74, 64);
                }
            }
            if (gp.currentMap == 2) {
                if (gp.npc[this.gp.currentMap][0] != null) {
                    g2.setColor(myColor);
                    g2.fillRoundRect(20, 20, 182, 65, 15, 15);

                    g2.setFont(chiller_40);
                    g2.setColor(myGray);
                    g2.drawImage(scarabImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
                    g2.drawString(": " + gp.player.scarabCounter + "/20", 74, 64);
                }
            }

            if (gp.gameState == gp.dialogueState) {
                drawDialogueScreen();
                drawPlayerLife();
            }
            if (gp.gameState == gp.pauseState) {
                drawPauseScreen();
            }
            if (gp.gameState == gp.gameOverState) {
                drawGameOverScreen();
            }
        }
    }
    public void drawPauseScreen(){ //functia deseneaza meniul de pauza, afisand valorile extrase din baza de date
        String text = "PAUSED: ";
        Font font = new Font("Showcard Gothic", Font.PLAIN, 44);
        g2.setFont(font);
        g2.setColor(Color.white);
        int x = getXforCenteredText(text);
        int y = gp.tileSize*3;

        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);

        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        String lifeP = "Current life: " + gp.lifePause; //incarcam din baza de date valorile memorate in variabile
        g2.setFont(font);
        g2.setColor(Color.white);
        x = getXforCenteredText(lifeP);
        y = gp.tileSize*4;

        g2.setColor(Color.black);
        g2.drawString(lifeP, x+5, y+5);

        g2.setColor(Color.white);
        g2.drawString(lifeP, x, y);

        String XP = "Current X: " + gp.XPause;
        g2.setFont(font);
        g2.setColor(Color.white);
        x = getXforCenteredText(XP);
        y = gp.tileSize*5;

        g2.setColor(Color.black);
        g2.drawString(XP, x+5, y+5);

        g2.setColor(Color.white);
        g2.drawString(XP, x, y);

        String YP = "Current Y: " + gp.YPause;
        g2.setFont(font);
        g2.setColor(Color.white);
        x = getXforCenteredText(YP);
        y = gp.tileSize*6;

        g2.setColor(Color.black);
        g2.drawString(YP, x+5, y+5);

        g2.setColor(Color.white);
        g2.drawString(YP, x, y);
    }
    public void drawPlayerLife(){ //deseneaza health bar ul
//        int x = gp.tileSize/2;
//        int y = gp.tileSize/2;
        int x = 800;
        int y = 30;
        switch(gp.player.life){
            case 10:
                g2.drawImage(health1, x, y, null);
                break;
            case 9:
                g2.drawImage(health1, x, y, null);
                break;
            case 8:
                g2.drawImage(health2, x, y, null);
                break;
            case 7:
                g2.drawImage(health2, x, y, null);
                break;
            case 6:
                g2.drawImage(health3, x, y, null);
                break;
            case 5:
                g2.drawImage(health3, x, y, null);
                break;
            case 4:
                g2.drawImage(health4, x, y, null);
                break;
            case 3:
                g2.drawImage(health4, x, y, null);
                break;
            case 2:
                g2.drawImage(health5, x, y, null);
                break;
            case 1:
                g2.drawImage(health5, x, y, null);
                break;
            default:
                g2.drawImage(health6, x, y, null);
                break;
        }
    }

    public void drawGameOverScreen(){ //deseneaza ecranul de gameover, cu optiunile de RETRY si QUIT
        String text = "YOU DIED!! RIP!!";
        Font font = new Font("Showcard Gothic", Font.PLAIN, 44);

        int x = getXforCenteredText(text);
        int y = gp.tileSize*3;
        g2.setFont(font);
        g2.setColor(Color.white);

        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);
/////////
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        g2.setFont(font);
        g2.setColor(Color.white);
        text="Retry";
        x=getXforCenteredText(text);
        y+=gp.tileSize*4;
        g2.drawString(text, x, y);

        if(commandNum ==0){
            g2.drawString(">", x-40, y);
        }

        text="Quit";
        x=getXforCenteredText(text);
        y+=55;
        g2.drawString(text, x, y);

        if(commandNum ==1){
            g2.drawString(">", x-40, y);
        }
    }

    public void drawTitleScreen() {  //deseneaza meniul principal al jocului, cu optiunile new game, load game, exit game
        try{
            BufferedImage bf;
            bf = ImageIO.read(getClass().getResourceAsStream("/background/menu.jpg"));
            g2.drawImage(bf, 0, 0, gp.screenWidth, gp.screenHeight, null);

            String text = "VINCENT'S LEGACY: ECHOES OF DARKNESS";
            Font font = new Font("Showcard Gothic", Font.PLAIN, 44);
            g2.setFont(font);
            g2.setColor(Color.white);
            int x = getXforCenteredText(text);
            int y = gp.tileSize*3;

            g2.setColor(Color.black);
            g2.drawString(text, x+5, y+5);

            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            font = new Font("Showcard Gothic", Font.PLAIN, 30);
            g2.setFont(font);
            text = "New Game";
            x = getXforCenteredText(text) - 350;
            y = y + gp.tileSize*2;
            g2.drawString(text, x, y);
            BufferedImage boneImage1;
            boneImage1 = ImageIO.read(getClass().getResourceAsStream("/objects/bone.png"));
            if(commandNum == 0){
                g2.drawImage(boneImage1, x-40, y-30, null);
            }

            text = "Load Game";
            x = getXforCenteredText(text) - 350;
            y = y + gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1){
                g2.drawImage(boneImage1, x-40, y-30, null);
            }

            text = "Exit Game";
            x = getXforCenteredText(text) - 350;
            y = y + gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2){
                g2.drawImage(boneImage1, x-40, y-30, null);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth/2 - length/2;
    }

    public void drawDialogueScreen(){ //deseneaza caseta de dialog in momentul interactiunii cu NPC ul
        int x = gp.tileSize*2;
        int y = gp.tileSize*8;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*4;
        drawSubWindow(x,y,width,height);

        textbox = new Font("Lucida Sans Typewriter", Font.PLAIN, 16);
        g2.setFont(textbox);
        x = x + gp.tileSize;
        y = y + gp.tileSize;

        for(String line: currentDialogue.split("\n")){
            g2.drawString(line, x, y);
            y = y + 40;
        }

    }
    public void drawSubWindow(int x, int y, int width, int height){
        Color myBlack = new Color(0,0,0,220);
        g2.setColor(myBlack);
        g2.fillRoundRect(x,y,width,height,35,35);

        Color myWhite = new Color(255,255,255,220);
        g2.setColor(myWhite);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);

    }
}
