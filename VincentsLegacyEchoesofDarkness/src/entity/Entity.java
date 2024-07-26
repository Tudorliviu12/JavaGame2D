package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Entity { //clasa pentru entitati
    public GamePanel gp;
    public int worldX, worldY; //pozitia jucatorului pe harta
    public int speed;
    public BufferedImage up1, up2, up3, up4, up5, down1, down2, down3, down4, down5, left1, left2, left3, left4, left5, right1, right2, right3, right4, right5, stayHelena;
    public String direction = "down";

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea = new Rectangle(0, 0, 42, 52);
    public Rectangle attackArea = new Rectangle(0, 0, 0, 0);

    public int solidAreaDefaultX, solidAreaDefaultY;

    public boolean collisionOn = false;
    public int actionLockCounter = 0;

    public boolean invincible = false;
    public int invincibleCounter = 0;
    public int shotAvailableCounter = 0;


    String dialogue[] = new String[30];
    public int dialogueIndex = 0;
    public int boneSpawnIndex = 0;
    public int fruitSpawnIndex = 0;
    public int portalSpawnIndex = 0;
    public int keySpawnIndex = 0;
    public int pizzaSpawnIndex = 0;
    public int pizzaCounter = 0;
    public int scarabSpawnIndex = 0;
    public int potionSpawnIndex = 0;
    public int camelSpawnIndex = 0;
    public int coffeeSpawnIndex = 0;
    public int camelCounter = 0;
    public int coffeeCounter = 0;

    public BufferedImage image;

    public String name;
    public int attack;
    public Projectile projectile;
    public boolean alive = true;
    public boolean dying = false;
    public int dyingCounter = 0;

    public boolean onPath = false;

    public boolean CollisionOn = false;
    public int type; // 0=PLAYER, 1=NPC, 2=MONSTER;

    public int maxLife;
    public int life;
    public int invalidIndex = -1;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void speak() { //functie pentru dialog, apelata pentru NPC-uri

    }

    public void setAction() { //functie pentru actiunile realizate de inamici (attack, deplasare)
    }

    public void setValuesLoadNPCHelena(){}; //utilizate pentru valorile default cand incepe un load game
    public void setValuesLoadNPCArcheologist(){};
    public void setValuesLoadNPCArabMan(){};


    public void checkCollision() { //functie pentru verificarea coliziunilor, apeleaza functiile din collisionChecker
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkEntity(this, gp.monster);
        boolean contactPlayer = gp.cChecker.checkPlayer(this);
//        gp.cChecker.checkEntity(this, gp.monster);

        if (this.type == 2 && contactPlayer == true) { //verificam daca e monstru, atunci player-ul isi ia damage
            damagePlayer(attack);
        }
    }

    public void update() throws IOException {
        setAction();
        checkCollision();

        if (collisionOn == false) { //daca nu exista coliziune player-ul se poate deplasa
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }

        spriteCounter++;
        if (spriteCounter > 12) {
            spriteNum++;
            if (spriteNum > 3) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        if (invincible == true) {
            invincibleCounter++;
            if (invincibleCounter > 30) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
        if (shotAvailableCounter < 30)
            shotAvailableCounter++;
    }

    //in momentul in care player ul nu se afla in momentele de invincibilitate, isi ia damage si i se scade din viata
    public void damagePlayer(int attack) {
        if (gp.player.invincible == false) {
            gp.player.life = gp.player.life - 1;
            gp.player.invincible = true;
        }
    }

    public void draw(Graphics2D g2) { //in functie de directie, entitatile se deplaseaza, schimbandu se intre ele sprite urile
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                    if (spriteNum == 3) {
                        image = up3;
                    }
                    if (spriteNum == 4) {
                        image = up4;
                    }
                    if (spriteNum == 5) {
                        image = up5;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    if (spriteNum == 3) {
                        image = down3;
                    }
                    if (spriteNum == 4) {
                        image = down4;
                    }
                    if (spriteNum == 5) {
                        image = down5;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                    if (spriteNum == 3) {
                        image = left3;
                    }
                    if (spriteNum == 4) {
                        image = left4;
                    }
                    if (spriteNum == 5) {
                        image = left5;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                    if (spriteNum == 3) {
                        image = right3;
                    }
                    if (spriteNum == 4) {
                        image = right4;
                    }
                    if (spriteNum == 5) {
                        image = right5;
                    }
                    break;
            }
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }


    public void draw(Graphics2D g2, GamePanel gp, int v1, int v2) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
            g2.drawImage(image, screenX, screenY, v1, v2, null);
        }
    }

    public void searchPath(int goalCol, int goalRow) { //functie folosita in algoritmul prin care inamicii urmaresc player ul
        //this is where the entity is
        int startCol = (worldX + solidArea.x) / gp.tileSize;
        int startRow = (worldY + solidArea.y) / gp.tileSize;

        gp.pFinder.setNodes(startCol, startRow, goalCol, goalRow);

        if (gp.pFinder.search() == true) {

            int nextX = gp.pFinder.pathList.get(0).col * gp.tileSize;
            int nextY = gp.pFinder.pathList.get(0).row * gp.tileSize;

            int enLeftX = worldX + solidArea.x;
            int enRightX = worldX + solidArea.x + solidArea.width;
            int enTopY = worldY + solidArea.y;
            int enBottomY = worldY + solidArea.y + solidArea.height;

            if (enTopY > nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
                direction = "up";
            } else if (enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
                direction = "down";
            } else if (enTopY >= nextY && enBottomY < nextY + gp.tileSize) {
                if (enLeftX > nextX) {
                    direction = "left";
                }
                if (enLeftX < nextX) {
                    direction = "right";
                }
            } else if (enTopY > nextY && enLeftX > nextX) {
                direction = "up";
                checkCollision();
                if (collisionOn == true) {
                    direction = "left";
                }
            } else if (enTopY > nextY && enLeftX < nextX) {
                direction = "up";
                checkCollision();
                if (collisionOn == true) {
                    direction = "right";
                }
            } else if (enTopY < nextY && enRightX > nextX) {
                direction = "down";
                checkCollision();
                if (collisionOn == true) {
                    direction = "left";
                }
            } else if (enTopY < nextY && enRightX < nextX) {
                direction = "down";
                checkCollision();
                if (collisionOn == true) {
                    direction = "right";
                }
            }
        }
    }
}