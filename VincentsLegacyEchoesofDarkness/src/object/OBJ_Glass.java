
package object;

import entity.Projectile;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

//proiectil utilizat de inamicii din nivelul 3
public class OBJ_Glass extends Projectile {
    GamePanel gp;

    public OBJ_Glass (GamePanel gp) throws IOException {
        super(gp);
        this.gp = gp;
        name = "Glass";
        speed = 4;
        maxLife = 100;
        life = maxLife;
        attack = 1;
        alive = false;
        getImage();
    }
    public void getImage() throws IOException {
        down1 = ImageIO.read(getClass().getResourceAsStream("/glass/spelldown.png"));
        down2 = ImageIO.read(getClass().getResourceAsStream("/glass/spelldown.png"));
        down3 = ImageIO.read(getClass().getResourceAsStream("/glass/spelldown.png"));
        down4 = ImageIO.read(getClass().getResourceAsStream("/glass/spelldown.png"));
        down5 = ImageIO.read(getClass().getResourceAsStream("/glass/spelldown.png"));
        up1 = ImageIO.read(getClass().getResourceAsStream("/glass/spellup.png"));
        up2 = ImageIO.read(getClass().getResourceAsStream("/glass/spellup.png"));
        up3 = ImageIO.read(getClass().getResourceAsStream("/glass/spellup.png"));
        up4 = ImageIO.read(getClass().getResourceAsStream("/glass/spellup.png"));
        up5 = ImageIO.read(getClass().getResourceAsStream("/glass/spellup.png"));
        left1 = ImageIO.read(getClass().getResourceAsStream("/glass/spellleft.png"));
        left2 = ImageIO.read(getClass().getResourceAsStream("/glass/spellleft.png"));
        left3 = ImageIO.read(getClass().getResourceAsStream("/glass/spellleft.png"));
        left4 = ImageIO.read(getClass().getResourceAsStream("/glass/spellleft.png"));
        left5 = ImageIO.read(getClass().getResourceAsStream("/glass/spellleft.png"));
        right1 = ImageIO.read(getClass().getResourceAsStream("/glass/spellright.png"));
        right2 = ImageIO.read(getClass().getResourceAsStream("/glass/spellright.png"));
        right3 = ImageIO.read(getClass().getResourceAsStream("/glass/spellright.png"));
        right4 = ImageIO.read(getClass().getResourceAsStream("/glass/spellright.png"));
        right5 = ImageIO.read(getClass().getResourceAsStream("/glass/spellright.png"));
    }
}
