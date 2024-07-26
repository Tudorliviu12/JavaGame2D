package monster;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Fireball;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

//inamicul din nivelul 2: miscare haotica + proiectile tip Fireball aruncate haotic
public class MON_Goblin extends Entity {
    GamePanel gp;
    public MON_Goblin(GamePanel gp) throws IOException {
        super(gp);
        this.gp = gp;
        type = 2;
        name = "Goblin";
        speed = 3;
        maxLife = 3;
        life = maxLife;
        attack = 5;

        projectile = new OBJ_Fireball(gp);

        solidArea.x = 3;
        solidArea.y = 3;
        solidArea.width = 42;
        solidArea.height = 52;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();
    }

    public void getImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/goblin/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/goblin/up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/goblin/up3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/goblin/up4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/goblin/up5.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/goblin/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/goblin/down2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/goblin/down3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/goblin/down4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/goblin/down5.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/goblin/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/goblin/left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/goblin/left3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/goblin/left4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/goblin/left5.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/goblin/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/goblin/right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/goblin/right3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/goblin/right4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/goblin/right5.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setAction() { //miscare haotica + atac
        actionLockCounter++;
        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i<=100) {
                direction = "right";
            }
            actionLockCounter = 0;
        }
        int i = new Random().nextInt(100)+1;
        if(i>99 && projectile!=null && projectile.alive == false && shotAvailableCounter == 30){
            projectile.set(worldX, worldY, direction, true, this);
            gp.spellList.add(projectile);
            shotAvailableCounter = 0;
        }
    }
}