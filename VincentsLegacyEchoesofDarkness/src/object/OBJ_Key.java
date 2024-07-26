package object;

import javax.imageio.ImageIO;
import java.io.IOException;

//obiect collectable pentru nivelul 2, in task ul dat de NPC
public class OBJ_Key extends SuperObject{
    public OBJ_Key(){
        name = "Key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
