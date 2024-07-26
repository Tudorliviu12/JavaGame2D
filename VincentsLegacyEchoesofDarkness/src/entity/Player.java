package entity;

import main.GamePanel;
import main.KeyHandler;
import object.OBJ_Spell;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static main.GamePanel.*;

public class Player extends Entity{
    KeyHandler keyH;

    public final int screenX;
    public final int screenY; //constante de a lungul jocului
    public int boneCounter = 0, fruitCounter = 0, keyCounter = 0, scarabCounter = 0;


    public Player(GamePanel gp, KeyHandler keyH) throws IOException {
        super(gp);

        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 16;
        solidArea.y = 32;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        solidArea.width = 16;
        solidArea.height = 16;

        getPlayerImage();
        setDefaultValues();
    }

    //setam valorile default ale player ului (pozitie, viata, directie, viteza, proiectil)
    public void setDefaultValues() throws IOException {
        worldX = gp.tileSize * 29;
        worldY = gp.tileSize * 27; //pozitia default a player ului
        speed = 4;
        direction = "up";

        maxLife = 10;
        life = maxLife;

        projectile = new OBJ_Spell(gp);
    }


    public void setValuesNewGame() throws IOException {
        worldX = gp.tileSize * 29;
        worldY = gp.tileSize * 27;
        speed = 4;
        direction = "up";

        maxLife = 10;
        life = maxLife;

        projectile = new OBJ_Spell(gp);

        boneCounter = 0;
        fruitCounter = 0;
        keyCounter = 0;
        scarabCounter = 0;
        camelCounter = 0;
        coffeeCounter = 0;
        pizzaCounter = 0;
        dialogueIndex = 0;
        boneSpawnIndex = 0;
        portalSpawnIndex = 0;
        fruitSpawnIndex = 0;
        scarabSpawnIndex = 0;
        potionSpawnIndex = 0;
        pizzaSpawnIndex = 0;
        coffeeSpawnIndex = 0;
        camelSpawnIndex = 0;

        gp.aSetter.setNPC();
        gp.aSetter.setObject();
        gp.aSetter.setMonster();
    }

    //incarcam sprite urile
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Up3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Up4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Up5.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Down2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Down3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Down4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Down5.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Left3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Left4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Left5.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Right3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Right4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/player/Vincent-Right5.png"));



        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update() throws IOException {


        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true || keyH.EPressed == true) {
            if (keyH.upPressed == true) {
                direction = "up";
            } else if (keyH.downPressed == true) {
                direction = "down";
            } else if (keyH.leftPressed == true) {
                direction = "left";
            } else if (keyH.rightPressed == true) {
                direction = "right";
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            //verificam coliziunea cu obiectului, ca sa il putem colecta
            int objIndex = gp.cChecker.checkObject(this,true);
            pickUpObject(objIndex);

            //verificam coliziunea cu npc ul, ca sa putem dialoga cu el
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            //verificam coliziunea cu monstrul, pentru a primi si a da damage
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            contactMonster(monsterIndex);
            damageMonster(monsterIndex);

            gp.eHandler.checkEvent();

            if(collisionOn == false && keyH.EPressed == false){
                switch(direction){
                    case "up":
                        worldY = worldY - speed;
                        break;
                    case "down":
                        worldY = worldY + speed;
                        break;
                    case "left":
                        worldX = worldX - speed;
                        break;
                    case "right":
                        worldX = worldX + speed;
                        break;
                }
            }
            gp.keyH.EPressed = false;

            spriteCounter++;
            if (spriteCounter > 5) {
                if (spriteNum == 1 || spriteNum == 2 || spriteNum == 3 || spriteNum == 4) {
                    spriteNum++;
                } else if (spriteNum == 5) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

        if(gp.keyH.shotKeyPressed == true && projectile.alive == false){
            projectile.set(worldX, worldY, direction, true,this);
            gp.spellList.add(projectile);
        }

        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 60){
                invincible = false;
                invincibleCounter = 0;
            }
        }

        if(life <= 0){
            gp.gameState = gp.gameOverState;
            gp.stopMusic();
            gp.playSE(11);
        }
    }

    //functie pentru colectarea de obiecte, foloseste un switch pentru a verifica tipul de obiect colectat
    public void pickUpObject(int i) throws IOException {
        if (i>=0 && i < gp.obj[1].length && gp.obj[gp.currentMap][i]!=null) {
            String objectName = gp.obj[gp.currentMap][i].name;
            switch (objectName) { //verificam ce tip de obiect e, parcurgand vectorul de obiecte
                case "Bone":
                    if (gp.npc[gp.currentMap][0].boneSpawnIndex == 1) {
                        gp.playSE(1);
                        boneCounter++; //incrementam contorul
                        gp.obj[gp.currentMap][i] = null; //il facem sa dispara de pe harta
                        break;
                    }
                case "MrCoconut":
                    if (gp.currentMap == 1) {
//                        if (gp.npc[gp.currentMap][0].fruitSpawnIndex == 1) {
                            gp.playSE(4);
                            fruitCounter++;
                            gp.obj[gp.currentMap][i] = null;
                            break;
                        }
                case "Portal1":
                    if (gp.currentMap == 1) {
                        gp.playSE(5);
                        gp.obj[gp.currentMap][i] = null;
                        break;
                    }
                case "Key":
                    if (gp.currentMap == 1) {
//                        if (gp.npc[gp.currentMap][1].keySpawnIndex == 1) {
                            gp.obj[gp.currentMap][i] = null;
                            gp.playSE(7);
                            keyCounter++;
                            break;
//                        }
                    }
                case "Pizza":
                    if (gp.currentMap == 1) {
                        if (gp.npc[gp.currentMap][1].pizzaSpawnIndex == 1) {
                            gp.playSE(6);
                            gp.obj[gp.currentMap][i] = null;
                            gp.player.life = gp.player.maxLife;
                            gp.npc[gp.currentMap][1].pizzaCounter = 1;
                            break;
                        }
                    }
                case "Coffee":
                    if (gp.currentMap == 2) {
                        if (gp.npc[gp.currentMap][2].coffeeSpawnIndex == 1) {
                            gp.playSE(10);
                            gp.obj[gp.currentMap][i] = null;
                            gp.player.life = gp.player.maxLife;
                            gp.npc[gp.currentMap][2].coffeeCounter = 1;
                            break;
                        }
                    }
                case "Scarab":
                    if (gp.currentMap == 2) {
//                        if (gp.npc[gp.currentMap][0].scarabSpawnIndex == 1) {
                            gp.playSE(8);
                            scarabCounter++;
                            gp.obj[gp.currentMap][i] = null;
                            break;
                    }
                case "Potion": //in momentul in care player ul ia potiunea, se initializeaza variabilele pentru load nivel 3
                    if (gp.currentMap == 2) {
                        gp.obj[gp.currentMap][i] = null;
                        scarabCounter = 0;
                        camelCounter = 0;
                        coffeeCounter = 0;
                        potionSpawnIndex = 0;
                        life = maxLife;
                        gp.npc[gp.currentMap][2].coffeeSpawnIndex = 0;
                        gp.npc[gp.currentMap][2].dialogueIndex = 0;
                        gp.npc[gp.currentMap][0].dialogueIndex = 13;
                        gp.aSetter.setMonster();
                        gp.aSetter.setObject();
                        gp.aSetter.spawnCoffeeObject();
                        gp.currentStoryImage = 7;
                        gp.stopMusic();
                        gp.playMusic(2);
                        gp.gameState = gp.storyState2; //playstate e gata
                        deleteAllData("data", "Data_Table");
                        resetAutoIncrement("data", "Data_Table");
                        break;
                    }
            }
        }
    }

    //functie apelata in momentul interactiunii cu NPC ul, aceasta are loc in momentul apasarii tastei E
    public void interactNPC(int i){
            if(i!=invalidIndex) {
                if (gp.keyH.EPressed) {
                    gp.gameState = gp.dialogueState;
                    gp.npc[gp.currentMap][i].speak();
                }
            }
        gp.keyH.EPressed = false;
    }


    /*functie apelata in momentul contactului cu un monstru, acesta e de doua tipuri:
    fie camila, moment in care counter ul pentru camila creste, fie alt monstru, iar viata player ului scade
     */
    public void contactMonster(int i){
        if(i != invalidIndex) {
            if (i == 14 || i == 15 || i == 16) {
//                    if (gp.npc[gp.currentMap][2].camelSpawnIndex == 1) {
                        gp.obj[gp.currentMap][i] = null;
                        gp.playSE(12);
                        camelCounter++;
            //    }
            }
            else{
                if (invincible == false) {
                    life = life - 1;
                    invincible = true;
                }
            }
        }
    }

    //functie prin care player ul ii da damage monstrului la contact + la contactul cu proiectilul
    public void damageMonster(int i){
        if(i != invalidIndex){
            if(gp.monster[gp.currentMap][i].invincible == false){
                gp.monster[gp.currentMap][i].life--;
                gp.monster[gp.currentMap][i].invincible = true;

                if(gp.monster[gp.currentMap][i].life <= 0){
                    gp.monster[gp.currentMap][i] = null;
                }
            }
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;
        switch(direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2) {
                    image = up2;
                }
                if(spriteNum == 3) {
                    image = up3;
                }
                if(spriteNum == 4) {
                    image = up4;
                }
                if(spriteNum == 5) {
                    image = up5;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2) {
                    image = down2;
                }
                if(spriteNum == 3){
                    image = down3;
                }
                if(spriteNum == 4){
                    image = down4;
                }
                if(spriteNum == 5){
                    image = down5;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2) {
                    image = left2;
                }
                if(spriteNum == 3) {
                    image = left3;
                }
                if(spriteNum == 4) {
                    image = left4;
                }
                if(spriteNum == 5) {
                    image = left5;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2) {
                    image = right2;
                }
                if(spriteNum == 3) {
                    image = right3;
                }
                if(spriteNum == 4) {
                    image = right4;
                }
                if(spriteNum == 5) {
                    image = right5;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }
}
