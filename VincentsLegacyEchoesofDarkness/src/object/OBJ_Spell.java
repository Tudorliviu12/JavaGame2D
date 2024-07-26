package object;

import entity.Projectile;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

//proiectil utilizat de player
public class OBJ_Spell extends Projectile {
    GamePanel gp;

    public OBJ_Spell(GamePanel gp) throws IOException {
        super(gp);
        this.gp = gp;
        name = "Spell";
        speed = 5;
        maxLife = 100;
        life = maxLife;
        attack = 1;
        alive = false;
        getImage();
    }
    public void getImage() throws IOException {
        down1 = ImageIO.read(getClass().getResourceAsStream("/spell/spelldown.png"));
        down2 = ImageIO.read(getClass().getResourceAsStream("/spell/spelldown.png"));
        down3 = ImageIO.read(getClass().getResourceAsStream("/spell/spelldown.png"));
        down4 = ImageIO.read(getClass().getResourceAsStream("/spell/spelldown.png"));
        down5 = ImageIO.read(getClass().getResourceAsStream("/spell/spelldown.png"));
        up1 = ImageIO.read(getClass().getResourceAsStream("/spell/spellup.png"));
        up2 = ImageIO.read(getClass().getResourceAsStream("/spell/spellup.png"));
        up3 = ImageIO.read(getClass().getResourceAsStream("/spell/spellup.png"));
        up4 = ImageIO.read(getClass().getResourceAsStream("/spell/spellup.png"));
        up5 = ImageIO.read(getClass().getResourceAsStream("/spell/spellup.png"));
        left1 = ImageIO.read(getClass().getResourceAsStream("/spell/spellleft.png"));
        left2 = ImageIO.read(getClass().getResourceAsStream("/spell/spellleft.png"));
        left3 = ImageIO.read(getClass().getResourceAsStream("/spell/spellleft.png"));
        left4 = ImageIO.read(getClass().getResourceAsStream("/spell/spellleft.png"));
        left5 = ImageIO.read(getClass().getResourceAsStream("/spell/spellleft.png"));
        right1 = ImageIO.read(getClass().getResourceAsStream("/spell/spellright.png"));
        right2 = ImageIO.read(getClass().getResourceAsStream("/spell/spellright.png"));
        right3 = ImageIO.read(getClass().getResourceAsStream("/spell/spellright.png"));
        right4 = ImageIO.read(getClass().getResourceAsStream("/spell/spellright.png"));
        right5 = ImageIO.read(getClass().getResourceAsStream("/spell/spellright.png"));
    }
}
