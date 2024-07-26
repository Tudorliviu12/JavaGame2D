package object;

import javax.imageio.ImageIO;
import java.io.IOException;

//obiect collectable pentru nivelul 3, in urma indeplinirii task ului de la NPC
public class OBJ_Coffee extends SuperObject{
    public OBJ_Coffee(){
        name = "Coffee";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/coffee.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
