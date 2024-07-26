package monster;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

//inamicul din nivelul 1: miscare haotica, nu ataca
public class MON_Pumpkin extends Entity {
    private int actionLockCounter = 0;
    public MON_Pumpkin(GamePanel gp) throws IOException {
        super(gp);
        type = 2;
        name = "Pumpkin";
        speed = 2;
        maxLife = 2;
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
            up1 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/up3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/up4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/up5.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/down2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/down3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/down4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/down5.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/left3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/left4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/left5.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/right3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/right4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/pumpkin/right5.png"));
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

//up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/up1.png")));
//up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/up2.png")));
//up3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/up3.png")));
//up4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/up4.png")));
//up5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/up5.png")));
//down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/down1.png")));
//down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/down2.png")));
//down3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/down3.png")));
//down4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/down4.png")));
//down5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/down5.png")));
//left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/left1.png")));
//left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/left2.png")));
//left3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/left3.png")));
//left4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/left4.png")));
//left5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/left5.png")));
//right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/right1.png")));
//right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/right2.png")));
//right3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/right3.png")));
//right4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/right4.png")));
//right5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pumpkin/right5.png")));