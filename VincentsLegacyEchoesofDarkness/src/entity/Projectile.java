package entity;

import main.GamePanel;

public class Projectile extends Entity{
/*
Projectile este o clasa care extinde Entity, si este reprezentata de proiectilele aruncate atat
de catre player (Spell), cat si de catre inamici (Fireball, Glass). Atat player ul cat si inamicii isi iau
damage la contactul cu aceasta
 */
    Entity user;

    public Projectile(GamePanel gp) {
        super(gp);
    }

    public void set(int worldX, int worldY, String direction, boolean alive, Entity user){
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.alive = alive;
        this.user = user;
        this.life = this.maxLife;
    }

    public void update(){
        if(user == gp.player){ //daca proiectilul e folosit de player
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            if(monsterIndex != invalidIndex && monsterIndex != 14 && monsterIndex != 15 && monsterIndex != 16){
                gp.player.damageMonster(monsterIndex);
                alive = false;
            }
        }
        if(user != gp.player){ //daca proiectilul e folosit de monstru
            boolean contactPlayer = gp.cChecker.checkPlayer(this);
            if(gp.player.invincible == false && contactPlayer == true){
                damagePlayer(attack);
                alive = false;
            }
        }

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
        life--;
        if(life <= 0) {
            alive = false;
        }
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
}
