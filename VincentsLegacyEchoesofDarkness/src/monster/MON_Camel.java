package monster;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Fireball;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

/*clasa MON_Camel defineste o entitate camila, care va fi collectable in nivelul al treilea (va disparea de pe ecran la
contactul cu player ul, si se va incrementa un contor, care trebuie sa fie cel putin 3 pentru a debloca recompensa
 */
public class MON_Camel extends Entity {
    GamePanel gp;
    public MON_Camel(GamePanel gp) throws IOException {
        super(gp);
        this.gp = gp;
        type = 2;
        name = "Camel";
        speed = 2;
        maxLife = 1;
        life = maxLife;

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
            up1 = ImageIO.read(getClass().getResourceAsStream("/camel/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/camel/up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/camel/up3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/camel/up2.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/camel/up3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/camel/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/camel/down2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/camel/down3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/camel/down2.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/camel/down3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/camel/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/camel/left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/camel/left3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/camel/left2.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/camel/left3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/camel/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/camel/right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/camel/right3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/camel/right2.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/camel/right3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setAction() { //miscare haotica
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
    }
}