package object;

import entity.Projectile;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

//proiectil utilizat de inamicii din nivelul 2
public class OBJ_Fireball extends Projectile {
    GamePanel gp;

    public OBJ_Fireball (GamePanel gp) throws IOException {
        super(gp);
        this.gp = gp;
        name = "Fireball";
        speed = 4;
        maxLife = 100;
        life = maxLife;
        attack = 1;
        alive = false;
        getImage();
    }
    public void getImage() throws IOException {
        down1 = ImageIO.read(getClass().getResourceAsStream("/fireball/spelldown.png"));
        down2 = ImageIO.read(getClass().getResourceAsStream("/fireball/spelldown.png"));
        down3 = ImageIO.read(getClass().getResourceAsStream("/fireball/spelldown.png"));
        down4 = ImageIO.read(getClass().getResourceAsStream("/fireball/spelldown.png"));
        down5 = ImageIO.read(getClass().getResourceAsStream("/fireball/spelldown.png"));
        up1 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellup.png"));
        up2 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellup.png"));
        up3 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellup.png"));
        up4 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellup.png"));
        up5 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellup.png"));
        left1 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellleft.png"));
        left2 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellleft.png"));
        left3 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellleft.png"));
        left4 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellleft.png"));
        left5 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellleft.png"));
        right1 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellright.png"));
        right2 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellright.png"));
        right3 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellright.png"));
        right4 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellright.png"));
        right5 = ImageIO.read(getClass().getResourceAsStream("/fireball/spellright.png"));
    }
}
