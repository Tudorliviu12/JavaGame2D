package object;

import javax.imageio.ImageIO;
import java.io.IOException;

//obiect collectable pentru nivelul 2, drept recompensa din partea NPC ului
public class OBJ_Pizza extends SuperObject{
    public OBJ_Pizza(){
        name = "Pizza";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/pizza.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
