package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

//obiect afisat pe ecran, folosit pentru a contoriza viata player ului
public class OBJ_Health extends SuperObject {
    public OBJ_Health(GamePanel gp){
        name = "Health";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/health1.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/health2.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/objects/health3.png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("/objects/health4.png"));
            image5 = ImageIO.read(getClass().getResourceAsStream("/objects/health5.png"));
            image6 = ImageIO.read(getClass().getResourceAsStream("/objects/health6.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
