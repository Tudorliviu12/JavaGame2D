package monster;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Fireball;
import object.OBJ_Glass;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

//inamicul din nivelul 3: urmareste player ul si arunca cu proiectil tip Glass doar in apropierea acestuia
public class MON_Mummy extends Entity {
    GamePanel gp;
    public MON_Mummy(GamePanel gp) throws IOException {
        super(gp);
        this.gp = gp;
        type = 2;
        name = "Mummy";
        speed = 2;
        maxLife = 3;
        life = maxLife;
        attack = 5;

        projectile = new OBJ_Glass(gp);

        solidArea.x = 3;
        solidArea.y = 3;
        solidArea.width = 42;
        solidArea.height = 52;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();
    }

    public void update() throws IOException {
        super.update();

        //we check the distance between the player and the dragons
        int xDistance=Math.abs(worldX-gp.player.worldX);
        int yDistance=Math.abs(worldY-gp.player.worldY);
        int tileDistance=(xDistance + yDistance)/gp.tileSize;

        if(onPath == false && tileDistance <4){
            onPath = true;
            //}

        }
        //if the distance is greater than 7 tiles
        if(onPath == true && tileDistance >5){
            onPath=false;
        }
    }

    public void getImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/mummy/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/mummy/up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/mummy/up3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/mummy/up4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/mummy/up5.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/mummy/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/mummy/down2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/mummy/down3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/mummy/down4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/mummy/down5.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/mummy/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/mummy/left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/mummy/left3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/mummy/left4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/mummy/left5.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/mummy/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/mummy/right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/mummy/right3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/mummy/right4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/mummy/right5.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setAction(){ //urmaresc si ataca player ul
        if(onPath){
            int goalCol=(gp.player.worldX + gp.player.solidArea.x)/gp.tileSize;
            int goalRow=(gp.player.worldY + gp.player.solidArea.y)/gp.tileSize;

            searchPath(goalCol, goalRow);

            int i = new Random().nextInt(200)+1;
            if(i>197 && projectile.alive == false && shotAvailableCounter == 30){
            projectile.set(worldX, worldY, direction, true, this);
            gp.spellList.add(projectile);
            shotAvailableCounter = 0;
        }
        }
        else {
            actionLockCounter++;

            if (actionLockCounter == 120) { //every 2 seconds
                Random random = new Random();
                int i = random.nextInt(100) + 1; //pick up a number from 1 to 100

                if (i <= 25) {
                    direction = "up";
                }
                if (i > 25 && i <= 50) {
                    direction = "down";
                }
                if (i > 50 && i <= 75) {
                    direction = "left";
                }
                if (i > 75 && i <= 100) {
                    direction = "right";
                }
                actionLockCounter = 0;
            }
        }
    }
}